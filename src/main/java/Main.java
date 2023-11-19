public class Main {
    public static void main(String[] args) {
        Playroom room = new Playroom();
        Host conferanse = new Host("Семен", room);
        conferanse.putUnitInRoom();
    }
}