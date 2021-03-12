import Creatures.Creature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Renderer extends JFrame implements MouseListener {

    GameBoard gameBoardLogic;

    public Renderer(GameBoard gameBoardLogic) {

        // Reference to game logic
        this.gameBoardLogic = gameBoardLogic;

        // Reference to UI logic
        this.setSize((GameBoard.WIDTH_TILE_COUNT + 3) * Tile.TILE_SIZE, (GameBoard.HIGHT_TILE_COUNT* Tile.TILE_SIZE));
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Knights, Elves and Dwarfs");
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.gameBoardLogic.getBoardDimentionBasedOnCoordinates(e.getY());
        int col = this.gameBoardLogic.getBoardDimentionBasedOnCoordinates(e.getX());

        // check if piece is already selected
        if(this.gameBoardLogic.getSelectedPiece() != null) {

            Creature f = this.gameBoardLogic.getSelectedPiece();

            if(f.isMoveValid(row, col)) {

                this.gameBoardLogic.movePiece(row, col, f);
                this.repaint();
                return;
            }
        }

        // * move

        // check if piece is available
        if(this.gameBoardLogic.hasBoardPiece(row, col)) {
            this.gameBoardLogic.setSelectedPiece(this.gameBoardLogic.getBoardPiece(row, col));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {

        for(int row = 0; row < GameBoard.HIGHT_TILE_COUNT; row++) {
            for(int col = 0; col < GameBoard.WIDTH_TILE_COUNT; col++) {

                this.gameBoardLogic.renderGameTile(g, row, col);
                this.gameBoardLogic.renderGamePiece(g, row, col);
            }
        }
    }
}
