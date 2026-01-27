import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader {

    private String[] headers;

    private HashMap <String, Integer> columnIndex = new HashMap<>();

   public CSVReader()
   {

   }

   public ArrayList<Record> read(String fileName)
   {
        ArrayList<Record> record_list = new ArrayList<Record>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            //storing header initially
            headers = br.readLine().split(",");

            for(int i = 0; i < headers.length; i++)
            {
                columnIndex.put(headers[i].trim(),i);
            }

            //storing the rest of the records
            String line;
            while ((line = br.readLine()) != null)
            {
                Record record = new Record(line.split(","), columnIndex);
                record_list.add(record);
            }
        } catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return record_list;
   }
   
   public String[] getHeaders()
   {
    return headers;
   }

   public int lookup (String coloumnName)
   {
        return columnIndex.get(coloumnName);
   }

}
