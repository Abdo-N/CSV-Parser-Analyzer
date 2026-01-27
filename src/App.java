import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
      CSVReader reader = new CSVReader();
ArrayList<Record> records = reader.read("data.csv");

Sorter sorter = new Sorter(records);

// Test sorting by age (ascending)
System.out.println("Sorted by age (ascending):");
ArrayList<Record> sortedByAge = sorter.sort("age", true);
Display display = new Display(reader.getHeaders(), sortedByAge);
display.displayData();

System.out.println("\nSorted by name (alphabetically):");
ArrayList<Record> sortedByName = sorter.sort("name", true);
display = new Display(reader.getHeaders(), sortedByName);
display.displayData();

System.out.println("\nSorted by rating (descending):");
ArrayList<Record> sortedByRating = sorter.sort("rating", false);
display = new Display(reader.getHeaders(), sortedByRating);
display.displayData();
    }
}
