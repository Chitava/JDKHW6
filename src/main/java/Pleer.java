import java.util.Arrays;
import java.util.Random;

public class Pleer {
    private String name;
    public Playroom room;
    private int [] doorNumber = new int[]{1,1,1};

    public Pleer(String name, Playroom room) {
        this.name = name;
        this.room = room;
    }

    public int myChoiseMove(){
        Random r = new Random();
        int move = r.nextInt(3);
        while (doorNumber[move] != 1){
            move = r.nextInt(3);
        }
        System.out.println("Я выбираю дверь № " + (move+1));
        return move;
    }


    public void myMove(int move){
        doorNumber[move] = 0;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
