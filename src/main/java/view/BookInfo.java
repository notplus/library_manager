package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.BookAction;
import util.FrameOption;
import util.MenuBar;

public class BookInfo {
    private JFrame frame = new JFrame("图书馆");
    private Container container = frame.getContentPane();

    private JTable table;
    private JScrollPane scrollPane;

    private BookAction bookAction;

    public BookInfo() {
        frame.setLayout(null);
        new MenuBar(frame);

        bookAction = new BookAction();

        setTable();

        container.add(scrollPane);
        new FrameOption(frame);
    }

    private void setTable() {
        String[] columnNames = { "ID", "ISBN", "图书名称", "图书作者", "图书价格(元)", "出版社", "索引号", "图书简介", "是否借出" };
        try {
            BookAction bookAction = new BookAction();
            Object[][] results = bookAction.initializTable(columnNames);

            table = new JTable(results, columnNames);

            scrollPane = new JScrollPane(table);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(20, 80, 760, 190);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
