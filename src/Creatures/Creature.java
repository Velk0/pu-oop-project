package Creatures;

import java.awt.*;

public abstract class Creature {
    protected final int CREATURE_SIZE = 79;
    protected int row;
    protected int col;
    protected Color color;
    protected String id;
    protected int size = 80;

    public Creature(int row, int col, Color color, String id) {

        this.row = row;
        this.col = col;
        this.color = color;
        this.id = id;
    }

    //public Creature(int row, int col, Color color) {
//
    //    this.row = row;
    //    this.col = col;
    //    this.color = color;
    //}

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g) {

        int x = this.col * size;
        int y = this.row * size;

        g.setColor(this.color);
        g.fillRect(x, y, CREATURE_SIZE, CREATURE_SIZE);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }

    public abstract boolean isMoveValid(int moveRow, int moveCol);

    public abstract boolean isAttackValid(int attackRow, int attackCol);

}
