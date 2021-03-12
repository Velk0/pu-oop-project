public class Application {
    public static void main(String[] args){

        //CreaturePositioner positioner = new CreaturePositioner();
        GameBoard gameBoard = new GameBoard(/*positioner.position()*/);
        Renderer renderer   = new Renderer(gameBoard);

    }
}
