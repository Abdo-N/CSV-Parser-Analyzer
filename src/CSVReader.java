import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class CSVReader {

   public CSVReader()
   {

   }

   public void read(String fileName)
   {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
   }
   
}
