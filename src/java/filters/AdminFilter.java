package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;

/**
 *
 * @author Aster
 */
public class AdminFilter implements Filter {
    


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        //before servlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("User");
        Role role = user.getRole();
        int role_id = role.getRoleId();
        
        if (role_id != 1) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("notes");
            return;
        }
        
        else if (role_id == 1) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("admin");
            return;
        }
        
            chain.doFilter(request, response);
        //after servlet
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {
 
    }
    
}
