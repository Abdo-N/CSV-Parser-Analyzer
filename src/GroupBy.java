import java.util.ArrayList;
import java.util.HashMap;

public class GroupBy {
    ArrayList<Record> data;
    HashMap<String, Integer> columnIndex;
    
    public GroupBy(ArrayList<Record> data) {
        this.data = data;
        this.columnIndex = data.get(0).getHashMap();
    }
    
    public HashMap<String, Integer> countByColumn(String columnName) {
        // Get column index
        // Create empty HashMap for counts
        // Loop through all records
        // For each record, get the value and update count
        // Return the counts HashMap

        int index = columnIndex.get(columnName);
        HashMap<String, Integer> counts = new HashMap<>();

        for(Record r : data)
        {
            if (counts.containsKey(r.getValue(index)))
            {
                int currentCount = counts.get(r.getValue(index));
                counts.put(r.getValue(index), currentCount + 1);
            } else
            {
                counts.put(r.getValue(index), 1);
            }
        }

        return counts;
    }

    public void displayCounts(HashMap<String, Integer> counts) {
    for (String key : counts.keySet()) {
        System.out.println(key + ": " + counts.get(key));
    }
}
}

