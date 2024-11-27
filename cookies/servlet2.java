package pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servlet2 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set content type of the response
        resp.setContentType("text/html");
        
        // Get the cookies from the request
        Cookie[] cookies = req.getCookies();
        String userName = "Guest";  // Default name if cookie not found

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }
        
        // Write the HTML response
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Hello</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, " + userName + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
