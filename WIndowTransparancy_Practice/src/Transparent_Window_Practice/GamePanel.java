package Transparent_Window_Practice;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public JFrame window;
    Thread gameThread;

    public void setWindowDefaults() {
        this.window = new JFrame();
        this.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.window.setUndecorated(true);
        this.window.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        this.setOpaque(false);
        this.window.setAlwaysOnTop(true);
        this.window.add(this);

        // Load an image
        try {
            ImageIcon imageIcon = new ImageIcon("src/Test.gif");
            JLabel imageLabel = new JLabel(imageIcon);
            this.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }


        this.window.setVisible(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void startGameThread() {
        // Use a separate Runnable to encapsulate the logic
        Runnable gameLogic = () -> {
            // Add your game logic here
            while (true) {
                // Your game loop logic
            }
        };

        gameThread = new Thread(gameLogic);
        gameThread.start();
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.setWindowDefaults();
        gamePanel.startGameThread();
    }
}
