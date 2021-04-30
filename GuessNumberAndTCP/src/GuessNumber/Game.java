package GuessNumber;

import javax.swing.*;

public class Game {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });

    }

    private static void createGUI() {
        //创建一个窗口，创建一个窗口
        MyFrame frame = new MyFrame("demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口大小
        frame.setSize(600, 400);

        //显示窗口
        frame.setVisible(true);
    }
}