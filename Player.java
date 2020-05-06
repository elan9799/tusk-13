import java.util.Scanner;

public class Player {
    FildPositions FieldPositions;
    Field field;

    final int REP_MINUS = -4;
    final int REP_PLUS = 9;

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
                field.Write(FildPositions.Cross, REP_PLUS);
                field.Write(FildPositions.Zero, REP_MINUS);
            }else if (field.checkSameArrInBase(FildPositions.Cross)){
                field.WriteIfSameInBase(FildPositions.Cross, REP_PLUS);
                field.WriteIfSameInBase(FildPositions.Zero, REP_MINUS);
            }
            System.out.println("Cross Wins ");
            return true;
        } else if (field.checkOnWin() == FildPositions.Zero) {
            if (!field.checkSameArrInBase(FildPositions.Zero)) {
                field.Write(FildPositions.Zero, REP_PLUS);
                field.Write(FildPositions.Cross, REP_MINUS);
            }else if (field.checkSameArrInBase(FildPositions.Zero)){
                field.WriteIfSameInBase(FildPositions.Cross, REP_MINUS);
                field.WriteIfSameInBase(FildPositions.Zero, REP_PLUS);
            }
            System.out.println("Zero Wins ");
            return true;
        } else if (turn == 10){
            System.out.println("Nobody Wins ");
            field.WriteIfSameInBase(FildPositions.Zero, REP_PLUS);
            field.WriteIfSameInBase(FildPositions.Cross, REP_PLUS);
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