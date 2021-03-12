import Creatures.Creatures;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame /*implements MouseListener*/ {
        private int hightTileCount = 7;
        private int widthTileCount = 9;
        private Creatures[][]figures;

        /*
            Method, creating and constructing the field(board)
         */
        public GameBoard (){

            this.figures = new Creatures[hightTileCount][widthTileCount];




            this.setSize((widthTileCount + 3) * Tile.TILE_SIZE, (hightTileCount* Tile.TILE_SIZE));
            this.setVisible(true);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Knights, Elves and Dwarfs");
            //this.addMouseListener(this);
        }

        public void renderField(Graphics g, int row, int col){
            Color tileColor = Color.BLACK;
            Tile tile = new Tile(row, col, tileColor);
            tile.render(g);
        }

    private Color getTileColor(int row, int col) {

        boolean isRowEven  = (row % 2 == 0);
        boolean isRowOdd   = !isRowEven;
        boolean isColEven  = (col % 2 == 0);
        boolean isColOdd   = !isColEven;

        if(isRowEven && isColEven   ) return Color.BLACK;
        if(isRowEven && isColOdd    ) return Color.WHITE;
        if(isRowOdd  && isColEven   ) return Color.WHITE;

        return Color.BLACK;
    }


    public void renderGameTile(Graphics g, int row, int col) {

        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    public Creatures getBoardPiece(int row, int col) {
        return this.figures[row][col];
    }

    public boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    public void renderGamePiece(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {

            Creatures p = this.getBoardPiece(row, col);
            p.render(g);
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < hightTileCount; row++) {
            for (int col = 0; col < widthTileCount; col++) {

                this.renderField(g, row, col);
            }
        }
    }
}
