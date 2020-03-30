package com.cakeshop.dao;

import com.cakeshop.model.Type;
import com.cakeshop.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author TypeDao
 * @Date 2020/3/30 18:25
 * @Description 蛋糕系列
 */
public class TypeDao {


    public Type selectAll() throws SQLException {
        QueryRunner  r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from type";

        return r.query(sql, new BeanHandler<Type>(Type.class));

    }

}
