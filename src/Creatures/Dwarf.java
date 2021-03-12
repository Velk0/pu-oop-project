package Creatures;

import java.awt.*;

public class Dwarf extends Creatures{
    /*
        Constructor for Knight
        @param row row coordinate
        @param col col coordinate
        @param color for Knights
     */
    public Dwarf (int row, int col, Color color, String id){
        super(row, col, color, "D");
    }
    @Override
    /*
        Method checking if the move we are trying to make is valid
     */
    public boolean isMoveValid(int moveRow, int moveCol){

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = Math.abs(moveCol - this.col);

        return rowCoefficient == 1 || colCoefficient == 1;
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol){
        return false;
    }
}
