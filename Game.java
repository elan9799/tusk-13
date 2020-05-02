public class Game {
    public static void main(String[] args) {
        Field field = new Field(3);
        AiRandomPlayer first = new AiRandomPlayer(FildPositions.Cross, field);
        AiRandomPlayer second = new AiRandomPlayer(FildPositions.Zero, field);

        int turn = 0;
        while (true){
            turn++;
            if (first.currentPlayer(turn)){
                break;
            }
            turn++;
            if (second.currentPlayer(turn)){
                break;
            }
        }
    }

}
