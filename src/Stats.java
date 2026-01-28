import java.util.ArrayList;
import java.util.HashMap;

public class Stats{
    ArrayList<Record> data;
    HashMap<String, Integer> columnIndex;
    Sorter sorter;
    
    public Stats(ArrayList<Record> data) {
        this.data = data;
        this.columnIndex = data.get(0).getHashMap();
        sorter = new Sorter(data);
    }
    
    public double getMin(String columnName) {
        int index = columnIndex.get(columnName);

        try {
            Double.parseDouble(data.get(0).getValue(index));
        } catch (NumberFormatException e) {
            System.out.println("Column doesn't contain numbers");
            return 0;
        }

        ArrayList<Record> sorted = sorter.sort(columnName, true);
        return Double.parseDouble(sorted.get(0).getValue(index));
    }

    public double getMax(String columnName) {
        int index = columnIndex.get(columnName);

        try {
            Double.parseDouble(data.get(0).getValue(index));
        } catch (NumberFormatException e) {
            System.out.println("Column doesn't contain numbers");
            return 0;
        }

        ArrayList<Record> sorted = sorter.sort(columnName, false);
        return Double.parseDouble(sorted.get(0).getValue(index));
    }

    public double getAvg(String columnName)
    {
        int index = columnIndex.get(columnName);
        double total = 0;

        try {
            Double.parseDouble(data.get(0).getValue(index));
        } catch (NumberFormatException e) {
            System.out.println("Column doesn't contain numbers");
            return 0;
        }

        for (Record record : data)
        {
            total +=  Double.parseDouble(record.getValue(index));
        }

        return total / data.size();
    }

    public double getMedian(String columnName)
    {
        int index = columnIndex.get(columnName);

        ArrayList<Record> sorted = sorter.sort(columnName, true);

        int size = sorted.size();
        
        if (size % 2 == 1) {
            // Odd - return middle element
            return Double.parseDouble(sorted.get(size / 2).getValue(index));
        } else {
            // Even - return average of two middle elements
            double mid1 = Double.parseDouble(sorted.get(size / 2 - 1).getValue(index));
            double mid2 = Double.parseDouble(sorted.get(size / 2).getValue(index));
            return (mid1 + mid2) / 2.0;
        }
    }
}    

