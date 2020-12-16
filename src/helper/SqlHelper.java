package helper;

import java.sql.*;
import java.util.Random;

public class SqlHelper {

    //������Ҫ�ı���
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
                    ResultSet.CONCUR_READ_ONLY);//���ɿɹ����α�
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
            System.out.println("��ǰλ��SqlHelper�У�executeUpdate���ִ��ʧ�ܣ�ԭ�����£�");
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
//                //ע����Ϊ��������һ�䣬���Ա���ŵ�trycatch�����
//                int rows = statement.executeUpdate(sql_string);//ע���Ƿ���һ�����������Բ�����res����
//
//                System.out.println("������ɣ����أ�" + rows);
//            }
//        } catch (SQLException e) {//SqlExceptionֻ��ִ��SQL����ʱ���У�������StuModel��ֱ����Exception�ͺ��ˣ���ʵ����Ҳ����ֱ��дException����Ϊ�Ǽ̳й�ϵ
//            System.out.println("��ǰλ��SqlHelper�У�����ʧ�ܣ�ԭ�����£�");
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




