package servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(urlPatterns = "/test1",
            initParams={
                    @WebInitParam(name="username",value="zhangsan"),
                    @WebInitParam(name="password",value="123456"),
            })
    public class Test1 extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            ServletConfig servletConfig = getServletConfig();
            ServletContext servletContext = getServletContext();
            String username = servletConfig.getInitParameter("username");
            String password = servletConfig.getInitParameter("password");
            servletContext.setAttribute("username",username);
            servletContext.setAttribute("password",password);
            req.getRequestDispatcher("/test").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
        }
    }
