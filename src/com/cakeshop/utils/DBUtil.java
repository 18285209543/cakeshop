package com.cakeshop.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @author DBUtil
 * @Date 2020/3/30 10:21
 * @Description 获取数据库
 */
public class DBUtil {

    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }
}
