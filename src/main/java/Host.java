import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Host {
    private String name;
    private List<String> choise = Arrays.asList("коза", "коза", "автомобиль");
    public Playroom room;


    public Host(String name, Playroom room) {
        this.name = name;
        this.room = room;
    }

    public String openDoor(int index) {
        String prize = room.openDoor(index);
        return prize;
    }

    public void returnToCHOISE() {
        choise = Arrays.asList("коза", "коза", "автомобиль");
    }

    public void putUnitInRoom() {
        Random first = new Random();
        int choiseSecond = 0;
        int choiseThird = 0;
        int choiseFirst = first.nextInt(3) + 1;
        switch (choiseFirst) {
            case (1):
                if (choiseFirst % 2 == 0) {
                    choiseSecond = 2;
                    choiseThird = 3;
                } else {
                    choiseThird = 2;
                    choiseSecond = 3;
                }
                break;
            case (2):
                if (choiseFirst % 2 == 0) {
                    choiseSecond = 3;
                    choiseThird = 1;
                } else {
                    choiseSecond = 1;
                    choiseThird = 3;
                }
                break;
            case (3):
                if (choiseFirst % 2 == 0) {
                    choiseSecond = 2;
                    choiseThird = 1;
                } else {
                    choiseSecond = 1;
                    choiseThird = 2;
                }
        }
        room.setPrizeOutTheDoors(choise.get(choiseFirst-1));
        room.setPrizeOutTheDoors(choise.get(choiseSecond-1));
        room.setPrizeOutTheDoors(choise.get(choiseThird-1));
    }

    public void makeChoise(Pleer pleer){
        System.out.println("Сделайте Ваш выбор " + pleer.getName());
    }
}
