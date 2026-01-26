import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private String[] headers;

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

            //storing the rest of the records
            String line;
            while ((line = br.readLine()) != null)
            {
                Record record = new Record(line.split(","));
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

   public void displayRecords(ArrayList<Record> records)
   {
        System.out.println(String.join(" | ", headers));
        System.out.println();

        for(Record record : records)
        {
            System.out.println(String.join(" | ", record.getValues()));
        }
   }

}
