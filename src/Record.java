public class Record {
    String[] values;

    public Record (String[] values)
    {
        this.values = values;
    }

    public String[] getValues()
    {
        return values;
    }

    public String getValue(int index) {
        return values[index];
    }

    @Override
    public String toString() {
        return String.join(", ", values);
    }
}

