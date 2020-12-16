package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewManager {
    JFrame jf;

    public static void main(String[] args) {
        ViewManager myView = new ViewManager();
    }
    ViewManager() {
        jf = new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,300);

        LoginView loginpanel = new LoginView();
        loginpanel.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = loginpanel.text_user.getText();
                String pwd = new String(loginpanel.text_pwd.getPassword());
                //如果满足登录条件
                System.out.println(user);
                System.out.println(pwd);
                teacherView tw = new teacherView();
                jf.setVisible(false);
                //jf.setContentPane(tw);
                //jf.setVisible(true);
            }
        });
        jf.setContentPane(loginpanel);
        jf.setVisible(true);

    }
}
