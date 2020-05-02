import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player first = new Player(FildPositions.Cross, field);
//        Player second = new Player(FildPositions.Zero, field);
        AiRandomPlayer second = new AiRandomPlayer(FildPositions.Zero, field);
        Scanner scanner = new Scanner(System.in);


//        Loop:
        while (true){
//            field.showField();
//            if (field.checkOnWin() == FildPositions.Cross){
//                System.out.println(" Cross Wins ");
//                break Loop;
//            }else if (field.checkOnWin() == FildPositions.Zero){
//                System.out.println(" Zero Wins ");
//                break Loop;
//            }
//            while (true){
//                System.out.println("Cross make a move");
//                try {
//                    first.putMark();
//                    break;
//                }catch (Exception exception){
//                }
//            }
//            field.showField();
//            if (field.checkOnWin() == FildPositions.Cross){
//                System.out.println(" Cross Wins ");
//                break Loop;
//            }else if (field.checkOnWin() == FildPositions.Zero) {
//                System.out.println(" Zero Wins ");
//                break Loop;
//            }
//
//            while (true){
//                System.out.println("Zero make a move");
//                try {
//                    second.putMark();
//                    break;
//                }catch (Exception exception){
//                }
//            }

            if (first.currentPlayer()){
                break;
            }
            if (second.currentPlayer()){
                break;
            }

        }
    }

}
