package Creatures;

import java.awt.*;

public abstract class Creature {
    protected final int CREATURE_SIZE = 79;
    protected int row;
    protected int col;
    protected Color color;
    protected String id;
    protected int size = 80;

    /*
        Constructor for the Creatures
     */
    public Creature(int row, int col, Color color, String id) {

        this.row = row;
        this.col = col;
        this.color = color;
        this.id = id;
    }

    /*
        Getter for Row
     */
    public int getRow() {
        return row;
    }

    /*
        Getter for Col
     */
    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /*
        Renderer for the creatures(setting their dimensions)
     */
    public void render(Graphics g) {

        int x = this.col * size;
        int y = this.row * size;

        g.setColor(this.color);
        g.fillRect(x, y, CREATURE_SIZE, CREATURE_SIZE);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }
    /*
        Abstract method
     */
    public abstract boolean isMoveValid(int moveRow, int moveCol);
    /*
        Abstract method
     */
    public abstract boolean isAttackValid(int attackRow, int attackCol);

}
