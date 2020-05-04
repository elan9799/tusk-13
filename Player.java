import java.util.Scanner;

public class Player {
    FildPositions FieldPositions;
    Field field;

    public Player(FildPositions humanFieldPositions, Field field) {
        this.FieldPositions = humanFieldPositions;
        this.field = field;
    }

    public void putMark() throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        field.setPosition(x, y, FieldPositions);
    }

    public Boolean currentPlayer(int turn) {
        field.showField();


        if (field.checkOnWin() == FildPositions.Cross) {
            if (!field.checkSameArrInBase(FildPositions.Cross)) {
                field.Write(FildPositions.Cross);
            }
            System.out.println("Cross Wins ");
            return true;
        } else if (field.checkOnWin() == FildPositions.Zero) {
            if (!field.checkSameArrInBase(FildPositions.Zero)) {
                field.Write(FildPositions.Zero);
            }
            System.out.println("Zero Wins ");
            return true;
        } else if (turn == 10){
            System.out.println("Nobody Wins ");
            return true;
        }

        while (true) {
            System.out.println(FieldPositions + " make a move");
            try {
                putMark();
                break;
            } catch (Exception exception) {
            }
        }
        return false;
    }


}