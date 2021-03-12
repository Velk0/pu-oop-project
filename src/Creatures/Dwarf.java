package Creatures;

import java.awt.*;

public class Dwarf extends Creature {
    /*
        Constructor for Knight
        @param row row coordinate
        @param col col coordinate
        @param color for Knights
     */
    public Dwarf (int row, int col, Color color){
        super(row, col, color, "D");
    }
    @Override
    /*
        Method checking if the move we are trying to make is valid
     */
    public boolean isMoveValid(int moveRow, int moveCol){

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = Math.abs(moveCol - this.col);

        return rowCoefficient <= 2 || colCoefficient <= 2;
    }

    /*
        Method checking if attack can be made
     */
    @Override
    public boolean isAttackValid(int attackRow, int attackCol){
        return false;
    }
}
