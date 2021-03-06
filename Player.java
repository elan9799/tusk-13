import java.util.Scanner;

public class Player extends PL{
    FildPositions FieldPositions;
    Field field;

    final int REP_MINUS = -4;
    final int REP_PLUS = 9;

    public Player(FildPositions humanFieldPositions, Field field) {
        this.FieldPositions = humanFieldPositions;
        this.field = field;
    }

    @Override
    public void  putMark() throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        field.setPosition(x, y, FieldPositions);
    }

    @Override
    public void putMark(int x, int y) throws Exception {
        field.setPosition(x + 1, y + 1, FieldPositions);
    }

    @Override
    public void currentPlayer() {
        while (true) {
            System.out.println(FieldPositions + " make a move");
            try {
                putMark();
                break;
            } catch (Exception exception) {
            }
        }
    }

    //
    public FildPositions testOnWin (int turn){
        if (field.checkOnWin() == FildPositions.Cross) {
            if (!field.checkSameArrInBase(FildPositions.Cross)) {
                field.Write(FildPositions.Cross, REP_PLUS);
                field.Write(FildPositions.Zero, REP_MINUS);
            }else if (field.checkSameArrInBase(FildPositions.Cross)){
                field.WriteIfSameInBase(FildPositions.Cross, REP_PLUS);
                field.WriteIfSameInBase(FildPositions.Zero, REP_MINUS);
            }
            System.out.println("Cross Wins ");
            return FildPositions.Cross;
        } else if (field.checkOnWin() == FildPositions.Zero) {
            if (!field.checkSameArrInBase(FildPositions.Zero)) {
                field.Write(FildPositions.Zero, REP_PLUS);
                field.Write(FildPositions.Cross, REP_MINUS);
            }else if (field.checkSameArrInBase(FildPositions.Zero)){
                field.WriteIfSameInBase(FildPositions.Cross, REP_MINUS);
                field.WriteIfSameInBase(FildPositions.Zero, REP_PLUS);
            }
            System.out.println("Zero Wins ");
            return FildPositions.Zero;
        } else if (turn >= 9){
            System.out.println("Nobody Wins ");
            field.WriteIfSameInBase(FildPositions.Zero, REP_PLUS);
            field.WriteIfSameInBase(FildPositions.Cross, REP_PLUS);
            return FildPositions.Emptyspace;
        }
        return null;
    }
    @Override
    public void currentPlayer(int x, int y) {
        while (true) {
            System.out.println(FieldPositions + " make a move");
            try {
                putMark(x,y);
                break;
            } catch (Exception exception) {
            }
        }
    }

}