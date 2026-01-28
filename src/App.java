import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader();
        ArrayList<Record> records = reader.read("data.csv");

        GroupBy groupBy = new GroupBy(records);
        HashMap<String, Integer> cityCounts = groupBy.countByColumn("city");
        groupBy.displayCounts(cityCounts);
    }
}
