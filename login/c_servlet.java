package prac4_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/login", "/logout"})
public class c_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/login".equals(path)) {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
                // User is already logged in; show the welcome page
                response.setContentType("text/html");
                response.getWriter().println("<html><body><h2>Welcome, " + session.getAttribute("username") + "!</h2><form action='logout' method='post'><input type='submit' value='Logout'></form></body></html>");
            } else {
                // No session or user not logged in; show the login form
                response.setContentType("text/html");
                response.getWriter().println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Login</title></head><body><h2>Login</h2><form action='login' method='post'><label for='username'>Username:</label><input type='text' id='username' name='username' required><br><br><label for='password'>Password:</label><input type='password' id='password' name='password' required><br><br><input type='submit' value='Login'></form></body></html>");
            }
        } else if ("/logout".equals(path)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            // Redirect to the login page after logout
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/login".equals(path)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String validUsername = "abc";
            String validPassword = "xyz";

            response.setContentType("text/html");

            if (validUsername.equals(username) && validPassword.equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.getWriter().println("<html><body><h2>Login Successful!</h2><form action='logout' method='post'><input type='submit' value='Logout'></form></body></html>");
            } else {
                response.getWriter().println("<html><body><h2>Invalid Credentials. Please try again.</h2><a href='login'>Back to login</a></body></html>");
            }
        }
    }
}
