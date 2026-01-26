import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();

        reader.displayRecords(reader.read("data.csv"));
    }
}
