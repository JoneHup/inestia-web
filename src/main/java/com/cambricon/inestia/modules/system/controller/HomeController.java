package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.utils.DateUtil;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Job;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.po.Process;
import com.cambricon.inestia.modules.system.po.Product;
import com.cambricon.inestia.modules.system.query.*;
import com.cambricon.inestia.modules.system.service.JobService;
import com.cambricon.inestia.modules.system.service.NewsService;
import com.cambricon.inestia.modules.system.service.ProcessService;
import com.cambricon.inestia.modules.system.service.ProductService;
import com.cambricon.inestia.modules.system.vo.ProcessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.SecondaryTable;
import java.util.*;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/6/1 10:00
 * @Version: 1.0
 **/
@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private JobService jobService;
    @Autowired
    private ProcessService processService;

    @GetMapping("/")
    public String home(NewsQuery newsQuery,Model model) {
        PageResultSet<News> pageResultSet = newsService.findByPage(newsQuery);
        model.addAttribute("resultSet", pageResultSet);
        return "home/index";
    }

    @GetMapping("/home/news")
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

    @GetMapping("/home/news/detail")
    public String newsDetail(NewsQuery newsQuery, Model model) {
        News news = newsService.findById(newsQuery);
        //获取更多新闻
        PageResultSet<News> pageResultSet = newsService.findByPage(newsQuery);
        model.addAttribute("news", news);
        model.addAttribute("resultSet", pageResultSet);
        return "home/newsdetail";
    }

    @GetMapping("/home/weinfo")
    public String weInfo(CustomQuery cusdomQuery,Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        JobQuery jobQuery = new JobQuery();
        PageResultSet<Job> page = jobService.findByPage(jobQuery);
        model.addAttribute("jobPage", page);
        return "home/weinfo";
    }

    @GetMapping("/home/solution")
    public String solution(CustomQuery cusdomQuery, Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        return "home/solution";
    }

    @GetMapping("/home/platform")
    public String platform(CustomQuery cusdomQuery, Model model) {
        model.addAttribute("cusdomQuery", cusdomQuery);
        ProcessQuery processQuery = new ProcessQuery();
        PageResultSet<Process> page = processService.findByPage(processQuery);
        List<ProcessVo> processList = getProcessList(page);
        model.addAttribute("processList", processList);
        return "home/platform";
    }

    private List<ProcessVo> getProcessList(PageResultSet<Process> page) {
        List<ProcessVo> list = new ArrayList<>();
        Set<Integer> years = new HashSet<>();
        for (Process row : page.getRows()) {
            years.add(DateUtil.getYear(row.getPublishDate()));
        }
        for (Integer year : years) {
            ProcessVo vo = new ProcessVo();
            vo.setYear(year);
            List<Process> processes = new ArrayList<>();
            List<Process> rows = page.getRows();
            for (int i = 0; i < rows.size(); i++) {
                if (DateUtil.getYear(rows.get(i).getPublishDate()) == year) {
                    if (i % 2 == 0) {
                        rows.get(i).setPosition("pos-left");
                    }else {
                        rows.get(i).setPosition("pos-right");
                    }
                    rows.get(i).setPublishTime(DateUtil.toMonthString(rows.get(i).getPublishDate()));
                    processes.add(rows.get(i));
                }
            }
            vo.setProcesses(processes);
            list.add(vo);
        }
        return list;
    }

    @GetMapping("/home/product")
    public String product(ProductQuery productQuery, Model model) {
        Product product = productService.findById(productQuery);
        model.addAttribute("product", product);
        model.addAttribute("productQuery", productQuery);
        if (! StringUtils.isEmpty(productQuery.getProductName())) {
            return "home/product_".concat(productQuery.getProductName());
        }
        return "home/product";
    }

    @GetMapping("/home/map")
    public String map() {
        return "home/map";
    }

    @GetMapping("/home/timeline")
    public String timeline() {
        return "home/timeline";
    }
}
