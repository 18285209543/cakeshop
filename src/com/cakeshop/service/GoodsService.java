package com.cakeshop.service;

import com.cakeshop.dao.GoodsDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author GoodsService
 * @Date 2020/3/30 11:00
 * @Description service层 处理业务逻辑层
 */
public class GoodsService {

    private GoodsDao gDao = new GoodsDao();
    // 热销
    public List<Map<String, Object>> getHotGoodsList(){
        List<Map<String, Object>> list = null;
        try {
             list = gDao.getGoodsList(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 新品
    public List<Map<String, Object>> getNewGoodsList(){
        List<Map<String, Object>> list = null;
        try {
            list = gDao.getGoodsList(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 条幅
    public Map<String, Object> getScrollGoods(){
        Map<String, Object> list = null;
        try {
           list = gDao.getScrollGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
