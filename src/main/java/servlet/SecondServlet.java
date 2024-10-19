package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置msg
        response.setContentType("text/html;charset=UTF-8");
        // 设置HTTP响应头，实现5秒后跳转
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Refresh", "2;url=http://localhost:8081/firstweb/index.jsp");
        // 输出提示信息
        response.getWriter().println("<html><head><title>Redirecting...</title></head>");
        response.getWriter().println("<body><h1>页面将在2秒后跳转到test1</h1>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
