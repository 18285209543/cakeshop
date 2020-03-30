package com.cakeshop.dao;

import com.cakeshop.model.Goods;
import com.cakeshop.utils.DBUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GoodsDao
 * @Date 2020/3/30 10:59
 * @Description dao层 只负责数据库操作
 */
public class GoodsDao {
    public static void main(String[] args) throws SQLException {
//        DataSource ds = new ComboPooledDataSource();
//        Connection con = ds.getConnection();
//        PreparedStatement ps = con.prepareStatement("select * from goods");
//
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getString("name"));
//        }
//
//        rs.close();
//        ps.close();
//        con.close();

    }


    // 查询首页
    public static List<Map<String, Object>> getGoodsList(int recommendType) throws SQLException {

        // 创建c3p0数据源
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());

        String sql = "select g.id, g.name,g.cover, g.price, t.name typename from recommend r, goods g, type t where type=? and r.goods_id=g.id and g.type_id=t.id";
        // 这里使用MapListHandler处理返回数据
        //  List<Map<String, Object>> list = r.query(sql, new MapListHandler());


           return r.query(sql, new MapListHandler(),recommendType);
    }
}
