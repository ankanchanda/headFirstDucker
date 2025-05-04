package ch2.somecode.swingLibrary;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;


public class SwingObserverExample {

    private JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample exampleObject = new SwingObserverExample();
        exampleObject.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton button = new JButton("Should I do it?");
        button.addActionListener(
                event -> System.out.println("Don't do it, you might regret it!"));
        button.addActionListener(
                event -> System.out.println("Come on, do it!"));
        
        jFrame.getContentPane().add(BorderLayout.CENTER, button);
        // Set frame properties
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        jFrame.setVisible(true);
    }
}
