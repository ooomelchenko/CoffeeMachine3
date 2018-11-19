package org.itstep.controller.Command;

import org.itstep.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {
    static void setUserRole(HttpServletRequest request,
                     User.ROLE role, String name) {
        HttpSession session = request.getSession();
      //  ServletContext context = request.getServletContext();
        session.setAttribute("userName", name); //fix context.setAttribute("userName", name);
        session.setAttribute("role", role);
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String userName){
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext() //fix .getSession()
        .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(userName::equals)){
            return true;
        }
        loggedUsers.add(userName);
        request.getServletContext() //fix .getSession()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }
}
