package org.itstep.controller;

import org.itstep.controller.Command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout",
                new LogOutCommand());
        commands.put("login",
                new LoginCommand());
        commands.put("admin",
                new AdminCommand());
        commands.put("user",
                new UserCommand());
        commands.put("adminMenu",
                new AdminMenuCommand());
        commands.put("admin/page1",
                new AdminPageOneCommand());
        commands.put("admin/page2",
                new AdminPageTwoCommand());
        commands.put("admin/page3",
                new AdminPageThreeCommand());

        commands.put("exception" , new ExceptionCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
        //response.getWriter().print("Hello from servlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("processRequest, path="+path);
      //  path = path.replaceAll(".*/coffee/" , "");
        path = path.replaceAll(".*/coffee/" , "");
        System.out.println("processRequest, pathAfterReplace="+path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println("command.getClass().getName() = "+command.getClass().getName());
        String page = command.execute(request);
        System.out.println("String page = command.execute(request) = "+page);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace(":redirect", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
