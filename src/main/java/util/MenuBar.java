package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.BookInfo;
import util.UserRole;

public class MenuBar {
    private JMenuBar menuBar;
    private JMenuItem menuItemBookManagement;
    private JMenuItem menuItemBookQuery;
    private JMenuItem menuItemBorrowAndReturn;
    private JMenuItem menuItemBorrowInfo;
    private JMenuItem menuItemReturnInfo;
    private JMenuItem menuItemUserInfo;

    private BookInfo bookInfo;

    public MenuBar(JFrame frame) {
        menuBar = new JMenuBar();

        if (UserRole.isAdmin) {
            menuItemBookManagement = new JMenuItem();
            setMenuItemBookManagement(frame);
            menuBar.add(menuItemBookManagement);
        }

        frame.setJMenuBar(menuBar);
    }

    private void setMenuItemBookManagement(JFrame frame) {
        menuItemBookManagement.setText("图书管理");
        menuItemBookManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                bookInfo = new BookInfo();
            }
        });
    }
}
