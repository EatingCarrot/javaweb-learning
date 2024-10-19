package servlet.chapter3;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet("/cartAdd")
public class CartAddServlet extends HttpServlet {

    private void doOptions(HttpServletResponse resp) throws IOException {

        resp.getWriter().write("{\"code\":400}");
        resp.getWriter().write("参数错误");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post方法
        if (Objects.equals(req.getMethod(), "POST")){
            resp.setContentType("application/json;charset=utf-8");
            // 获取请求体中的数据
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null){
                sb.append(line);
            }
            //解析数据
            JSONObject jsonObject = JSON.parseObject(sb.toString());
            Integer id = jsonObject.getInteger("id");
            Integer count = jsonObject.getInteger("count");
            if(Objects.isNull(id) || Objects.isNull(count)){
                // 返回json字符串
                doOptions(resp);
                return;
            }
            //获取用户session
            HttpSession session = req.getSession(true);
            Object attribute = session.getAttribute("cart");
            // 没有购物车就新建一个购物车
            if(attribute == null){
                Map<Integer, Integer> objectObjectHashMap = new HashMap<>();
                objectObjectHashMap.put(id, count);
                session.setAttribute("cart", objectObjectHashMap);
            }else {
                // 获取购物车, 判断是否包含该商品
                Map<Integer, Integer> cart = (Map<Integer, Integer>) attribute;
                if (count>0){
                    cart.put(id, count);
                }else{
                    cart.remove(id);
                }
            }
            resp.getWriter().write("{\"code\":200}");
        }
    }
}
