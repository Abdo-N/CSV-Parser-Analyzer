# Java CSV parser and analyzer
A command-line tool that reads CSV files (like spreadsheets) and lets users analyze the data - think of it like a mini Excel in your terminal.

## Features
1. Loading CSV files
2. Displaying data in formatted tables
3. Filtering (by exact match and numeric range)
4. Sorting (ascending/descending, alphabetically or numerically)
5. Statistics (min, max, average, median)
6. Grouping and counting
7. Exporting results to new CSV files
8. Interactive command-line interface

## Functionality

### Record class
1. Record class acts as "rows" of data (array of string values ex: "age","city", ...)

2. Record class has a hashmap that maps each column title to its header array index ex:

Key (String)  →  Value (Integer)
─────────────────────────────────
"id"          →  0
"name"        →  1
"age"         →  2
"city"        →  3
"rating"      →  4

### CSVReader class
1. Uses an array list of records (so an array of arrays of string arrays) ex of one record: 

Record {
    values: ["1", "Alice", "23", "Berlin", "4.5"]
             [0]    [1]     [2]    [3]      [4]
    
    columnMap: {
        "id" → 0,
        "name" → 1,
        "age" → 2,
        "city" → 3,
        "rating" → 4
    }
}

2. Using FileReader and BufferedReader we store headers alone in a string array and then each "row" of the data is stored into a record then inserted into record array list

### Display class
1. Finds max width in all columns
2. loops over all records and displays them by adding padding (max width)

### Filter class
1. 2 functions: Fitler by exact match (basically a search), Filter by range (search by range)
2. Both functions loop over the data and adds the result into an array list of records and returns it

### Sorter class
1. sorts by bubble sort either ascending or descending

### Stats class
1. Gives average, max, min, and median of a specified column

### Grouper class
1. return hashmap with the count of each element in the specified column

### Export class
1. loads new data into a new CSV file

## Example Workflow
1. Load sample.csv
2. Filter for age > 25
3. Sort by rating descending
4. Export to filtered_results.csv

## Challeneges faced
1. keeping track of all the array lists of records which are arrays in the first place

2. using Bufferedreader/Bufferedwriter and Filereader/Filewriter 

3. learning to use the String class functions like String.join and String.format

4. working with hashamps

5. bubble sorting an array list of record objects which contain string arrays was a nightmare because I needed to deep clone the data and not just operate on the references as it wouldn't work

## Potential updates ??

1. GUI interface
2. Multiple filter conditions
3. Better sorting than bubble sort