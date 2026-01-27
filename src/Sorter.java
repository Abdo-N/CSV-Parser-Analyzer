import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Sorter {

    ArrayList<Record> data;
    HashMap <String, Integer> map;

    public Sorter(ArrayList<Record> data)
    {
        this.data = data;
        this.map = data.get(0).getHashMap();
    }

    public ArrayList<Record> sort (String columnName, boolean ascending)
    {
        int index = map.get(columnName);
        
        //deep copying data
        ArrayList<Record> data_copy = new ArrayList<>();
        for(Record r : data)
        {
            data_copy.add(new Record(r));
        }

        // Outer loop - number of passes
        for(int pass = 0; pass < data_copy.size() - 1; pass++) {
    
        // Inner loop - compare adjacent elements
        for(int i = 0; i < data_copy.size() - 1 - pass; i++) {
        
            Record r1 = data_copy.get(i);
            Record r2 = data_copy.get(i+1);
        
            String val1 = r1.getValue(index);
            String val2 = r2.getValue(index);
        
            // Determine if we need to swap
            boolean shouldSwap = false;
        
            try {
                int num1 = Integer.parseInt(val1);
                int num2 = Integer.parseInt(val2);
            
                if (ascending) {
                    shouldSwap = (num1 > num2);
                } else {
                    shouldSwap = (num1 < num2);
                }
            
            } catch (NumberFormatException e) {
            // Compare as strings
            int comparison = val1.compareTo(val2);
            
            if (ascending) {
                shouldSwap = (comparison > 0);
            } else {
                shouldSwap = (comparison < 0);
            }
        }
        
        if (shouldSwap) {
            Collections.swap(data_copy, i, i+1);
        }
      }
    }
        return data_copy;
    }

}
