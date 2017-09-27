package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemDomain.User;

/**
 *
 * @author 679918
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the parameters from the URL
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {

            request.setAttribute("errorMessage", "Both values are required!");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            return;
        }

        UserService us = new UserService();
        boolean valid = us.login(user.getUsername(), user.getPassword());

        if (!valid) {
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("errorMessage", "Invalid username or password!");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        request.setAttribute("username", user.getUsername());
        request.setAttribute("password", user.getPassword());
        getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);

    }

}
