package org.itstep.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminPageThreeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/page3.jsp";
    }
}
