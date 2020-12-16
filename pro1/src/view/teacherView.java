package view;

import javax.swing.*;
import helper.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class teacherView extends JFrame {
    JPanel panelLeft;
    JTable jt = null;
    JScrollPane jsp = null;
    StuModel smodel;
    JLabel opr_result_label = null;
    JSplitPane myPanel;
    String select_all = "select * from Student";
    public void display(String sql_string) {
        Object data[][];
        Object columnName[];
        String temp[] = {""};
        smodel = new StuModel(sql_string, temp);
        //int is_del = smodel.delete_data("8020");
        //System.out.println(is_del);
        //if (is_del == 1) System.out.println("删除成功！影响数据库行数为：" + is_del);
        //else System.out.println("删除失败！影响数据库行数为：" + is_del);
        data = smodel.getData();
        columnName = smodel.getColumnName();
        jt = new JTable(data, columnName);
        jsp = new JScrollPane(jt);
        myPanel.setRightComponent(jsp);
    }
    public void del_one_item() {
        JTextField del_sno_jtest = new JTextField();
        del_sno_jtest.addFocusListener(new JTextFieldHintListener(del_sno_jtest, "请输入想要删除的学号..."));
        JButton btn = new JButton("确认");
        panelLeft.add(del_sno_jtest);
        panelLeft.add(btn);
        panelLeft.add(opr_result_label);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int is_del = smodel.delete_data("8020");
                System.out.println(del_sno_jtest.getText());
                int is_del = smodel.delete_data(del_sno_jtest.getText());
                System.out.println(is_del);
                if (is_del == 1) {
                    System.out.println("删除成功！影响数据库行数为：" + is_del);
                    opr_result_label.setText("删除成功！影响数据库行数为：" + is_del);
                }
                else {
                    System.out.println("删除失败！影响数据库行数为：" + is_del);
                    opr_result_label.setText("删除失败！影响数据库行数为：" + is_del);
                }
                display(select_all);
            }
        });
    }
    public void add_one_item() {
        JTextField add_sno_jtest = new JTextField();
        add_sno_jtest.addFocusListener(new JTextFieldHintListener(add_sno_jtest, "请输入想要添加的学号..."));
        add_sno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sex_jtest = new JTextField();
        add_sex_jtest.addFocusListener(new JTextFieldHintListener(add_sex_jtest, "请输入想要添加的学生性别..."));
        add_sex_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_age_jtest = new JTextField();
        add_age_jtest.addFocusListener(new JTextFieldHintListener(add_age_jtest, "请输入想要添加的学生年龄..."));
        add_age_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sname_jtest = new JTextField();
        add_sname_jtest.addFocusListener(new JTextFieldHintListener(add_sname_jtest, "请输入想要添加的学生姓名..."));
        add_sname_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sdept_jtest = new JTextField();
        add_sdept_jtest.addFocusListener(new JTextFieldHintListener(add_sdept_jtest, "请输入想要添加的学生院系..."));
        add_sdept_jtest.setPreferredSize(new Dimension (200,30));

        JButton btn = new JButton("确认");
        panelLeft.add(new JLabel("学号："));
        panelLeft.add(add_sno_jtest);
        panelLeft.add(new JLabel("性别："));
        panelLeft.add(add_sex_jtest);
        panelLeft.add(new JLabel("年龄："));
        panelLeft.add(add_age_jtest);
        panelLeft.add(new JLabel("姓名："));
        panelLeft.add(add_sname_jtest);
        panelLeft.add(new JLabel("院系："));
        panelLeft.add(add_sdept_jtest);
        panelLeft.add(btn);
        panelLeft.add(opr_result_label);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssex = add_sex_jtest.getText();
                String sno = add_sno_jtest.getText();
                String sage = add_age_jtest.getText();
                String sname = add_sname_jtest.getText();
                String sdept = add_sdept_jtest.getText();
                String[] sex_choise = {"male", "female"};

                Random rand = new Random();
                String sql_string = "INSERT into Student VALUES ('" + sno + "'," + sage;
                sql_string += ",'" + ssex + "'";//sex
                sql_string += ",'" + sname + "'";//sname
                sql_string += ",'" + sdept +"'";//sdept
                sql_string += ")";
                System.out.println(sql_string);
                int is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                if (is_add == 1) {
                    System.out.println("添加成功！影响数据库行数为：" + is_add);
                    opr_result_label.setText("添加成功！影响数据库行数为：" + is_add);
                }
                else {
                    System.out.println("添加失败！影响数据库行数为：" + is_add);
                    opr_result_label.setText("添加失败！影响数据库行数为：" + is_add);
                }
                display(select_all);
            }
        });

    }
    public void modify_stu_info() {
        JTextField add_sno_jtest = new JTextField();
        add_sno_jtest.addFocusListener(new JTextFieldHintListener(add_sno_jtest, "请输入想修改的学号..."));
        add_sno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sex_jtest = new JTextField();
        add_sex_jtest.addFocusListener(new JTextFieldHintListener(add_sex_jtest, "请输入新的学生性别..."));
        add_sex_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_age_jtest = new JTextField();
        add_age_jtest.addFocusListener(new JTextFieldHintListener(add_age_jtest, "请输入新的学生年龄..."));
        add_age_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sname_jtest = new JTextField();
        add_sname_jtest.addFocusListener(new JTextFieldHintListener(add_sname_jtest, "请新学生姓名..."));
        add_sname_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sdept_jtest = new JTextField();
        add_sdept_jtest.addFocusListener(new JTextFieldHintListener(add_sdept_jtest, "请输入新的学生院系..."));
        add_sdept_jtest.setPreferredSize(new Dimension (200,30));

        JButton btn = new JButton("确认");
        panelLeft.add(new JLabel("学号："));
        panelLeft.add(add_sno_jtest);
        panelLeft.add(new JLabel("性别："));
        panelLeft.add(add_sex_jtest);
        panelLeft.add(new JLabel("年龄："));
        panelLeft.add(add_age_jtest);
        panelLeft.add(new JLabel("姓名："));
        panelLeft.add(add_sname_jtest);
        panelLeft.add(new JLabel("院系："));
        panelLeft.add(add_sdept_jtest);
        panelLeft.add(btn);
        panelLeft.add(opr_result_label);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssex = add_sex_jtest.getText();
                String sno = add_sno_jtest.getText();
                String sage = add_age_jtest.getText();
                String sname = add_sname_jtest.getText();
                String sdept = add_sdept_jtest.getText();
                String[] sex_choise = {"male", "female"};
                int is_del = smodel.delete_data(sno);
                System.out.println(is_del);
                String sql_string = "INSERT into Student VALUES ('" + sno + "'," + sage;
                sql_string += ",'" + ssex + "'";//sex
                sql_string += ",'" + sname + "'";//sname
                sql_string += ",'" + sdept +"'";//sdept
                sql_string += ")";
                System.out.println(sql_string);
                int is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                int is_modify = is_del+is_add;
                if (is_modify == 2) {
                    System.out.println("修改成功！影响数据库行数为：" + is_modify);
                    opr_result_label.setText("修改成功！影响数据库行数为：" + is_modify);
                }
                else {
                    System.out.println("修改失败！影响数据库行数为：" + is_modify);
                    opr_result_label.setText("修改失败！影响数据库行数为：" + is_modify);
                }
                display(select_all);
            }
        });
    }
    public void query_sql() {
        JTextField sql_text = new JTextField();

        sql_text.addFocusListener(new JTextFieldHintListener(sql_text, "请输入想要查询的SQL语句..."));
        sql_text.setPreferredSize(new Dimension (200,30));
        JButton btn = new JButton("确认");
        panelLeft.add(new JLabel("请确保输入正确的SQL查询语句！(表名为Student,Score,SC)"));
        panelLeft.add(sql_text);
        panelLeft.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql_query = sql_text.getText();
                display(sql_query);
            }
        });
    }
    teacherView() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(300,300);
        panelLeft = new JPanel(new GridLayout(20,1));
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("操作列表");
        bar.add(menu);
        this.setJMenuBar(bar);
        this.setTitle("学生管理系统");
        JMenuItem addItem = new JMenuItem("添加学生");
        JMenuItem delItem = new JMenuItem("删除学生");
        JMenu menu_modifyItem = new JMenu("修改");
        JMenuItem modify_stu = new JMenuItem("修改学生信息");
        JMenuItem modify_score = new JMenuItem("修改学生成绩");
        JMenuItem queryItem = new JMenuItem("查询学生");

        //增加学生信息
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                add_one_item();
            }
        });

        //删除学生信息
        delItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                del_one_item();
            }
        });

        //修改学生信息
        modify_stu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                modify_stu_info();
            }
        });
        queryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                query_sql();
            }
        });
        menu.add(addItem);
        menu.addSeparator();
        menu.add(delItem);
        menu.addSeparator();
        menu_modifyItem.add(modify_stu);
        menu_modifyItem.add(modify_score);
        menu.add(menu_modifyItem);
        menu.addSeparator();
        menu.add(queryItem);
        menu.addSeparator();
        Object data[][] = {{1,2,3}, {4,5,6}};
        Object columnName[] = {11,22,33};
