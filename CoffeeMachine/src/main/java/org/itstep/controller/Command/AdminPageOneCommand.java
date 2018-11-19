package org.itstep.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminPageOneCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("AdminPageOne");
        return "/WEB-INF/admin/page1.jsp";
    }
}
