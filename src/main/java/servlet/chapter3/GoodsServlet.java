package servlet.chapter3;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/goodsList")
public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        // 获取商品列表
        List<Good> goods = GoodDB.getGoods();
        HttpSession session = req.getSession(false);
        // 获取seesion
        if(session == null){
            String jsonData = JSON.toJSONString(goods);
            resp.getWriter().write(jsonData);
            return;
        }
        // 获取购物车数据
        Object attribute = session.getAttribute("cart");
        if(attribute == null){
            String jsonData = JSON.toJSONString(goods);
            resp.getWriter().write(jsonData);
            return;
        }
        // 组合后返回页面
        Map<Integer,Integer> cardMap = (Map<Integer, Integer>) attribute;
        for (Good good : goods){
            Integer count = cardMap.get(good.getId());
            if(count != null){
                good.setCount(count);
            }else {
                good.setCount(0);
            }
        }
        String jsonData = JSON.toJSONString(goods);
        resp.getWriter().write(jsonData);
    }
}
