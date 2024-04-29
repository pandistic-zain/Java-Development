import javax.swing.*;
public class Game {
    public static void main(String[] args) {
      
            JFrame frame = new JFrame("Brick Breaker Game");
            Gaming game = new Gaming();
            frame.setBounds(10, 10, 700, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(game);
            frame.setVisible(true);
        
    }
    }
