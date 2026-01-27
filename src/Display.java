import java.util.ArrayList;

public class Display {
    int width = 0;
    String[] header;
    ArrayList<Record> data;

    public Display (String[] header, ArrayList<Record> data)
    {
        this.data = data;
        this.header = header;
    }

    public void displayData()
    {
        String[] formattedHeaders = new String[header.length];
        for(int i = 0; i < header.length; i++)
        {
            formattedHeaders[i] = String.format("%-" + getMaxWidth() + "s", header[i]);
        }

        System.out.println(String.join(" | ", formattedHeaders));

        System.out.println();

        for(Record record : data)
        {
            String[] formattedValues = new String[record.getValues().length];
            for(int i = 0; i < record.getValues().length; i++)
            {
                formattedValues[i] = String.format("%-" + getMaxWidth() + "s", record.getValue(i));
            }
            System.out.println(String.join(" | ", formattedValues));
        }
    }

    public int getMaxWidth() //max width of header and data
    {
        int maxWidth = 0;

        //getting max width in header first
        for(String text : header)
        {
            if (text.length() > maxWidth)
                maxWidth = text.length();
        }

        //getting max width from records
        for(Record record : data) //looping through records arraylist
        {
            for(String value : record.getValues()) //looping thorugh String[] values in current record
            {
                if(value.length() > maxWidth)
                    maxWidth = value.length();
            }
        }
        return maxWidth;
    }
}
