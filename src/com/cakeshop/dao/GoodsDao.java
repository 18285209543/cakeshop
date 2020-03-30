package com.cakeshop.dao;

import com.cakeshop.model.Goods;
import com.cakeshop.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author GoodsDao
 * @Date 2020/3/30 10:59
 * @Description dao层 只负责数据库操作
 */
public class GoodsDao {
    public static void main(String[] args) {
        try {
           getSql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getSql(){
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        System.out.println(111);
        String sql = "select * from goods";

        try {
            List<Goods> list = (List<Goods>) r.query(sql, new BeanHandler<Goods>(Goods.class));

            for(Goods g:list){
                System.out.println(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // 查询首页
    public static List<Map<String, Object>> getHotGoodsList() throws SQLException {

        // 创建c3p0数据源
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());

        String sql = "select g.id, g.name,g.cover, g.price, t.name typename from recommend r, goods g, type t where type=2 and r.goods_id=g.id and g.type_id=t.id";
        // 这里使用MapListHandler处理返回数据
          List<Map<String, Object>> list = r.query(sql, new MapListHandler());


           return r.query(sql, new MapListHandler());
    }
}
