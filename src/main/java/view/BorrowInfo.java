package view;

import java.awt.Container;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.BorrowRecordAction;
import util.FrameOption;
import util.MenuBar;
import util.Chart;

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

        try {
            List<Integer> data = borrowRecordAction.getChartData();
            Calendar cal = Calendar.getInstance();
            String title = Integer.toString(cal.get(Calendar.YEAR)) + "年借书情况统计图";
            new Chart(title,data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTable() {
        String[] columnNames = { "ID", "用户ID", "图书ID", "图书名称", "借书日期", "借书时间", "应还日期" };
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
