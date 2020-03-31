package com.cakeshop.servlet;

import com.cakeshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//访问网站时使用的
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private GoodsService gs = new GoodsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 取得条幅商品
        Map<String, Object> scrollGoods =  gs.getScrollGoods();
        request.setAttribute("scroll", scrollGoods);

        // 取得热销商品
        List<Map<String, Object>> list =  gs.getHotGoodsList();
        request.setAttribute("hotList", list);

        // 取得新品商品
        List<Map<String, Object>> newlist =  gs.getNewGoodsList();
        request.setAttribute("newList", newlist);


        // 跳转到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
