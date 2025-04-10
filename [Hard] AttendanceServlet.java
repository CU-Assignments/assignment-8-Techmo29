import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String studentId = request.getParameter("studentId");
    String date = request.getParameter("date");
    String status = request.getParameter("status");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "password");

      PreparedStatement pst = con.prepareStatement("INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)");
      pst.setString(1, studentId);
      pst.setString(2, date);
      pst.setString(3, status);
      pst.executeUpdate();

      con.close();
      response.sendRedirect("success.jsp");
    } catch (Exception e) {
      response.getWriter().println("Database Error: " + e.getMessage());
    }
  }
}
