public class Application {
    public static void main(String[] args){
        CreaturePositioner loader = new CreaturePositioner();
        GameBoard gameBoard     = new GameBoard(loader.load());
        Renderer renderer  = new Renderer(gameBoard);
    }
}
