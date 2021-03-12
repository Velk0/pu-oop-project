import Creatures.*;
import java.awt.*;

public class CreaturePositioner {

    public Creature[][] position() {

        Creature[][] figures = new Creature[GameBoard.HIGHT_TILE_COUNT][GameBoard.WIDTH_TILE_COUNT];

        // Knights
        figures[1][1] = (new Knight(1, 1, Color.BLUE));
        figures[1][2] = (new Knight(1, 2, Color.BLUE));
        figures[5][6] = (new Knight(5, 6, Color.BLUE));
        figures[5][7] = (new Knight(5, 7, Color.BLUE));

        return figures;
    }
}
