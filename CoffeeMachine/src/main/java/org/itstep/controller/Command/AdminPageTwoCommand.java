package org.itstep.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminPageTwoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/page2.jsp";
    }
}
