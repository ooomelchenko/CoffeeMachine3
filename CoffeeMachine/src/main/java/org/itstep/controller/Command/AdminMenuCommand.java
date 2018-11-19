package org.itstep.controller.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdminMenuCommand implements Command {
    private final static Map<String, String> pages = new ConcurrentHashMap<>();
    static {
        pages.put("page1", "admin/page1:redirect");
        pages.put("page2", "admin/page2:redirect");
        pages.put("page3", "admin/page3:redirect");
    }
    @Override
    public String execute(HttpServletRequest request) {

        String reqPage = request.getParameter("page");

        return pages.getOrDefault(reqPage, "/WEB-INF/error.jsp");
    }
}
