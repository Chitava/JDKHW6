import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Playroom {
    public List doors;
    public Map<Integer, String> result;
    public int winCount;

    public List getDoors() {
        return doors;
    }

    public void setDoors(String unit) {
        this.doors.add(unit);
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
        try (FileWriter writer = new FileWriter("result.txt", false)) {
            for (Map.Entry<Integer, String> entry : result.entrySet()) {
                writer.write("Ход - " + entry.getKey() + "- результат" + entry.getValue());
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
