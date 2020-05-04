public class AiRandomPlayer extends Player {

    public AiRandomPlayer(FildPositions FieldPositions, Field field) {
        super(FieldPositions, field);
    }

    @Override
    public void putMark () throws Exception{
        int x = (int)(Math.random() * 3 + 1);
        int y = (int)(Math.random() * 3 + 1);
        field.setPosition(x,y,FieldPositions);
    }

}
