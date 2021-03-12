package Creatures;

import java.awt.*;

public class Obstacle extends Creature {

    int size   = 80;
    int border = 1;
    int row;
    int col;
    Color color;

    /*
        Constructor fot Obstacles
        @param row row position
        @param col col position
        @param color tile color
     */
    public Obstacle (int row, int col, Color color){
        super(row, col, color, "");
    }


    /*
        Wall renderer
     */
    public void render(Graphics g){

        int tileX    = this.col * size;
        int tileY    = this.row * size;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, size - border,  size - border);
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        return false;
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }
}
