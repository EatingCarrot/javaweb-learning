package servlet.chapter2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 设置HTTP响应头，实现5秒后跳转
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Refresh", "2;url=http://localhost:8081/firstweb/second");

        // 输出提示信息
        response.getWriter().println("<html><head><title>Redirecting...</title></head>");
        response.getWriter().println("<body><h1>页面将在2秒后跳转到second</h1>");
        response.getWriter().println("</body></html>");
//        requestDispatcher.include(request,response);
//        response.resetBuffer();
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
