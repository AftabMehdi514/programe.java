import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.math.*;

public class Airplan extends JFrame implements KeyListener {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int PLAYER_WIDTH = 50;
    private static final int PLAYER_HEIGHT = 20;
    private static final int ENEMY_WIDTH = 20;
    private static final int ENEMY_HEIGHT = 20;
    private static final int BULLET_WIDTH = 5;
    private static final int BULLET_HEIGHT = 10;
    private static final int PLAYER_SPEED = 5;
    private static final int BULLET_SPEED = 10;
    private static final int ENEMY_SPEED = 3;

    private int playerX, playerY;
    private int bulletX, bulletY;
    private int enemyX, enemyY;
    private boolean shooting;

    public Airplan() {
        setTitle("Airplane Shooting Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);

        playerX = WIDTH / 2 - PLAYER_WIDTH / 2;
        playerY = HEIGHT - PLAYER_HEIGHT - 20;
        bulletX = -1;
        bulletY = -1;
        enemyX = (int) (Math.random() * (WIDTH - ENEMY_WIDTH));
        enemyY = 0;

        shooting = false;

        setVisible(true);

        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (shooting) {
            bulletY -= BULLET_SPEED;
            if (bulletY < 0) {
                shooting = false;
            }
        }

        enemyY += ENEMY_SPEED;
        if (enemyY > HEIGHT) {
            enemyX = (int) (Math.random() * (WIDTH - ENEMY_WIDTH));
            enemyY = 0;
        }

        if (bulletX >= enemyX && bulletX <= enemyX + ENEMY_WIDTH &&
                bulletY >= enemyY && bulletY <= enemyY + ENEMY_HEIGHT) {
            // Enemy hit
            enemyX = (int) (Math.random() * (WIDTH - ENEMY_WIDTH));
            enemyY = 0;
            shooting = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, PLAYER_WIDTH, PLAYER_HEIGHT);

        if (shooting) {
            g.setColor(Color.RED);
            g.fillRect(bulletX, bulletY, BULLET_WIDTH, BULLET_HEIGHT);
        }

        g.setColor(Color.GREEN);
        g.fillRect(enemyX, enemyY, ENEMY_WIDTH, ENEMY_HEIGHT);
    }

    public static void main(String[] args) {
        new Airplan();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && playerX > 0) {
            playerX -= PLAYER_SPEED;
        } else if (key == KeyEvent.VK_RIGHT && playerX < WIDTH - PLAYER_WIDTH) {
            playerX += PLAYER_SPEED;
        } else if (key == KeyEvent.VK_SPACE && !shooting) {
            bulletX = playerX + PLAYER_WIDTH / 2 - BULLET_WIDTH / 2;
            bulletY = playerY - BULLET_HEIGHT;
            shooting = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
