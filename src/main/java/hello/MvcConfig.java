package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Гога on 11.04.2016.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public ViewResolver getViewResolver() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}











































/*
    @RequestMapping("/keywordlist.html")
    public String keywordListView(HttpServletRequest httpServletRequest,
                                  ModelMap model,
                                  @RequestParam(value = "text", required = false) String text)
    {
        if (!httpServletRequest.isUserInRole("KeywordEditor"))
            return "KeywordEditor-keywordListView";

        if (text == null)
            text = "";
        Integer start = 0;
        Integer count = 100;
        Boolean showAll = false;
        Boolean onlyGetty = false;
        String sortField = (new String[]{"nameEn", "nameRu", "imageCount desc"})[0];

        logger.info("KeywordWorkService: text=" + text);
        List<KeywordWorkData> keywords = keywordWorkService.findByFirstLetters(text, start, count, showAll, onlyGetty, sortField);

        //noinspection unchecked
        model.put("keywords", keywords);

        return "KeywordEditor-keywordListView";
    }

    @RequestMapping(value = "/keywordmerge.html", method = RequestMethod.POST)
    public String keywordEditRequest(HttpServletRequest httpServletRequest,
                                     ModelMap model,
                                     @RequestParam(value = "mainKeywordId", required = true) Long mainKeywordId,
                                     @RequestParam(value = "mergeList", required = true) List<Long> mergeList
    )



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="keywords" type="java.util.List<fotobank.object.keyword.KeywordWorkData>"--%>
<table cellpadding="0" cellspacing="0" border="0" id="kewordlist">
<thead>
<tr>
<th>ENG</th>
<th>РУС</th>
<th>Статус</th>
<th>Кол. изоб.</th>
</tr>
</thead>
<tbody style="" id="keywordlistbody">
<c:forEach items="${keywords}" var="keyword">
<tr id="keywordlist${keyword.id}">
<td width="80">
<a href="${pageContext.request.contextPath}/keywordeditor/${keyword.id}/edit.html" onclick="return false;">
        ${keyword.nameEn}</a>
</td>
<td style="padding-left: 10px;">
        ${keyword.nameRu}
</td>
<td style="padding-left: 10px;">
        ${keyword.status}
</td>
<td style="padding-left: 10px;">
        ${keyword.imageCount}
</td>
</tr>
</c:forEach>
</tbody>
</table>

*/