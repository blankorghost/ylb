package com.views.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.views.entity.Essay;
import com.views.entity.keyword;
import com.views.service.SearchService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Namespace("/views")
@Controller("searchAction")
@Scope("prototype")
public class SearchAction extends ActionSupport {
    @Resource
    private SearchService searchService;
    private keyword keyword;

    public void setKeyword(keyword keyword) {
        this.keyword = keyword;
    }

    @Action(value = "search", results = {@Result(name = "success", location = "/views/search.jsp", type = "redirect"), @Result(name = "error", location = "/views/error.jsp")})
    public String search() {
        Map session = ActionContext.getContext().getSession();
        System.out.println(keyword.getKeyword());
        List<Essay> searchResult = searchService.search(keyword.getKeyword());
        if (searchResult != null) {
            session.put("searchresult", searchResult);
            return SUCCESS;
        }
        return ERROR;
    }

    public keyword getKeyword() {
        return keyword;
    }
}
