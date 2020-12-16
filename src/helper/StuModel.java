package helper;

import java.sql.*;
import java.util.Random;
import javax.swing.table.*;

public class StuModel {
    Object data[][];
    Object columnName[];
    int rows=0,columns=0;//行数、列数

    public StuModel(String sql,String params[]){
        SqlHelper sqlhelper=null;
        try{
            sqlhelper=new SqlHelper();
            ResultSet rs=sqlhelper.executeQuery(sql, params);

            rs.last();
            rows=rs.getRow();//获取结果集行数
            rs.beforeFirst();

            ResultSetMetaData rsmd=rs.getMetaData();
            columns=rsmd.getColumnCount();//获取结果集列数
            columnName=new Object[columns];//获取结果集列名
            for (int i=0;i<columns;i++){
                columnName[i]=rsmd.getColumnName(i+1);
            }
            data=new Object[rows][columns];

            int j=0;
            while(rs.next()){
                for (int i=0;i<columns;i++){
                    data[j][i]=rs.getString(i+1);
                }
                j++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sqlhelper.close();
        }
    }
    public int delete_data(String del_Sno) {
        /*
         * 输入要删除的学生学号，返回SQL语句操作影响的行数，默认返回值为0
         * */
        int affect = 0;
        SqlHelper sqlhelper = null;
        String sql = "delete from Student where Sno='" + del_Sno + "'";
        try {
            sqlhelper = new SqlHelper();
            affect = sqlhelper.executeUp(sql);
        }catch (Exception e) {
            System.out.println("当前在Model中，删除失败！原因如下：");
            System.out.println(e);
        } finally {
            sqlhelper.close();
        }
        return affect;
    }
    public int insert_data(String add_one_item) {
        SqlHelper sqlhelper=null;
        int affect = 0;
        try {
            sqlhelper = new SqlHelper();
            affect = sqlhelper.executeUp(add_one_item);
        }catch (Exception e) {
            System.out.println("当前在Model中，插入失败！原因如下：");
            System.out.println(e);
        }finally {
            sqlhelper.close();
        }
        return affect;
    }
    public Object[][] getData() {
        return data;
    }

    public Object[] getColumnName() {
        return columnName;
    }



}
