package view;

import java.awt.Container;
import javax.swing.JFrame;

import util.MenuBar;
import util.FrameOption;

public class MainFrame {
    JFrame frame = new JFrame("图书馆");
    Container container = frame.getContentPane();

    public MainFrame() {
        new MenuBar(frame);
        new FrameOption(frame);
    }
}
