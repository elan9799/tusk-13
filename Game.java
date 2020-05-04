public class Game {
    public static void main(String[] args) {
       while (true) {
            Field field = new Field(3);
//            AiRandomPlayer first = new AiRandomPlayer(FildPositions.Cross, field);
//            AiRandomPlayer second = new AiRandomPlayer(FildPositions.Zero, field);
//            Player first = new Player(FildPositions.Cross, field);
//            Player second = new Player(FildPositions.Zero, field);
//            AiRandomPlayer second = new AiRandomPlayer(FildPositions.Zero, field);
            AiRandomPreparedPlayer first = new AiRandomPreparedPlayer(FildPositions.Cross, field);
            AiRandomPreparedPlayer second = new AiRandomPreparedPlayer(FildPositions.Zero, field);

            int turn = 0;
            while (true) {
                turn++;
                if (first.currentPlayer(turn)) {
                    break;
                }
                turn++;
                if (second.currentPlayer(turn)) {
                    break;
                }
            }
       }
    }
}
