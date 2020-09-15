package com.cambricon.inestia.modules.system.service.impl;

import com.cambricon.inestia.core.utils.DateUtil;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.mapper.NewsContentMapper;
import com.cambricon.inestia.modules.system.mapper.NewsMapper;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.po.NewsContent;
import com.cambricon.inestia.modules.system.po.User;
import com.cambricon.inestia.modules.system.query.NewsQuery;
import com.cambricon.inestia.modules.system.service.NewsService;
import com.cambricon.inestia.modules.system.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:32
 * @Version: 1.0
 **/
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsContentMapper newsContentMapper;

    @Override
    public PageResultSet<News> findByPage(NewsQuery newsQuery) {
        /*if (!StringUtils.isEmpty(newsQuery.getOrderBy())) {
            PageHelper.orderBy(newsQuery.getOrderBy());
        }*/
        PageHelper.orderBy("modify_date desc");

        Weekend example = Weekend.of(News.class);
        WeekendCriteria<News, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(newsQuery.getTitle())) {
            criteria.andLike(News::getNewsTitle, "%" + newsQuery.getTitle() + "%");
        }

        newsQuery.setDr(false);
        criteria.andEqualTo(News::getDr,newsQuery.getDr());

        if (null != newsQuery.getNewsId()){
            criteria.andNotEqualTo(News::getId,newsQuery.getNewsId());
        }

        PageResultSet<News> resultSet = new PageResultSet<>();

        Page page = PageHelper.offsetPage(newsQuery.getOffset(), newsQuery.getLimit()).doSelectPage(()->
                newsMapper.selectByExample(example).forEach(e -> {
                    User user = userService.findOne(e.getCreator());
                    if(null != user) {
                        e.setCreatorName(user.getUsername());
                    }
                    e.setModifyTime(DateUtil.toDateTimeString(e.getModifyDate()));
        }));

        /*List list = page.getResult();
        if (! CollectionUtils.isEmpty(list)) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                News news = (News) iterator.next();
                if (newsQuery.getNewsId() == news.getId()) {
                    iterator.remove();
                }
                news.setContent(newsContentMapper.selectByPrimaryKey(news.getPk_content()).getContent());
            }
        }*/

        for (Object o : page.getResult()) {
            News news = (News)o;
            news.setContent(newsContentMapper.selectByPrimaryKey(news.getPk_content()).getContent());
        }

        resultSet.setRows(page.getResult());
        resultSet.setRandomRows(page.getResult());
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    public News findById(NewsQuery newsQuery) {
        News news = newsMapper.selectByPrimaryKey(newsQuery.getNewsId());
        NewsContent newsContent = newsContentMapper.selectByPrimaryKey(news.getPk_content());
        news.setContent(newsContent.getContent());
        return news;
    }

    @Override
    public News findLatestNews() {
        News news = newsMapper.selectLatestNews();
        if (null != news) {
            NewsContent newsContent = newsContentMapper.selectByPrimaryKey(news.getPk_content());
            news.setContent(newsContent.getContent());
        }
        return news;
    }
}
