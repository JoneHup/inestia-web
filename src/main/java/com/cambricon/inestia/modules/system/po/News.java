package com.cambricon.inestia.modules.system.po;

import com.cambricon.inestia.core.utils.DateUtil;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:23
 * @Version: 1.0
 **/
@Table(name="sys_news")
public class News {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String newsTitle;

    /**
     * 创建时间
     */
    private Date createDate;

    @Transient
    private String createTime;

    /**
     * 修改时间
     */
    private Date modifyDate;

    @Transient
    private String modifyTime;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建人名称
     */
    @Transient
    private String creatorName;

    /**
     * 来源
     */
    private String source;

    /**
     * 删除标识
     */
    private Boolean dr = Boolean.FALSE;

    @Transient
    private int year;
    @Transient
    private int month;
    @Transient
    private int day;

    private Long pk_content;

    /**
     * 内容
     */
    @Transient
    private String content;

    /**
     * 去除html标签的内容
     */
    @Transient
    private String contentExt;

    @Transient
    private String img;

    /**
     * 封页图片序号
     */
    private String imgNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        doSetImg();
        doSetContentExt();
    }

    private void doSetContentExt() {
        //定义script的正则表达式，去除js可以防止注入
        String scriptRegex="<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式，去除style样式，防止css代码过多时只截取到css样式代码
        String styleRegex="<style[^>]*?>[\\s\\S]*?<\\/style>";
        //定义HTML标签的正则表达式，去除标签，只提取文字内容
        String htmlRegex="<[^>]+>";
        //定义空格,回车,换行符,制表符
        String spaceRegex = "\\s*|\t|\r|\n";

        // 过滤script标签
        this.contentExt = this.content.replaceAll(scriptRegex, "");
        // 过滤style标签
        this.contentExt = this.contentExt.replaceAll(styleRegex, "");
        // 过滤html标签
        this.contentExt = this.contentExt.replaceAll(htmlRegex, "");
        // 过滤空格等
        this.contentExt = this.contentExt.replaceAll(spaceRegex, "");
        this.contentExt.trim(); // 返回文本字符串
        if (this.contentExt.length() > 60){
            this.contentExt = this.contentExt.substring(0, 60);
        }
    }

    private void doSetImg() {
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        Pattern pattern = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            Matcher matcherCd = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(matcher.group());
            int index = 0;
            while (matcherCd.find()){
                index ++;
                if (! StringUtils.isEmpty(this.imgNum)) {
                    if (index == Integer.parseInt(this.imgNum)) {
                        this.img = matcherCd.group(1);
                        break;
                    }
                } else { //如果不指定图片索引，默认显示第一张
                    this.img = matcherCd.group(1);
                    break;
                }

            }
            if (! StringUtils.isEmpty(this.img)){
                break;
            }
        }
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        this.createTime = DateUtil.toDateTimeString(this.createDate);
    }

    public String getCreateTime() {
        return createTime;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        this.modifyTime = DateUtil.toDateTimeString(this.modifyDate);
        Calendar instance = Calendar.getInstance();
        instance.setTime(modifyDate);
        this.year = instance.get(Calendar.YEAR);
        this.month = instance.get(Calendar.MONTH);
        this.day = instance.get(Calendar.DATE);
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getImg() {
        return img;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getContentExt() {
        return contentExt;
    }

    public void setContentExt(String contentExt) {
        this.contentExt = contentExt;
    }

    public Long getPk_content() {
        return pk_content;
    }

    public void setPk_content(Long pk_content) {
        this.pk_content = pk_content;
    }

    public String getImgNum() {
        return imgNum;
    }

    public void setImgNum(String imgNum) {
        this.imgNum = imgNum;
    }
}
