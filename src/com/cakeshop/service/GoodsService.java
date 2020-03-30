package com.cakeshop.service;

import com.cakeshop.dao.GoodsDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author GoodsService
 * @Date 2020/3/30 11:00
 * @Description 处理业务逻辑层
 */
public class GoodsService {

    private GoodsDao gDao = new GoodsDao();
    public List<Map<String, Object>> getHotGoodsList(){
        List<Map<String, Object>> list = null;
        try {
             list = gDao.getHotGoodsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}