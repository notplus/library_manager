package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.BookAction;
import util.FrameOption;
import util.KeyListener;
import util.MenuBar;

public class BookQuery {
    private JFrame frame = new JFrame("图书馆");
    private Container container = frame.getContentPane();

    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<String> combobox;
    private JTextField textInput;
    private JButton buttonQuery;

    private BookAction bookAction;

    public BookQuery() {
        frame.setLayout(null);
        new MenuBar(frame);

        bookAction = new BookAction();

        combobox = new JComboBox<>(new String[] { "图书名称", "ISBN", "图书作者" });
        combobox.setBounds(30, 30, 100, 40);

        buttonQuery = new JButton();
        buttonQuery.setText("查询");
        buttonQuery.setBounds(500, 30, 100, 40);
        buttonQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTable(combobox.getSelectedIndex() + 1, textInput.getText());
            }
        });

        textInput = new JTextField();
        textInput.setBounds(200, 30, 200, 40);
        new KeyListener(textInput, buttonQuery);

        initTable();

        container.add(scrollPane);
        container.add(textInput);
        container.add(combobox);
        container.add(buttonQuery);
        new FrameOption(frame);
    }

    private void initTable() {
        String[] columnNames = { "ID", "ISBN", "图书名称", "图书作者", "图书价格(元)", "出版社", "索引号", "图书简介", "是否借出" };
        Object[][] results = new Object[1][columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            results[0][i] = "";
        }

        table = new JTable(results, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(20, 80, 760, 190);

    }

    private void setTable(int mode, String data) {
        String[] columnNames = { "ID", "ISBN", "图书名称", "图书作者", "图书价格(元)", "出版社", "索引号", "图书简介", "是否借出" };
        try {
            Object[][] results = bookAction.setQueryTable(columnNames, mode, data);

            table = new JTable(results, columnNames);
            scrollPane.setViewportView(table);
            // scrollPane.updateUI();
            // scrollPane.setBounds(20, 80, 760, 190);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
