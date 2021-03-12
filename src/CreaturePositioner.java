import Creatures.*;
import java.awt.*;

public class CreaturePositioner {

    public Creature[][] load() {

        Creature[][] figures = new Creature[GameBoard.HIGHT_TILE_COUNT][GameBoard.WIDTH_TILE_COUNT];

        // White
        figures[0][0] = (new Knight(0, 1, Color.CYAN, "Kn"));

        return figures;
    }
}
