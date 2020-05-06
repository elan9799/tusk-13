public class AiRandomPreparedPlayer extends Player {

    public AiRandomPreparedPlayer(FildPositions FieldPositions, Field field) {
        super(FieldPositions, field);
    }


    @Override
    public void putMark() throws Exception {
        int [] xAndY = field.findeWinnerStrat(FieldPositions);
        int x = xAndY[0];
        int y = xAndY[1];
        if (xAndY[0] == 0 || xAndY[1] == 0){
            x = (int) (Math.random() * 3 + 1);
            y = (int) (Math.random() * 3 + 1);
        }
        field.setPosition(x, y, FieldPositions);
    }

}
