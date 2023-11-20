import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Playroom {
    private ArrayList<String> doors;
    private Map<Integer, String> result;
    private String choiseDoor;
    private int winCount;
    private Host conferanse;
    private Pleer pleer;
    private Map<Integer, Integer> itog;

    public Playroom(String nameConferance, String namePleer) {
        doors = new ArrayList<>();
        conferanse = new Host(nameConferance, this);
        conferanse.putUnitInRoom();
        pleer = new Pleer(namePleer, this);
        result = new HashMap<>();
        itog = new HashMap();
        itog.put(1, 0);
        itog.put(2, 0);
        itog.put(3, 0);
    }

    public List getDoors() {
        return doors;
    }

    public void setPrizeOutTheDoors(String unit) {
        this.doors.add( unit);
    }

    public String openDoor(int index){
        String prize = doors.get(index);
        System.out.println("За дверью номер " + (index+1) + " находится " + prize);
        return prize;
    }


    public Map getResult() {
        return result;
    }


    public void setResult(Integer key, String result) {
        this.result.put(key, result);
    }


    public void setCount() {
        this.winCount++;
    }


    private void saveResult() {
        try (FileWriter writer = new FileWriter("result.txt", true)) {
            for (Map.Entry<Integer, String> entry : result.entrySet()) {
                writer.write("Ход - " + (entry.getKey()+1) + "- результат " + entry.getValue());
                writer.append('\n');
            }writer.append("=======================================");
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void printResult(){
        System.out.println("Выйгран приз с 1 попытки - " + itog.get(1) + " раз");
        System.out.println("Выйгран приз со 2 попытки - " + itog.get(2) + " раз");
        System.out.println("Выйгран приз с 3 попытки - " + itog.get(3) + " раз");
    }



    public void run(){
        for (int i = 0; i < 3; i++) {
            doors.clear();
            conferanse.putUnitInRoom();
            conferanse.makeChoise(pleer);
            int choise = pleer.myChoiseMove();
            if (doors.get(choise).equals("автомобиль")){
                System.out.println("Может быть Вы хотите поменять свой выбор?");
                Random r = new Random();
                boolean yes = r.nextBoolean();
                if (yes){
                    choise = pleer.myChoiseMove();
                    System.out.println("Пожалуй соглашусь и выберу дверь № " + (choise+1));
                }else {
                    System.out.println("Нет, я хочу выбрать дверь № " + (choise+1));
                }
            }
            conferanse.openDoor(choise);
            setResult(choise, doors.get(choise));
            System.out.println(doors.get(choise));
            if (doors.get(choise) == "автомобиль"){
                int val = itog.get(i+1);
                itog.put(i+1, val+1);
                saveResult();
                break;
            }
        }

    }


}
