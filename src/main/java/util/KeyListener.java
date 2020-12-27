package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KeyListener {
    public KeyListener(JTextField text, JButton button) {
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent paramKeyEvent) {
                if (paramKeyEvent.getKeyChar() == '\n') {
                    button.doClick();
                }
            }
        });
    }

    public KeyListener(JPasswordField passwd, JButton button) {
        passwd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent paramKeyEvent) {
                if (paramKeyEvent.getKeyChar() == '\n') {
                    button.doClick();
                }
            }
        });
    }
}
