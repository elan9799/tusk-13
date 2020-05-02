import org.w3c.dom.events.EventException;

import java.util.ArrayList;
import java.util.List;

public class Field {
    FildPositions [][] field;

    public Field(int n) {
        field = new FildPositions[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = FildPositions.Emptyspace;
            }
        }
    }
    public void showField(){
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == FildPositions.Emptyspace){
                    System.out.print("- ");
                }else if (field[i][j] == FildPositions.Cross){
                    System.out.print("x ");
                }else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    public void setPosition (int x, int y, FildPositions fildPositions) throws Exception{
        if (field[x - 1][y - 1].equals(FildPositions.Emptyspace)){
            field[x - 1][y - 1] = fildPositions;
        }else {
            throw new Exception(" Fuck u ");
        }
    }
    public FildPositions checkOnWin(){

        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != FildPositions.Emptyspace) {
                return field[i][0];
            }
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[0][i] != FildPositions.Emptyspace) {
                return field[0][i];
            }
        }
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != FildPositions.Emptyspace) {
            return field[0][0];
        }
        if(field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[1][1] != FildPositions.Emptyspace) {
            return field[1][1];
        }

        return FildPositions.Emptyspace;
    }
}
enum FildPositions {
    Cross, Zero, Emptyspace
}