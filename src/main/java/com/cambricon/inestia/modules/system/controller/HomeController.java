package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Job;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.po.Product;
import com.cambricon.inestia.modules.system.query.CustomQuery;
import com.cambricon.inestia.modules.system.query.JobQuery;
import com.cambricon.inestia.modules.system.query.NewsQuery;
import com.cambricon.inestia.modules.system.query.ProductQuery;
import com.cambricon.inestia.modules.system.service.JobService;
import com.cambricon.inestia.modules.system.service.NewsService;
import com.cambricon.inestia.modules.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/6/1 10:00
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private JobService jobService;

    @GetMapping("/index")
    public String home(NewsQuery newsQuery,Model model) {
        PageResultSet<News> pageResultSet = newsService.findByPage(newsQuery);
        model.addAttribute("resultSet", pageResultSet);
        return "home/index";
    }

    @GetMapping("/news")
    public String news(NewsQuery newsQuery, Model model) {
        News news = newsService.findLatestNews();
        if (null != news) {
            newsQuery.setNewsId(news.getId());
        }
        PageResultSet<News> pageResultSet = newsService.findByPage(newsQuery);
        pageResultSet.setCurrentPage(newsQuery.getCurrentPage());
        model.addAttribute("firNews", news);
        model.addAttribute("resultSet", pageResultSet);
        return "home/news";
    }

    @GetMapping("/news/detail")
    public String newsDetail(NewsQuery newsQuery, Model model) {
        News news = newsService.findById(newsQuery);
        //获取更多新闻
        PageResultSet<News> pageResultSet = newsService.findByPage(newsQuery);
        model.addAttribute("news", news);
        model.addAttribute("resultSet", pageResultSet);
        return "home/newsdetail";
    }

    @GetMapping("/weinfo")
    public String weInfo(CustomQuery cusdomQuery,Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        JobQuery jobQuery = new JobQuery();
        PageResultSet<Job> page = jobService.findByPage(jobQuery);
        model.addAttribute("jobPage", page);
        return "home/weinfo";
    }

    @GetMapping("/contactus")
    public String contactUs(CustomQuery cusdomQuery, Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        return "home/solution";
    }

    @GetMapping("/platform")
    public String platform(CustomQuery cusdomQuery, Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        return "home/platform";
    }

    @GetMapping("/product")
    public String product(ProductQuery productQuery, Model model) {
        Product product = productService.findById(productQuery);
        model.addAttribute("product", product);
        if (! StringUtils.isEmpty(productQuery.getProductName())) {
            return "home/product_".concat(productQuery.getProductName());
        }
        return "home/product";
    }

    @GetMapping("/map")
    public String map() {
        return "home/map";
    }
}
