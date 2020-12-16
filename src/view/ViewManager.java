package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewManager {
    JFrame jf;
    JLabel lbl_hint = null;
    public static void main(String[] args) {
        ViewManager myView = new ViewManager();
    }
    ViewManager() {
        jf = new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(450,300);
        jf.setTitle("欢迎来到学生成绩管理系统 --- Designed by zxz");
        LoginView loginpanel = new LoginView();


        loginpanel.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = loginpanel.text_user.getText();
                String pwd = new String(loginpanel.text_pwd.getPassword());
                //如果满足登录条件
                if(user.equals("teacher")  && pwd.equals("123456")) {
                    System.out.println("可以");
                    teacherView tw = new teacherView();
                    jf.setVisible(false);
                }
                else {
                    System.out.println("不行");
                    lbl_hint = new JLabel("信息错误！！");
                    lbl_hint.setBounds(270,180,300,100);
                    lbl_hint.setFont(new Font("楷体",Font.BOLD,13));
                    lbl_hint.setForeground(Color.RED);
                    loginpanel.add(lbl_hint);
                    jf.setContentPane(loginpanel);
                    jf.setVisible(true);
                }
                System.out.println(user);
                System.out.println(pwd);
                //jf.setContentPane(tw);
                //jf.setVisible(true);
            }
        });
        jf.setContentPane(loginpanel);
        jf.setVisible(true);

    }
}
