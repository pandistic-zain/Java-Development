import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gaming extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    //  private int totalBricks = 96;
    private Timer timer;
    private int delay = 10;
    private int playerWidth = 100;
    private int playerX = 310 - playerWidth / 2;
    private int ballDiameter = 20;
    private int ballposX = 310 - ballDiameter / 2;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private MapGenerator map;

    public Gaming() {
        map = new MapGenerator(4, 12);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, 692, 592);

        // Drawing map
        map.draw((Graphics2D) g);

        // Borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // Scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        g.setColor(Color.green);

        // Ensure the rectangle stays within the borders
        if (playerX < 0) {
            playerX = 0;
        } else if (playerX > 592) {
            playerX = 592;
        }

        g.fillRect(playerX, 550, playerWidth, 8);

        // Ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, ballDiameter, ballDiameter);

        // When you won the game
        if (score == 240) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won", 260, 300);

            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 230, 350);
        }

        // When the ball hits the bottom
        if (ballposY > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + score, 190, 300);

            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 230, 350);
        }
    }

    public void keyPressed(KeyEvent e) {
        // if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        //     if (playerX + playerWidth <= 692) {
        //         moveRight();
        //     }
        // }

        // if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        //     if (playerX >= 0) {
        //         moveLeft();
        //     }
        // }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                ballposX = 310 - ballDiameter / 2;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310 - playerWidth / 2;
                score = 0;
                // totalBricks = 48;
                map = new MapGenerator(4, 12);

                repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    // public void moveRight() {
    //     play = true;
    //     playerX += 20;
    // }

    // public void moveLeft() {
    //     play = true;
    //     playerX -= 20;
    // }

    public void incrementScore(int points) {
        score += points;
    }

    public void actionPerformed(ActionEvent e) {
        if (play) {
            // Handle collision with paddle
            if (new Rectangle(ballposX, ballposY, ballDiameter, ballDiameter)
                    .intersects(new Rectangle(playerX, 550, playerWidth, 8))) {
                ballYdir = -ballYdir;
            }

            // Check map collision with the ball
            A: for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, ballDiameter, ballDiameter);

                        if (ballRect.intersects(brickRect)) {
                            map.handleCollision(i, j, this); // Pass the Gaming instance to handleCollision
                            //  totalBricks--;

                            // When ball hits top or bottom of brick
                            ballYdir = -ballYdir;

                            break A;
                        }
                    }
                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;

            // Make the ball bounce off the walls
            if (ballposX < 0 || ballposX > 672) {
                ballXdir = -ballXdir;
            }

            // Make the ball bounce off the top
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }

            // Ensure the ball stays within the borders
            if (ballposX < 0) {
                ballposX = 0;
            } else if (ballposX > 672) {
                ballposX = 672;
            }

            // Ensure the rectangle stays within the borders
            if (playerX < 0) {
                playerX = 0;
            } else if (playerX > 592) {
                playerX = 592;
            }

            // Make the rectangle follow the ball
            playerX = ballposX - playerWidth / 2;

            // Prevent the ball from falling below the paddle
            if (ballposY + ballDiameter >= 550 && ballposY + ballDiameter < 560 && ballYdir > 0) {
                ballYdir = -ballYdir;
            }

            // Check if all bricks are broken
            // if (totalBricks <= 0) {
            //     play = false;
            //     ballXdir = 0;
            //     ballYdir = 0;
            //     repaint();
            // }

            repaint();
        }
    }
}
