import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Host {
    private String name;
    private List CHOISE = Arrays.asList("коза", "коза", "автомобиль");
    public Playroom room;

    public Host(String name, Playroom room) {
        this.name = name;
        this.room = room;
    }

    public void takeFromCHOISE(int index) {
        CHOISE.remove(index);
    }

    public void returnToCHOISE() {
        CHOISE = Arrays.asList("коза", "коза", "автомобиль");
    }

    public void putUnitInRoom() {
        Random first = new Random();
        Random second = new Random();
        int choiseFirst = first.nextInt(3) + 1;
        int choiseSecond =choiseFirst-1;
        int choiseThird = Math.abs(choiseFirst - choiseSecond);

        System.out.println(choiseFirst + ";" + choiseSecond);
    }
}
