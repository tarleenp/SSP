package pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servlet1 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the username from the form
        String userName = req.getParameter("userName");
        
        // Create a cookie with the name and value
        Cookie c = new Cookie("name", userName);
        
        // Add the cookie to the response
        resp.addCookie(c);
        
        // Set content type of the response
        resp.setContentType("text/html");
        
        // Write the HTML response
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Welcome</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + userName + "!</h1>");
            out.println("<form action='servlet2' method='post'>");
            out.println("<input type='submit' value='Go'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
