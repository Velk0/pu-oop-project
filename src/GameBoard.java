import Creatures.Creature;
import Creatures.Dwarf;
import Creatures.Elf;
import Creatures.Knight;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame /*implements MouseListener*/ {

        protected static final int HIGHT_TILE_COUNT = 7;
        protected static final int WIDTH_TILE_COUNT = 9;

        private Creature[][] figures;
        private Creature selectedCreature;

        /*
            Method, creating and constructing the field(board)
         */
        public GameBoard(/*Creature[][] figures*/){

            this.figures = new Creature[HIGHT_TILE_COUNT][WIDTH_TILE_COUNT];
            // Knights
            figures[1][1] = (new Knight(1, 1, Color.BLUE));
            figures[1][2] = (new Knight(1, 2, Color.BLUE));
            figures[5][6] = (new Knight(5, 6, Color.BLUE));
            figures[5][7] = (new Knight(5, 7, Color.BLUE));

            // Elf
            figures[1][3] = (new Elf(1, 3, Color.ORANGE));
            figures[1][4] = (new Elf(1, 4, Color.ORANGE));
            figures[5][5] = (new Elf(5, 5, Color.ORANGE));
            figures[5][4] = (new Elf(5, 4, Color.ORANGE));

            // Dwarfs
            figures[1][5] = (new Dwarf(1, 5, Color.RED));
            figures[1][6] = (new Dwarf(1, 6, Color.RED));
            figures[5][3] = (new Dwarf(5, 3, Color.RED));
            figures[5][2] = (new Dwarf(5, 2, Color.RED));

        }

        public Creature getSelectedPiece() {

            return selectedCreature;

        }

        public void setSelectedPiece(Creature selectedPiece) {

            this.selectedCreature = selectedPiece;

        }

        public void movePiece(int row, int col, Creature p) {
            // 1. Get the original coordinates of the selected piece
            int initialRow = p.getRow();
            int initialCol = p.getCol();

            // 2. Move the piece to the new coordinates
            p.move(row, col);

            // 3. Swap the reference to the selected piece from the original coordinates
            this.figures[p.getRow()][p.getCol()] = this.selectedCreature;
            this.figures[initialRow][initialCol] = null;

            // 4. Remove reference to selected piece
            this.selectedCreature = null;
        }

    private Color getTileColor(int row, int col) {

        if(row == 2 || row == 3 || row == 4) return Color.LIGHT_GRAY;
        if(row == 0 || row == 1 || row == 5 || row == 6){
            boolean isRowEven  = (row % 2 == 0);
            boolean isRowOdd   = !isRowEven;
            boolean isColEven  = (col % 2 == 0);
            boolean isColOdd   = !isColEven;

            if(isRowEven && isColEven   ) return Color.BLACK;
            if(isRowEven && isColOdd    ) return Color.GRAY;
            if(isRowOdd  && isColEven   ) return Color.GRAY;
        }

        return Color.BLACK;

    }


    public void renderGameTile(Graphics g, int row, int col) {

        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    public Creature getBoardPiece(int row, int col) {
        return this.figures[row][col];
    }

    public boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    public void renderGamePiece(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {

            Creature p = this.getBoardPiece(row, col);
            p.render(g);
        }
    }

    public int getBoardDimentionBasedOnCoordinates(int coordinates) {
        return coordinates / Tile.TILE_SIZE;
    }
}
