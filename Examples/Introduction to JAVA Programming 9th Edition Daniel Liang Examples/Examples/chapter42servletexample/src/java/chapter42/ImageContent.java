package chapter42;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ImageContent extends HttpServlet {
  /**
   * Process the HTTP Get request
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String country = request.getParameter("country");

    out.println("<img src = \"resources/image/" + country + ".gif" + "\" align=left>");

    // Read description from a file and send it to the browser
    java.util.Scanner input = new java.util.Scanner(new File("c:\\book\\" + country + ".txt"));

    // Read a line from the text file and send it to the browser
    while (input.hasNext())
      out.println(input.nextLine());

    out.close();
  }
}
