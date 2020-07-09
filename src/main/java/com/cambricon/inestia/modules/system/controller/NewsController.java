package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.annotation.SystemLog;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.core.utils.Result;
import com.cambricon.inestia.modules.system.base.BaseController;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.query.NewsQuery;
import com.cambricon.inestia.modules.system.service.NewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:39
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    @RequiresPermissions("news:view")
    public String page(Model model) {
        return "system/news";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("news:view")
    public PageResultSet<News> list(NewsQuery newsQuery) {
        return newsService.findByPage(newsQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("news:create")
    @SystemLog("创建新闻")
    public Result create(@Valid News news) {
        newsService.createNews(news);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("news:update")
    @SystemLog("更新新闻")
    public Result update(News news) {
        newsService.updateNews(news);
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("news:delete")
    @SystemLog("删除新闻")
    @PostMapping("/delete")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id->
        {
            News news = new News();
            news.setId(id);
            news.setDr(true);
            newsService.updateNews(news);
        });
        return Result.success();
    }
}
