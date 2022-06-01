package TemplateMethod;


import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: hy (huyong@bsoft.com.cn)
 * @create: 2022/5/12
 * 需求：查询数据库里的记录，创建连接，创建statement并执行查询语句，处理查询结果
 * 问题：使用模板方法模式对于不同的查询结果进行不同的处理，容易引发子类泛滥问题
 * 解决：引入回调,使用了Java的匿名类来回调类处理查询结果
 *
 * 结合使用了模板方法模式和回调，避免了类的泛滥，
 * 此模式在Spring框架里使用十分广泛，
 * 参看其关于ORM（Object-Relational Mapping）框架和Jdbc框架的源码
 */
public class SelectSqlDataTemplate {
    public  <T> T query(String querySql,ResultDealHandler<T> handler) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //创建连接
            connection = getConnection();
            //执行查询语句
            statement = connection.prepareStatement(querySql);
            ResultSet resultSet = statement.executeQuery();
            //处理查询结果
            return handler.handler(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
            statement.close();
        }
        return null;
    }

    private Connection getConnection() {
        return  null;
    }

    public static void main(String[] args) throws SQLException {
        //查询一个数据
        Integer query = new SelectSqlDataTemplate().query("select Count(*) from user", new ResultDealHandler<Integer>() {
            @Override
            public Integer handler(ResultSet resultSet) {
                
                return Integer.MIN_VALUE;

            }
        });
    }

}
//使用泛型 泛型是指能够在运行时动态得到对象类型的一种能力。
// 其实Java是在编译时为生成的二进制代码加入强制类型转换的语句，并非真正在运行时得到对象的类型。
interface ResultDealHandler<T>{
    T handler(ResultSet resultSet);
}
