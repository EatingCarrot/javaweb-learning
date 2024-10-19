package servlet.chapter3;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        HttpSession session = req.getSession(false);
        if(session == null){
//            resp.sendRedirect("shop.html");
            resp.getWriter().write("[]");
            return;
        }
        Object attribute = session.getAttribute("cart");
        List<Good> goods1 = new ArrayList<>();
        if(attribute != null){
            Map<Integer,Integer> cardMap = (Map<Integer, Integer>) attribute;
            for (Map.Entry<Integer, Integer> entry : cardMap.entrySet()){
                Integer id = entry.getKey();
                Good good = GoodDB.getGood(id);
                Integer count = entry.getValue();
                good.setCount(count);
                goods1.add(good);
            }
        }
        resp.getWriter().write(JSON.toJSONString(goods1));
    }
}
