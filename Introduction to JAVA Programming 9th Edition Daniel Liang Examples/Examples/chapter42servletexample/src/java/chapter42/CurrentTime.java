package chapter42;

import java.io.IOException;
import java.io.PrintWriter;

public class CurrentTime extends HttpServlet {
    /** Process the HTTP Get request */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<p>The current time is " + new java.util.Date());
	out.close(); // Close stream
    }
}
