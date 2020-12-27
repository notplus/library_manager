package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.BookManage;
import view.BookQuery;
import view.BorrowInfo;
import view.ReturnInfo;
import view.UserInfo;

public class MenuBar {
    private JMenuBar menuBar;
    private JMenuItem menuItemBookManagement;
    private JMenuItem menuItemBookQuery;
    private JMenuItem menuItemBorrowInfo;
    private JMenuItem menuItemReturnInfo;
    private JMenuItem menuItemUserInfo;

    public MenuBar(JFrame frame) {
        menuBar = new JMenuBar();

        if (UserRole.isAdmin) {
            menuItemBookManagement = new JMenuItem();
            setMenuItemBookManagement(frame);
            menuBar.add(menuItemBookManagement);
        }

        menuItemBookQuery = new JMenuItem();
        setMenuItemBookQuery(frame);
        menuBar.add(menuItemBookQuery);

        menuItemBorrowInfo=new JMenuItem();
        setMenuItemBorrowInfo(frame);
        menuBar.add(menuItemBorrowInfo);

        menuItemReturnInfo=new JMenuItem();
        setMenuItemReturnInfo(frame);
        menuBar.add(menuItemReturnInfo);

        menuItemUserInfo=new JMenuItem();
        setMenuItemUserInfo(frame);
        menuBar.add(menuItemUserInfo);

        frame.setJMenuBar(menuBar);
    }

    private void setMenuItemBookManagement(JFrame frame) {
        menuItemBookManagement.setText("图书管理");
        menuItemBookManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BookManage();
            }
        });
    }

    private void setMenuItemBookQuery(JFrame frame){
        menuItemBookQuery.setText("图书查询");
        menuItemBookQuery.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // frame.setVisible(false);
                frame.dispose();
                new BookQuery();
            }
        });
    }

    private void setMenuItemBorrowInfo(JFrame frame){
        menuItemBorrowInfo.setText("借书记录");
        menuItemBorrowInfo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // frame.setVisible(false);
                frame.dispose();
                new BorrowInfo();
            }
        });
    }

    private void setMenuItemReturnInfo(JFrame frame){
        menuItemReturnInfo.setText("还书记录");
        menuItemReturnInfo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // frame.setVisible(false);
                frame.dispose();
                new ReturnInfo();
            }
        });
    }

    private void setMenuItemUserInfo(JFrame frame){
        menuItemUserInfo.setText("个人信息");
        menuItemUserInfo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // frame.setVisible(false);
                frame.dispose();
                new UserInfo();
            }
        });
    }
}
