package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.FrameOption;
import controller.UserAction;
import util.MenuBar;

public class UserInfo {
    JFrame frame = new JFrame("图书馆");

    private Container container = frame.getContentPane();
    private UserAction userAction = new UserAction();

    public UserInfo() {
        frame.setLayout(null);
        new MenuBar(frame);

        JLabel userNameLabel = new JLabel("新用户名：");
        userNameLabel.setBounds(10, 110, 100, 30);

        JTextField userNameText = new JTextField();
        userNameText.setBounds(130, 110, 100, 30);

        JLabel userpwdLabel = new JLabel("新密码：");
        userpwdLabel.setBounds(10, 150, 100, 30);

        JPasswordField userpwdText = new JPasswordField();
        userpwdText.setBounds(130, 150, 100, 30);

        JButton buttonUpdate = new JButton("更新");
        buttonUpdate.setBounds(400, 150, 100, 30);
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userAction.updateUserInfo(userNameText.getText(), new String(userpwdText.getPassword())))
                    JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "修改失败", "错误", JOptionPane.PLAIN_MESSAGE);
            }
        });

        container.add(userNameLabel);
        container.add(userNameText);
        container.add(userpwdLabel);
        container.add(userpwdText);
        container.add(buttonUpdate);

        new FrameOption(frame);
    }

}
