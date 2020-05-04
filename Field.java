import com.sun.source.tree.IfTree;
import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.*;

public class Field {
    FildPositions [][] field;
    List<Integer> arr = new ArrayList<>();

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
            if (!checkSameArrInBase(fildPositions)){
                WriteInArr(x, y);
            }


        }else {
            throw new Exception(" Fuck u ");
        }
    }

    public boolean checkSameArrInBase(FildPositions fildPositions) {
        try {
            Scanner sc = new Scanner(new File("src/memo.txt"));
            while (sc.hasNext()){
                String str = sc.nextLine();
                if (str.equals("Z W") && fildPositions.equals(FildPositions.Zero)){
                    List<Integer> arr2 = new ArrayList<>();
                    str = sc.nextLine();
                    String[] strTemp = str.split(" ");
                    for (int i = 0; i < strTemp.length; i++) {
                        arr2.add(Integer.parseInt(String.valueOf(strTemp[i])));
                    }
                    if (arr.equals(arr2)){
                        System.out.println("eq");
                        return true;
                    }
                }else if (str.equals("C W") && fildPositions.equals(FildPositions.Cross)) {
                    List<Integer> arr2 = new ArrayList<>();
                    str = sc.nextLine();
                    String[] strTemp = str.split(" ");
                    for (int i = 0; i < strTemp.length; i++) {
                        arr2.add(Integer.parseInt(String.valueOf(strTemp[i])));
                    }

                    if (arr.equals(arr2)) {
                        System.out.println("eq");
                        return true;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void WriteInArr(int x, int y){
        arr.add(x);
        arr.add(y);

    }
    public void Write (FildPositions FieldPositions){
        try (FileWriter writer = new FileWriter("src/memo.txt", true)){
            writer.write(FieldPositions.toString().charAt(0) + " W" + "\n");
            for (int i = 0; i < arr.size(); i++) {
                    writer.write(new Integer(arr.get(i)).toString());
                    writer.write(" ");
                }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
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

    public int[] findeWinnerStrat(FildPositions fildPositions) {

        if (fildPositions.equals(FildPositions.Zero)) {
            try {
                Scanner sc = new Scanner(new File("src/memo.txt"));

                while (sc.hasNext()) {
                    String str = sc.nextLine();
                    if (str.equals("Z W")) {
                        List<Integer> arr2 = new ArrayList<>();
                        str = sc.nextLine();
                        String[] strTemp = str.split(" ");
                        for (int i = 0; i < strTemp.length; i++) {
                            arr2.add(Integer.parseInt(String.valueOf(strTemp[i])));
                        }
                        int counter = 0;
                        if (arr.size() != 0 && arr2.size() > arr.size()) {
                            for (int i = 0; i < arr.size(); i++) {
                                if (arr.get(i) == arr2.get(i)) {
                                    counter++;
                                }
                            }
                        }
                        if  (counter == arr.size()) {
                            int[] nextMove = new int[2];
                            nextMove[0] = arr2.get(arr.size() );
                            nextMove[1] = arr2.get(arr.size() + 1);
                            return nextMove;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (fildPositions.equals(FildPositions.Cross)) {
            try {
                Scanner sc = new Scanner(new File("src/memo.txt"));

                while (sc.hasNext()) {
                    String str = sc.nextLine();
                    if (str.equals("C W")) {
                        List<Integer> arr2 = new ArrayList<>();
                        str = sc.nextLine();
                        String[] strTemp = str.split(" ");
                        for (int i = 0; i < strTemp.length; i++) {
                            arr2.add(Integer.parseInt(String.valueOf(strTemp[i])));
                        }
                        int counter = 0;
                        if (arr.size() != 0 && arr2.size() > arr.size()) {
                            for (int i = 0; i < arr.size(); i++) {
                                    if (arr.get(i) == arr2.get(i)) {
                                        counter++;
                                    }
                            }
                        }
                        if  (counter == arr.size()) {
                            int[] nextMove = new int[2];
                            nextMove[0] = arr2.get(arr.size() );
                            nextMove[1] = arr2.get(arr.size() + 1);
                            return nextMove;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int[] nextMove = new int[2];
        return nextMove;
    }
}

enum FildPositions {
    Cross, Zero, Emptyspace
}