import java.awt.*;
public class MapGenerator {
    public static final int INITIAL_BRICK_STATE = 1;
    public static final int CRACKED_BRICK_STATE = 2;
    public static final int BROKEN_BRICK_STATE = 0;

    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = INITIAL_BRICK_STATE;
            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    Color brickColor = (map[i][j] == CRACKED_BRICK_STATE) ? Color.gray : Color.white;
                    g.setColor(brickColor);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    // this is just to show separate brick, the game can still run without it
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }

    public int getBrickValue(int row, int col) {
        return map[row][col];
    }

    public void handleCollision(int row, int col, Gaming game) {
        if (map[row][col] == INITIAL_BRICK_STATE) {
            // First collision, mark the brick as cracked
            map[row][col] = CRACKED_BRICK_STATE;
        } else if (map[row][col] == CRACKED_BRICK_STATE) {
            // Second collision, mark the brick as broken
            map[row][col] = BROKEN_BRICK_STATE;
            game.incrementScore(5);
        }
    }
}