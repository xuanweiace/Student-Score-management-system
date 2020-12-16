package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel{
    JLabel lbl_title;
    JLabel lbl_user, lbl_pwd;
    JTextField text_user;
    JButton btn;
    JPasswordField text_pwd;
    LoginView() {
        this.setLayout(null);
        lbl_title = new JLabel("学生数据库系统欢迎你");
        lbl_title.setBounds(50,30,300,100);
        lbl_title.setFont(new Font("宋体",Font.BOLD,22));
        this.add(lbl_title);
        lbl_user = new JLabel("user:");
        lbl_user.setBounds(50,170,50,20);
        this.add(lbl_user);
        text_user = new JTextField(8);
        text_user.setBounds(150,170,100,20);
        this.add(text_user);
        lbl_pwd = new JLabel("password:");
        lbl_pwd.setBounds(50,200,100,20);
        this.add(lbl_pwd);
        text_pwd = new JPasswordField(8);
        text_pwd.setBounds(150,200,100,20);
        this.add(text_pwd);
        btn =new JButton("登录");
        btn.setBounds(300,175,70,30);
        this.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = text_user.getText();
                String pwd = new String(text_pwd.getPassword());
                //如果满足登录条件
//                System.out.println(user);
//                System.out.println(pwd);

            }
        });
    }
}
