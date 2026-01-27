import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");

        Stats stats = new Stats(records);

        System.out.println("Age statistics:");
        System.out.println("Min: " + stats.getMin("age"));
        System.out.println("Max: " + stats.getMax("age"));
        System.out.println("Average: " + stats.getAvg("age"));
        System.out.println("Median: " + stats.getMedian("age"));

        System.out.println("\nRating statistics:");
        System.out.println("Min: " + stats.getMin("rating"));
        System.out.println("Max: " + stats.getMax("rating"));
        System.out.println("Average: " + stats.getAvg("rating"));
        System.out.println("Median: " + stats.getMedian("rating"));
    }
}
