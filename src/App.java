import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");
        Filter filter = new Filter(records);

        // Test exact match
        ArrayList<Record> berlinRecords = filter.filterByExactMatch("city", "Berlin");
        System.out.println("People in Berlin:");
        Display display = new Display(reader.getHeaders(), berlinRecords);
        display.displayData();

        // Test range
        ArrayList<Record> youngPeople = filter.filterByRange("age", 20, 25);
        System.out.println("\nPeople aged 20-25:");
        display = new Display(reader.getHeaders(), youngPeople);
        display.displayData();
    }
}
