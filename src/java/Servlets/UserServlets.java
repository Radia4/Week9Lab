package Servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author radia
 */
public class UserServlets extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String edit = request.getParameter("update");
        String delete = request.getParameter("delete");
        String email = request.getParameter("email");
        
        try {
            List<User> users = (new UserService()).getAll();
            request.setAttribute("users", users);
            List<Role> roles = (new RoleService()).getAll();
            request.setAttribute("roles", roles);
            
            if(edit != null && email != null && !email.equals("")) {
                User user = (new UserService()).get(email);
                request.setAttribute("user", user);
            }
            
            if(delete != null && email != null && !email.equals("")) {
                (new UserService()).delete(email);
                request.setAttribute("users", null);
                response.sendRedirect("");
                return;
            }
            
            rd.forward(request, response);
            return;
        } catch (Exception e) {
            Logger.getLogger(UserServlets.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "error");
            return;
        }
       
    }
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/users.jsp");
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("_action");
        String email = request.getParameter("email");
        String active = request.getParameter("active");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        try {
            if(action != null && action.equals("add user")) {
                (new UserService()).insert(email, active == null ? 0 : 1, firstName, lastName, password, 
                        Integer.parseInt(role));
                response.sendRedirect("");
                return;
            }
            if(action != null && action.equals("update")) {
                (new UserService()).update(email, active == null ? 0 : 1, firstName, lastName, password, 
                        Integer.parseInt(role));
                response.sendRedirect("");
                return;
            }
            if(action != null && action.equals("cancel")) {
                (new UserService()).update(email, active == null ? 0 : 1, firstName, lastName, password, 
                        Integer.parseInt(role));
                request.setAttribute("message", "Cancelled");
                return;
            }
            response.sendRedirect("");
            return;
        } catch (Exception e) {
            Logger.getLogger(UserServlets.class.getName()).log(Level.SEVERE, null, e);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/users.jsp");
    }
 
}