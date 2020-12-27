package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.BookAction;
import util.FrameOption;
import util.MenuBar;

public class BookManage {
    private JFrame frame = new JFrame("图书馆");
    private Container container = frame.getContentPane();

    private JTable table;
    private JScrollPane scrollPane;

    private JButton buttonAdd, buttonDelete, buttonUpdate;
    private JTextField textBookIsbn, textBookName, textBookAuthor;
    private JTextField textBookPrice, textPublish, textBookCategory;
    private JTextField textIntroduction;

    private JLabel labelBookIsbn, labelBookName, labelBookAuthor;
    private JLabel labelBookPrice, labelPublish, labelBookCategory;
    private JLabel labelIntroduction;

    private BookAction bookAction;

    public BookManage() {
        frame.setLayout(null);
        new MenuBar(frame);

        bookAction = new BookAction();

        textBookIsbn = new JTextField();
        textBookIsbn.setBounds(120, 280, 140, 23);
        labelBookIsbn = new JLabel("ISBN：");
        labelBookIsbn.setBounds(70, 280, 140, 23);

        textBookName = new JTextField();
        textBookName.setBounds(348, 280, 140, 23);
        labelBookName = new JLabel("书名：");
        labelBookName.setBounds(300, 280, 140, 23);

        textBookAuthor = new JTextField();
        textBookAuthor.setBounds(586, 280, 140, 23);
        labelBookAuthor = new JLabel("作者：");
        labelBookAuthor.setBounds(536, 280, 140, 23);

        textBookPrice = new JTextField();
        textBookPrice.setBounds(120, 340, 140, 23);
        labelBookPrice = new JLabel("价格：");
        labelBookPrice.setBounds(70, 340, 140, 23);

        textPublish = new JTextField();
        textPublish.setBounds(348, 340, 140, 23);
        labelPublish = new JLabel("出版社：");
        labelPublish.setBounds(300, 340, 140, 23);

        textBookCategory = new JTextField();
        textBookCategory.setBounds(582, 340, 140, 23);
        labelBookCategory = new JLabel("索书号：");
        labelBookCategory.setBounds(532, 340, 140, 23);

        textIntroduction = new JTextField();
        textIntroduction.setBounds(120, 400, 140, 23);
        labelIntroduction = new JLabel("简介：");
        labelIntroduction.setBounds(70, 400, 140, 23);

        setTable();

        buttonAdd = new JButton();
        setButtonAdd();

        buttonDelete = new JButton();
        setButtonDelete();

        buttonUpdate = new JButton();
        setButtonUpdate();

        container.add(scrollPane);
        container.add(textBookIsbn);
        container.add(textBookName);
        container.add(textBookAuthor);
        container.add(textBookPrice);
        container.add(textPublish);
        container.add(textBookCategory);
        container.add(textIntroduction);

        container.add(labelBookIsbn);
        container.add(labelBookName);
        container.add(labelBookAuthor);
        container.add(labelBookPrice);
        container.add(labelPublish);
        container.add(labelBookCategory);
        container.add(labelIntroduction);

        container.add(buttonAdd);
        container.add(buttonDelete);
        container.add(buttonUpdate);

        new FrameOption(frame);
    }

    private void setTable() {
        String[] columnNames = { "ID", "ISBN", "图书名称", "图书作者", "图书价格(元)", "出版社", "索引号", "图书简介", "是否借出" };
        try {
            Object[][] results = bookAction.setQueryTable(columnNames, 0, "");

            table = new JTable(results, columnNames);

            scrollPane = new JScrollPane(table);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(20, 30, 760, 230);

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String ISBN, bookName, price, author;
                    String publishedHouse, category, introduction;

                    int selRow = table.getSelectedRow();

                    ISBN = table.getValueAt(selRow, 1).toString();
                    bookName = table.getValueAt(selRow, 2).toString();
                    author = table.getValueAt(selRow, 3).toString();
                    price = table.getValueAt(selRow, 4).toString();
                    publishedHouse = table.getValueAt(selRow, 5).toString();
                    category = table.getValueAt(selRow, 6).toString();
                    introduction = table.getValueAt(selRow, 7).toString();

                    textBookIsbn.setText(ISBN);
                    textBookName.setText(bookName);
                    textBookAuthor.setText(author);
                    textBookPrice.setText(price);
                    textPublish.setText(publishedHouse);
                    textBookCategory.setText(category);
                    textIntroduction.setText(introduction);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setButtonAdd() {
        buttonAdd.setBounds(700, 390, 60, 25);
        buttonAdd.setText("增加");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textBookIsbn.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "ISBN号不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textBookIsbn.getText().length() != 17) {
                    JOptionPane.showMessageDialog(null, "ISBN号位数必须是13位", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textBookName.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书名称不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textBookAuthor.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书作者不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textBookPrice.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书价格不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textPublish.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "出版社不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else if (textBookCategory.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书分类号不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
                } else {
                    try {
                        bookAction.addBookInformation(textBookIsbn.getText(), textBookName.getText(),
                                textBookAuthor.getText(), textBookPrice.getText(), textPublish.getText(),
                                textBookCategory.getText(), textIntroduction.getText());
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "增加成功", "提示", JOptionPane.PLAIN_MESSAGE);
                        new BookManage();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void setButtonDelete() {
        buttonDelete.setBounds(580, 390, 60, 25);
        buttonDelete.setText("删除");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selRow = table.getSelectedRow();
                    int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());
                    bookAction.deleteBook(ID);
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    new BookManage();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void setButtonUpdate() {
        buttonUpdate.setBounds(470, 390, 60, 25);
        buttonUpdate.setText("更新");
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selRow = table.getSelectedRow();
                    int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());
                    bookAction.updateBookInfo(ID, textBookIsbn.getText(), textBookName.getText(),
                            textBookAuthor.getText(), textBookPrice.getText(), textPublish.getText(),
                            textBookCategory.getText(), textIntroduction.getText());
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    new BookManage();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "表中没有该数据", "错误", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

    }
}
