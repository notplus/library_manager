package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.BorrowRecordAction;
import util.FrameOption;
import util.MenuBar;

public class BorrowInfo {
    private JFrame frame = new JFrame("图书馆");
    private Container container = frame.getContentPane();

    private JTable table;
    private JScrollPane scrollPane;

    private BorrowRecordAction borrowRecordAction;

    public BorrowInfo() {
        frame.setLayout(null);
        new MenuBar(frame);

        borrowRecordAction = new BorrowRecordAction();

        setTable();

        container.add(scrollPane);
        new FrameOption(frame);
    }

    private void setTable() {
        String[] columnNames = { "ID", "用户ID", "图书ID", "图书名称" ,"借书日期", "借书时间","应还日期" };
        try {
            Object[][] results = borrowRecordAction.setQueryTable(columnNames);

            table = new JTable(results, columnNames);
            scrollPane = new JScrollPane(table);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(20, 30, 760, 230);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
