public class Test {
    public static void main(String[] args) {
        Field field = new Field(3);
        field.showField();
        field.showField();
        Player one = new Player(FildPositions.Cross, field);
        Player two = new Player(FildPositions.Zero, field);



    }
}
