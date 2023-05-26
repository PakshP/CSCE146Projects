//Paksh Patel

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpenskisTriangle extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int PIXEL_LIMIT = 30;
    private static final Color FILL_COLOR1 = Color.BLACK;
    private static final Color FILL_COLOR2 = Color.WHITE;

    private void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int pixelLimit) {
        if (pixelLimit <= PIXEL_LIMIT) {
            return;
        }
        // draw the main triangle
        g.setColor(FILL_COLOR1);
        g.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
        // calculate the positions of the three sub-triangles
        int xa = (x1 + x2) / 2;
        int ya = (y1 + y2) / 2;
        int xb = (x2 + x3) / 2;
        int yb = (y2 + y3) / 2;
        int xc = (x3 + x1) / 2;
        int yc = (y3 + y1) / 2;
        // draw the upside-down triangle
        g.setColor(FILL_COLOR2);
        g.fillPolygon(new int[] { xa, xb, xc }, new int[] { ya, yb, yc }, 3);
        // recursively draw the sub-triangles
        drawTriangle(g, x1, y1, xa, ya, xc, yc, pixelLimit / 2);
        drawTriangle(g, xa, ya, x2, y2, xb, yb, pixelLimit / 2);
        drawTriangle(g, xc, yc, xb, yb, x3, y3, pixelLimit / 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTriangle(g, WIDTH / 2, 0, 0, HEIGHT, WIDTH, HEIGHT, WIDTH);
    }

    //GUI frame informatoin
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpenskis's Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        SierpenskisTriangle panel = new SierpenskisTriangle();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
