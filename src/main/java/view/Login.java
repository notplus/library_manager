package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

import controller.UserAction;
import util.FrameOption;
import util.UserRole;
import util.KeyListener;
import model.*;

@SuppressWarnings("serial")
public class Login extends JFrame {
    private final JFrame frame = new JFrame("图书馆");
    private final Container container = frame.getContentPane();

    private JTextField textUserName = new JTextField();
    private JPasswordField textPassword = new JPasswordField();
    private JButton buttonRegister = new JButton();
    private JButton buttonLogin = new JButton();

    public Login() {
        container.setLayout(null);
        JLabel userLabel = new JLabel("用户名");
        JLabel passwordLabel = new JLabel("密码");
        userLabel.setBounds(150, 75, 50, 30); // 设置"用户名"显示位置
        passwordLabel.setBounds(150, 140, 50, 30); // 设置"密码"显示位置
        textUserName.setBounds(210, 75, 180, 30);
        textPassword.setBounds(210, 140, 180, 30);
        setButtonRegister();
        setButtonLogin();

        new KeyListener(textUserName,buttonLogin);
        new KeyListener(textPassword,buttonLogin);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(textUserName);
        container.add(textPassword);
        container.add(buttonRegister);
        container.add(buttonLogin);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(550, 350);
        frame.setLocation(300, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setButtonRegister() {
        buttonRegister.setText("注册");
        buttonRegister.setBounds(150, 200, 90, 30);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TO-DO
            }
        });
    }

    private void setButtonLogin() {
        buttonLogin.setText("登录");
        buttonLogin.setBounds(310, 200, 90, 30);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textUserName.getText();
                String userpwd = new String(textPassword.getPassword());
                UserAction userAction = new UserAction();
                try {
                    if (userAction.isUserPwdCorrect(username, userpwd)) {
                        frame.setVisible(false);
                        UserRole.setIsAdmin(userAction.isAdmin(username));
                        UserRole.id=userAction.getUserId(username);
                        new MainFrame();
                        System.out.println("login successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {

        new Login();

    }
}
