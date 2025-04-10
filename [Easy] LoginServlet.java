import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    if ("admin".equals(user) && "1234".equals(pass)) {
      out.println("<h1>Welcome, " + user + "!</h1>");
    } else {
      out.println("<h1>Invalid credentials</h1>");
    }
  }
}
