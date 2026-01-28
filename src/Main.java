import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables to store state
        ArrayList<Record> records = null;
        ArrayList<Record> workingSet = null;  // Current filtered/sorted data
        String[] headers = null;
        CSVReader reader = new CSVReader();
        
        boolean running = true;
        
        while (running) {
            // Display menu
            System.out.println("\n=== CSV Analyzer ===");
            System.out.println("1. Load CSV file");
            System.out.println("2. Display data");
            System.out.println("3. Filter data");
            System.out.println("4. Sort data");
            System.out.println("5. Show statistics");
            System.out.println("6. Group and count");
            System.out.println("7. Export data");
            System.out.println("8. Exit");
            System.out.println("9. Reset");
            System.out.print("\nEnter your choice: ");
            
            try {
            int choice = scanner.nextInt();
            scanner.nextLine();

             switch (choice) {
                case 1:
                    // Load CSV
                    System.out.println("\nInput filename: ");
                    String fileName = scanner.nextLine();
                    records = reader.read(fileName);
                    workingSet = records;
                    headers = reader.getHeaders();
                    System.out.println("Loaded " + records.size() + " records");
                    break;
                case 2:
                    // Display data
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else
                    {
                        Display displayer = new Display(headers, workingSet);
                        displayer.displayData();
                    }
                    break;
                case 3:
                    // Filter data
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else {
                        Filter filter = new Filter(workingSet);
                        System.out.println("Input column name: ");
                        String columnName = scanner.nextLine();
                        System.out.println("\nFilter by exact match or range?");
                        String input = scanner.nextLine();
                        if(input.toLowerCase().equals("match"))
                        {
                            System.out.println("Input value: ");
                            input = scanner.nextLine();
                            workingSet = filter.filterByExactMatch(columnName,input);
                        } else if (input.toLowerCase().equals("range"))
                        {
                            System.out.println("Input min value: ");
                            int num1 = Integer.parseInt(scanner.nextLine());
                            System.out.println("Input max value: ");
                            int num2 = Integer.parseInt(scanner.nextLine());
                            workingSet = filter.filterByRange(columnName,num1,num2);
                        }
                    }
                    break;
                case 4:
                    // Sort data
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else
                    {
                        Display displayer = new Display(headers, workingSet);
                        Sorter sorter = new Sorter(workingSet);
                        System.out.println("Input column name: ");
                        String columnName =  scanner.nextLine();
                        System.out.println("Ascending [Y] Descending [N]");
                        char ascending = scanner.nextLine().charAt(0);
                        if (ascending == 'Y')
                        {
                            workingSet = sorter.sort(columnName, true);
                        } else
                        {
                            workingSet = sorter.sort(columnName, false);
                        }
                        displayer.displayData();
                    }
                    break;
                case 5:
                    // Statistics
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else
                    {
                        Stats stats = new Stats(workingSet);
                        System.out.println("Input column name: ");
                        String columnName =  scanner.nextLine();
                        System.out.println("Average: " + stats.getAvg(columnName));
                        System.out.println("Min: " + stats.getMin(columnName));
                        System.out.println("Max: " + stats.getMax(columnName));
                        System.out.println("Median: " + stats.getMedian(columnName));
                    }
                    break;
                case 6:
                    // Group and count
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else
                    {
                        System.out.println("Input column name: ");
                        String columnName =  scanner.nextLine();
                        GroupBy grouper = new GroupBy(workingSet);
                        grouper.displayCounts(grouper.countByColumn(columnName));
                    }
                    break;
                case 7:
                    // Export
                    if(workingSet == null)
                    {
                        System.out.println("No data loaded.");
                    } else
                    {
                        System.out.println("\nInput filename: ");
                        fileName = scanner.nextLine();
                        Exporter exp = new Exporter();
                        exp.exportToCSV(workingSet, headers, fileName);
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                case 9:
                    if (records == null)
                        System.out.println("No data loaded.");
                    else
                    {
                        workingSet = records;
                        System.out.println("Reset to original data.");
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();  // Clear buffer
                continue;
            }

        }
        
        scanner.close();
    }
}