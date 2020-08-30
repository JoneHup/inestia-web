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
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

        PageResultSet<News> resultSet = new PageResultSet<>();

        Page page = PageHelper.offsetPage(newsQuery.getOffset(), newsQuery.getLimit()).doSelectPage(()->
                newsMapper.selectByExample(example).forEach(e -> {
                    e.setCreatorName(userService.findOne(e.getCreator()).getUsername());
                    e.setModifyTime(DateUtil.toDateTimeString(e.getModifyDate()));
        }));

        List list = page.getResult();
        if (! CollectionUtils.isEmpty(list)) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                News news = (News) iterator.next();
                if (newsQuery.getNewsId() == news.getId()) {
                    iterator.remove();
                }
                news.setContent(newsContentMapper.selectByPrimaryKey(news.getPk_content()).getContent());
            }
        }

       /* for (Object o : page.getResult()) {
            News news = (News)o;
            news.setContent(newsContentMapper.selectByPrimaryKey(news.getPk_content()).getContent());
        }*/

        resultSet.setRows(page.getResult());
        resultSet.setRandomRows(page.getResult());
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    @Transactional
    public void createNews(News news) {
        NewsContent newsContent = new NewsContent();
        newsContent.setContent(news.getContent());
        newsContentMapper.insert(newsContent);

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByUsername(username);
        news.setCreator(user.getId());
        news.setCreateDate(new Date());
        news.setModifyDate(new Date());
        news.setPk_content(newsContent.getId());
        newsMapper.insertSelective(news);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        NewsContent newsContent = new NewsContent();
        newsContent.setId(news.getPk_content());
        newsContent.setContent(news.getContent());
        newsContentMapper.updateByPrimaryKeySelective(newsContent);

        news.setModifyDate(new Date());
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    @Transactional
    public void deleteNews(Long id) {
        newsMapper.deleteByPrimaryKey(id);
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
