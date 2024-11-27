package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class java_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the login HTML page
        request.getRequestDispatcher("/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // For simplicity, we'll use hardcoded credentials
        String validusername = "abc";
        String validPassword = "123";

        // Check if the credentials are correct
        response.setContentType("text/html");
        if (validusername.equals(username) && validPassword.equals(password)) {
            response.getWriter().println("<html><body><h2>Login Successful!</h2><a href='login.html'>logout</a>\r\n"
            		+ "</body></html>");
        } else {
            response.getWriter().println("<html><body><h2>Invalid Credentials. Please try again.</h2></body></html>");
        }
    }
}
