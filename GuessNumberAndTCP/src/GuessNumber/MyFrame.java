package GuessNumber;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
        JLabel label = new JLabel("输入你猜测的数字");

        //创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
        JTextField textField = new JTextField(16);
        JButton button = new JButton("确定");


    Guess guess = new Guess();
    Object o1 = new Object();

    public void sys() {
        Object[] options = { "OK ", "CANCEL " };
        guess.setNumber();
        try {
            synchronized (o1) {
                guess.setNumber();
                while (true) {
                    o1.wait();
                    int flag = guess.verifyNumber();
                    if(flag==1){
                        JOptionPane.showOptionDialog(null, "猜对了 ", "提示", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,null, options, options[0]);
                        System.exit(0);
                    }
                    if(flag==2){
                        JOptionPane.showOptionDialog(null, "猜大了 ", "提示", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,null, options, options[0]);
                    }
                    else{
                        JOptionPane.showOptionDialog(null, "猜小了 ", "提示", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,null, options, options[0]);
                    }
                    o1.wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public void gamer(){
            synchronized (o1){
                    guess.guessN(Integer.parseInt(textField.getText()));
                    o1.notify();
            }
    }


        //构造函数
        public MyFrame(String title)
        {
            //继承父类，
            super(title);

            //内容面板
            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());

            //添加控件
            contentPane.add(label);
            contentPane.add(textField);
            contentPane.add(button);

            //按钮点击处理 lambda表达式
            button.addActionListener((e) -> {
                onButtonOk();
            });

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    sys();
                }
            });
            thread1.start();
        }

        //事件处理
        private void onButtonOk()
        {
            String str = textField.getText();//获取输入内容

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    gamer();
                }
            });
            thread2.start();

            //判断是否输入了
            if(str.equals(""))
            {
                Object[] options = { "OK ", "CANCEL " };
                JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,null, options, options[0]);
            }

        }
}
