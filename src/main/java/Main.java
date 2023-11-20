public class Main {
    public static void main(String[] args) {
        Playroom room = new Playroom("Сеня", "Тимон");
        for (int i = 0; i < 1000; i++) {
            room.run();
        }
        room.printResult();



    }
}