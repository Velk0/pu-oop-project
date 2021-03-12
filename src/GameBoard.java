import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame /*implements MouseListener*/ {
        private int hightTileCount = 7;
        private int widthTileCount = 9;
        private Object[][]figures;

        /*
            Method, creating and constructing the field(board)
         */
        public GameBoard (){

            this.figures = new Object[hightTileCount][widthTileCount];


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

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < hightTileCount; row++) {
            for (int col = 0; col < widthTileCount; col++) {

                this.renderField(g, row, col);
            }
        }
    }
}
