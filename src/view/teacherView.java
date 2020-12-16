package view;

import javax.swing.*;
import helper.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class teacherView extends JFrame {
    JPanel panelLeft;
    JTable jt = null;
    JScrollPane jsp = null;
    StuModel smodel;
    JLabel opr_result_label = null;
    JSplitPane myPanel;
    String select_all_student = "select * from Student";
    String select_all_score = "select * from Student,sc where Student.sno =sc.sno";
    String select_all_course = "select * from Course";
    public void display(String sql_string) {
        Object data[][];
        Object columnName[];
        String temp[] = {""};
        smodel = new StuModel(sql_string, temp);
        //int is_del = smodel.delete_data("8020");
        //System.out.println(is_del);
        //if (is_del == 1) System.out.println("ɾ���ɹ���Ӱ�����ݿ�����Ϊ��" + is_del);
        //else System.out.println("ɾ��ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_del);
        data = smodel.getData();
        columnName = smodel.getColumnName();
        jt = new JTable(data, columnName);
        jsp = new JScrollPane(jt);
        myPanel.setRightComponent(jsp);
    }
    public void del_one_item() {
        JTextField del_sno_jtest = new JTextField();
        del_sno_jtest.addFocusListener(new JTextFieldHintListener(del_sno_jtest, "��������Ҫɾ����ѧ��..."));
        JButton btn = new JButton("ȷ��");
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
                    System.out.println("ɾ���ɹ���Ӱ�����ݿ�����Ϊ��" + is_del);
                    opr_result_label.setText("ɾ���ɹ���Ӱ�����ݿ�����Ϊ��" + is_del);
                }
                else {
                    System.out.println("ɾ��ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_del);
                    opr_result_label.setText("ɾ��ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_del);
                }
                display(select_all_student);
            }
        });
    }
    public void add_one_item() {
        JTextField add_sno_jtest = new JTextField();
        add_sno_jtest.addFocusListener(new JTextFieldHintListener(add_sno_jtest, "��������Ҫ��ӵ�ѧ��..."));
        add_sno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sex_jtest = new JTextField();
        add_sex_jtest.addFocusListener(new JTextFieldHintListener(add_sex_jtest, "��������Ҫ��ӵ�ѧ���Ա�..."));
        add_sex_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_age_jtest = new JTextField();
        add_age_jtest.addFocusListener(new JTextFieldHintListener(add_age_jtest, "��������Ҫ��ӵ�ѧ������..."));
        add_age_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sname_jtest = new JTextField();
        add_sname_jtest.addFocusListener(new JTextFieldHintListener(add_sname_jtest, "��������Ҫ��ӵ�ѧ������..."));
        add_sname_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sdept_jtest = new JTextField();
        add_sdept_jtest.addFocusListener(new JTextFieldHintListener(add_sdept_jtest, "��������Ҫ��ӵ�ѧ��Ժϵ..."));
        add_sdept_jtest.setPreferredSize(new Dimension (200,30));

        JButton btn = new JButton("ȷ��");
        panelLeft.add(new JLabel("ѧ�ţ�"));
        panelLeft.add(add_sno_jtest);
        panelLeft.add(new JLabel("�Ա�"));
        panelLeft.add(add_sex_jtest);
        panelLeft.add(new JLabel("���䣺"));
        panelLeft.add(add_age_jtest);
        panelLeft.add(new JLabel("������"));
        panelLeft.add(add_sname_jtest);
        panelLeft.add(new JLabel("Ժϵ��"));
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

                String sql_string = "INSERT into Student VALUES ('" + sno + "'," + sage;
                sql_string += ",'" + ssex + "'";//sex
                sql_string += ",'" + sname + "'";//sname
                sql_string += ",'" + sdept +"'";//sdept
                sql_string += ")";
                System.out.println(sql_string);
                int is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                if (is_add == 1) {
                    System.out.println("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                else {
                    System.out.println("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                display(select_all_student);
            }
        });

    }
    public void add_one_score() {
        JTextField add_sno_jtest = new JTextField();
        add_sno_jtest.addFocusListener(new JTextFieldHintListener(add_sno_jtest, "��������Ҫ¼��ɼ���ѧ��ѧ��..."));
        add_sno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_cno_jtest = new JTextField();
        add_cno_jtest.addFocusListener(new JTextFieldHintListener(add_cno_jtest, "������γ̺�..."));
        add_cno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_score_jtest = new JTextField();
        add_score_jtest.addFocusListener(new JTextFieldHintListener(add_score_jtest, "��������Ҫ¼��ѧ���ĸÿγ̳ɼ�..."));
        add_score_jtest.setPreferredSize(new Dimension (200,30));


        JButton btn = new JButton("ȷ��");
        panelLeft.add(new JLabel("ѧ�ţ�"));
        panelLeft.add(add_sno_jtest);
        panelLeft.add(new JLabel("�γ̺ţ�"));
        panelLeft.add(add_cno_jtest);
        panelLeft.add(new JLabel("�ɼ���"));
        panelLeft.add(add_score_jtest);

        panelLeft.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sno = add_sno_jtest.getText();
                String cno = add_cno_jtest.getText();
                String score = add_score_jtest.getText();

                String sql_string = "INSERT into sc VALUES ('" + sno + "'";//sno
                sql_string += ",'" + cno + "'";//cno
                sql_string += "," + score;//score
                sql_string += ")";
                System.out.println(sql_string);
                int is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                if (is_add == 1) {
                    System.out.println("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                else {
                    System.out.println("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                display(select_all_score);
            }
        });
    }
    public void add_one_course() {
        JTextField add_cno_jtest = new JTextField();
        add_cno_jtest.addFocusListener(new JTextFieldHintListener(add_cno_jtest, "���������ӵĿγ̺�..."));
        add_cno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_cname_jtest = new JTextField();
        add_cname_jtest.addFocusListener(new JTextFieldHintListener(add_cname_jtest, "���������ӵĿγ���..."));
        add_cname_jtest.setPreferredSize(new Dimension (200,30));

        JButton btn = new JButton("ȷ��");

        panelLeft.add(new JLabel("�γ̺ţ�"));
        panelLeft.add(add_cno_jtest);
        panelLeft.add(new JLabel("�γ�����"));
        panelLeft.add(add_cname_jtest);

        panelLeft.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cno = add_cno_jtest.getText();
                String cname = add_cname_jtest.getText();

                String sql_string = "INSERT into Course VALUES ('" + cno + "'";//cno
                sql_string += ",'" + cname + "'";//cname
                sql_string += ")";
                System.out.println(sql_string);
                int is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                if (is_add == 1) {
                    System.out.println("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("��ӳɹ���Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                else {
                    System.out.println("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                    opr_result_label.setText("���ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_add);
                }
                display(select_all_course);
            }
        });

    }
    public void modify_stu_info() {
        JTextField add_sno_jtest = new JTextField();
        add_sno_jtest.addFocusListener(new JTextFieldHintListener(add_sno_jtest, "���������޸ĵ�ѧ��..."));
        add_sno_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sex_jtest = new JTextField();
        add_sex_jtest.addFocusListener(new JTextFieldHintListener(add_sex_jtest, "�������µ�ѧ���Ա�..."));
        add_sex_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_age_jtest = new JTextField();
        add_age_jtest.addFocusListener(new JTextFieldHintListener(add_age_jtest, "�������µ�ѧ������..."));
        add_age_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sname_jtest = new JTextField();
        add_sname_jtest.addFocusListener(new JTextFieldHintListener(add_sname_jtest, "����ѧ������..."));
        add_sname_jtest.setPreferredSize(new Dimension (200,30));

        JTextField add_sdept_jtest = new JTextField();
        add_sdept_jtest.addFocusListener(new JTextFieldHintListener(add_sdept_jtest, "�������µ�ѧ��Ժϵ..."));
        add_sdept_jtest.setPreferredSize(new Dimension (200,30));

        JButton btn = new JButton("ȷ��");
        panelLeft.add(new JLabel("ѧ�ţ�"));
        panelLeft.add(add_sno_jtest);
        panelLeft.add(new JLabel("�Ա�"));
        panelLeft.add(add_sex_jtest);
        panelLeft.add(new JLabel("���䣺"));
        panelLeft.add(add_age_jtest);
        panelLeft.add(new JLabel("������"));
        panelLeft.add(add_sname_jtest);
        panelLeft.add(new JLabel("Ժϵ��"));
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
                int is_del = 0,is_add = 0;
                is_del = smodel.delete_data(sno);
                System.out.println(is_del);
                String sql_string = "INSERT into Student VALUES ('" + sno + "'," + sage;
                sql_string += ",'" + ssex + "'";//sex
                sql_string += ",'" + sname + "'";//sname
                sql_string += ",'" + sdept +"'";//sdept
                sql_string += ")";
                System.out.println(sql_string);
                if(is_del == 1) is_add = smodel.insert_data(sql_string);
                System.out.println(is_add);
                int is_modify = is_del+is_add;
                if (is_modify == 2) {
                    System.out.println("�޸ĳɹ���Ӱ�����ݿ�����Ϊ��" + is_modify);
                    opr_result_label.setText("�޸ĳɹ���Ӱ�����ݿ�����Ϊ��" + is_modify);
                }
                else {
                    System.out.println("�޸�ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_modify);
                    opr_result_label.setText("�޸�ʧ�ܣ�Ӱ�����ݿ�����Ϊ��" + is_modify);
                }
                display(select_all_student);
            }
        });
    }
    public void query_sql() {
        JTextField sql_text = new JTextField();

        sql_text.addFocusListener(new JTextFieldHintListener(sql_text, "��������Ҫ��ѯ��SQL���..."));
        sql_text.setPreferredSize(new Dimension (200,30));
        JButton btn = new JButton("ȷ��");
        panelLeft.add(new JLabel("��ȷ��������ȷ��SQL��ѯ��䣡(����ΪStudent,Score,SC)"));
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
        JMenu menu = new JMenu("�����б�");
        bar.add(menu);
        this.setJMenuBar(bar);
        this.setTitle("ѧ������ϵͳ");
        JMenu menu_addItem = new JMenu("���");
        JMenuItem addItem = new JMenuItem("���ѧ��");
        JMenuItem addCourse = new JMenuItem("��ӿγ�");
        JMenuItem addScore = new JMenuItem("¼��ɼ�");

        JMenuItem delItem = new JMenuItem("ɾ��ѧ��");
        JMenu menu_modifyItem = new JMenu("�޸�");
        JMenuItem modify_stu = new JMenuItem("�޸�ѧ����Ϣ");
        JMenuItem modify_score = new JMenuItem("�޸�ѧ���ɼ�");

        JMenu menu_queryItem = new JMenu("��ѯ");
        JMenuItem query_item_info = new JMenuItem("��ѯѧ����Ϣ");
        JMenuItem query_course_info = new JMenuItem("��ѯ�γ���Ϣ");
        JMenuItem query_sc_info = new JMenuItem("��ѯ�ɼ���Ϣ");
        JMenuItem queryItem = new JMenuItem("�Զ����ѯ(SQL���)");

        //����ѧ����Ϣ
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                add_one_item();
            }
        });
        //��ӿγ�
        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                add_one_course();
            }
        });
        //¼��ɼ�
        addScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                add_one_score();
            }
        });

        //ɾ��ѧ����Ϣ
        delItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                del_one_item();
            }
        });

        //�޸�ѧ����Ϣ
        modify_stu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                modify_stu_info();
            }
        });

        //��ѯѧ����Ϣ
        query_item_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(select_all_student);
            }
        });

        //��ѯ�γ���Ϣ
        query_course_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(select_all_course);
            }
        });

        //��ѯ�ɼ���Ϣ
        query_sc_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(select_all_score);
            }
        });
        //�Զ����ѯ
        queryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft = new JPanel(new GridLayout(20,1));
                myPanel.setLeftComponent(panelLeft);
                query_sql();
            }
        });


        menu_addItem.add(addItem);
        menu_addItem.add(addCourse);
        menu_addItem.add(addScore);
        menu.add(menu_addItem);
        menu.addSeparator();
        menu.add(delItem);
        menu.addSeparator();
        menu_modifyItem.add(modify_stu);
        menu_modifyItem.add(modify_score);
        menu.add(menu_modifyItem);
        menu.addSeparator();
        menu.add(menu_queryItem);
        menu_queryItem.add(query_item_info);
        menu_queryItem.add(query_course_info);
        menu_queryItem.add(query_sc_info);
        menu_queryItem.add(queryItem);
        menu.addSeparator();
        Object data[][] = {{1,2,3}, {4,5,6}};
        Object columnName[] = {11,22,33};
//        jt = new JTable(data, columnName);
//        jsp = new JScrollPane(jt);
//        this.add(jsp);
        myPanel = new JSplitPane();
        myPanel.setLeftComponent(panelLeft);
        opr_result_label = new JLabel("��������");
        opr_result_label.setBounds(200,400,100,400);

        opr_result_label.setHorizontalTextPosition(JLabel.CENTER);
        opr_result_label.setVerticalTextPosition(SwingConstants.BOTTOM);
//        panelLeft.add(opr_result_label);
        myPanel.setOneTouchExpandable(true);
        myPanel.setContinuousLayout(true);
        myPanel.setDividerSize(30);
        myPanel.setDividerLocation(200);
        myPanel.setEnabled(true);
        this.display(select_all_student);
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
        jTextField.setText(hintText);  //Ĭ��ֱ����ʾ
        jTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        //��ȡ����ʱ�������ʾ����
        String temp = textField.getText();
        if(temp.equals(hintText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        //ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
        String temp = textField.getText();
        if(temp.equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }

    }

}