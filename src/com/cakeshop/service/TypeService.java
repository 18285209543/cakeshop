package com.cakeshop.service;

import com.cakeshop.dao.TypeDao;
import com.cakeshop.model.Type;

import java.sql.SQLException;

/**
 * @author TypeService
 * @Date 2020/3/30 18:33
 * @Description TODO
 */
public class TypeService {
    private TypeDao tDao = new TypeDao();


    // 处理类型
    public Type selectAll() {
        Type type = null;
        try {
            type = tDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

}
