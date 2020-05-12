import java.text.FieldPosition;

public abstract class PL {
    public abstract void  putMark() throws Exception;

    public abstract void  putMark(int x, int y) throws Exception;

    public abstract void currentPlayer(int x, int y);

    public abstract void currentPlayer();
}
