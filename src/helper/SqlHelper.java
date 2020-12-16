package helper;

import java.sql.*;
import java.util.Random;

public class SqlHelper {

    //定义需要的变量
    private Connection ct = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            String uri =
                    "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=warehouse";
            String user = "sa";
            String password = "";
            ct = DriverManager.getConnection(uri, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    public ResultSet executeQuery(String sql, String[] parameters) {
        try {
            ct = getConnection();
            ps = ct.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);//生成可滚动游标
            if (parameters != null && !parameters[0].equals("")) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {

        }
        return rs;
    }
    public int executeUp(String sql) {
        int affect = 0;
        try {
            ct = getConnection();
            Statement statement = ct.createStatement();
            affect=statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("当前位于SqlHelper中，executeUpdate语句执行失败！原因如下：");
            System.out.println(e);
        } finally {

        }
        return affect;
    }



//    public void Insert() {
//        try {
//            ct = getConnection();
//            Statement statement = ct.createStatement();
//            String[] sex_choise = {"male", "female"};
//            Random rand = new Random();
//            for (int i = 11; i <= 20; i++) {
//                //String sql_string = "INSERT into Student VALUES ('" + String.valueOf(8000+i) + "','" + String.valueOf(10+rand.nextInt(20)) + "','";
//                String sql_string = "INSERT into Student VALUES ('" + (8000+i) + "'," + (10+rand.nextInt(20));
//                sql_string += ",'" + sex_choise[rand.nextInt(1)] + "'";//sex
////                sql_string += ",'" + (1000+rand.nextInt(9000)) + "'";//phone
//                sql_string += ",'" + (100+rand.nextInt(900)) + "'";//sname
//                sql_string += ",'" + "cs'";//sdept
//                sql_string += ")";
//                System.out.println(sql_string);
//                //注意因为有下面这一句，所以必须放到trycatch语句中
//                int rows = statement.executeUpdate(sql_string);//注意是返回一个整数，所以不能用res接着
//
//                System.out.println("插入完成，返回：" + rows);
//            }
//        } catch (SQLException e) {//SqlException只在执行SQL方法时才有，所以在StuModel中直接用Exception就好了，其实这里也可以直接写Exception，因为是继承关系
//            System.out.println("当前位于SqlHelper中，插入失败！原因如下：");
//            System.out.println(e);
//        } finally {
//
//        }
//
//    }

    public void close() {

        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (ct != null) ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}