//        jt = new JTable(data, columnName);
//        jsp = new JScrollPane(jt);
//        this.add(jsp);
        myPanel = new JSplitPane();
        myPanel.setLeftComponent(panelLeft);
        opr_result_label = new JLabel("暂无内容");
        opr_result_label.setBounds(200,400,100,400);

        opr_result_label.setHorizontalTextPosition(JLabel.CENTER);
        opr_result_label.setVerticalTextPosition(SwingConstants.BOTTOM);
//        panelLeft.add(opr_result_label);
        myPanel.setOneTouchExpandable(true);
        myPanel.setContinuousLayout(true);
        myPanel.setDividerSize(30);
        myPanel.setDividerLocation(200);
        myPanel.setEnabled(true);
        this.display(select_all);
        this.setContentPane(myPanel);
        this.setVisible(true);
    }
}




class JTextFieldHintListener implements FocusListener {
    private String hintText;
    private JTextField textField;
    public JTextFieldHintListener(JTextField jTextField,String hintText) {
        this.textField = jTextField;
        this.hintText = hintText;
        jTextField.setText(hintText);  //默认直接显示
        jTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        //获取焦点时，清空提示内容
        String temp = textField.getText();
        if(temp.equals(hintText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        //失去焦点时，没有输入内容，显示提示内容
        String temp = textField.getText();
        if(temp.equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }

    }

}