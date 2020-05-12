public class PlayerForFrame extends Player{

    public PlayerForFrame(FildPositions humanFieldPositions, Field field) {
        super(humanFieldPositions, field);
    }

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


}
