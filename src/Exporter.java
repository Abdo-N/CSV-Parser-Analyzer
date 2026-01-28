import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Exporter {

    public Exporter()
    {

    }

    public void exportToCSV(ArrayList<Record> data, String[] headers, String fileName)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            
            bw.write(String.join(",",headers));
            bw.newLine();
            for(Record record : data)
            {
                bw.write(String.join(",", record.getValues()));
                bw.newLine();
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
