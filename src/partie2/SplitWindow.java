package partie2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class SplitWindow {
  public static void main(String args[]) {
    JFrame vFrame = new JFrame();
    vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel lab1 = new JLabel(new ImageIcon("image.png"));
    JLabel lab2 = new JLabel(new ImageIcon("image.png"));
    JPanel jp = new JPanel();
    
    
    jp.add(lab2);
    JScrollPane sp = new JScrollPane(jp);
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPane.setRightComponent(sp);
    splitPane.setLeftComponent(lab1);
    splitPane.setOneTouchExpandable(true);
    vFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
    vFrame.setSize(300, 150);
    vFrame.setVisible(true);

  }
}