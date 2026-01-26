import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");

        // Test accessing by column name
        Record firstRecord = records.get(0);
        System.out.println("Name: " + firstRecord.getValueByName("name"));
        System.out.println("Age: " + firstRecord.getValueByName("age"));
        System.out.println("City: " + firstRecord.getValueByName("city"));

        // Test the lookup method
        System.out.println("\nAge is at position: " + reader.lookup("age"));
    }
}
