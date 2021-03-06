package com.cakeshop.dao;

import com.cakeshop.model.Goods;
import com.cakeshop.utils.DBUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
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

    // 查询热销 新品
    public static List<Map<String, Object>> getGoodsList(int recommendType) throws SQLException {

        // 创建c3p0数据源
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());

        String sql = "select g.id, g.name,g.cover, g.price, t.name typename from recommend r, goods g, type t where type=? and r.goods_id=g.id and g.type_id=t.id";
        // MapListHandler  key value 返回多条
        //  List<Map<String, Object>> list = r.query(sql, new MapListHandler());

        // sql 接收的方法 参数...
        return r.query(sql, new MapListHandler(),recommendType);
    }

    // 条幅
    public static Map<String, Object> getScrollGoods() throws SQLException {

        // 创建c3p0数据源
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());

        String sql = "select g.id, g.name,g.cover, g.price from recommend r, goods g where type=1 and r.goods_id=g.id";
        // MapListHandler  key value返回1条
        return r.query(sql, new MapHandler());
    }


}
