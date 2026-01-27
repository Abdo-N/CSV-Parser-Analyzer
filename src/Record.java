import java.util.HashMap;

public class Record {
    String[] values;
    private HashMap<String, Integer> columnMap ;

    public Record (String[] values, HashMap<String, Integer> columnMap )
    {
        this.columnMap  = columnMap ;
        this.values = values;
    }

    public Record (Record r)
    {
        this.columnMap = r.columnMap;
        this.values = r.values.clone();
    }

    public String[] getValues()
    {
        return values;
    }

    public String getValue(int index) {
        return values[index];
    }

    public String getValueByName(String coloumnName)
    {
        int position = columnMap.get(coloumnName);
        return values[position];
    }

    @Override
    public String toString() {
        return String.join(", ", values);
    }
    
     public HashMap<String, Integer> getHashMap ()
   {
        return columnMap;
   }
}

