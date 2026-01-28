import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");

        // Filter some data
        Filter filter = new Filter(records);
        ArrayList<Record> filtered = filter.filterByExactMatch("city", "Berlin");

        // Export it
        Exporter exporter = new Exporter();
        exporter.exportToCSV(filtered, reader.getHeaders(), "berlin_people.csv");

        System.out.println("Exported to berlin_people.csv");
}
}
