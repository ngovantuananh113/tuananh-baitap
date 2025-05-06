package baitapcasllzoom1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bai27 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JButton startButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Bai27 frame = new Bai27();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public Bai27() {
        setTitle("JProgressBar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true); // Hiển thị số %

        contentPane.add(progressBar, BorderLayout.CENTER);

        startButton = new JButton("Start");
        contentPane.add(startButton, BorderLayout.SOUTH);

        // Bắt sự kiện click nút Start
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgress();
            }
        });
    }

    private void startProgress() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // 50ms x 100 lần = 5 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int value = i;
                SwingUtilities.invokeLater(() -> progressBar.setValue(value));
            }
        });
        thread.start();
    }
}
