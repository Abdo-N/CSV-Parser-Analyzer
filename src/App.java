import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");
        Display displayer = new Display(reader.getHeaders(), records);

        displayer.displayData();
    }
}
