import java.util.ArrayList;
import java.util.HashMap;

public class Filter {
    ArrayList<Record> data;
    HashMap <String, Integer> columnIndex;
    public Filter (ArrayList<Record> data)
    {
        this.data = data;
        this.columnIndex = data.get(0).getHashMap();
    }

    public ArrayList<Record> filterByExactMatch (String columnName, String value)
    {
        ArrayList<Record> result = new ArrayList<>();
        int index = columnIndex.get(columnName);

        for(Record record : data)
        {
            if(record.getValue(index).equals(value))
                result.add(record);
        }

        return result;
    }

    public ArrayList<Record> filterByRange (String columnName, int min, int max)
    {
        ArrayList<Record> result = new ArrayList<>();
        int index = columnIndex.get(columnName);

        for(Record record : data)
        {
            try{
                int num = Integer.parseInt(record.getValue(index));
                if (num >= min && num <= max)
                    result.add(record);
            } catch (NumberFormatException e)
            {
                continue;
            }
        }
        return result;
    }

    
}
