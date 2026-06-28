# CSV Parser & Analyzer

A command-line tool that reads CSV files and lets you explore the data interactively — filter, sort, get stats, group and count, and export the results. Think of it as a tiny Excel for your terminal.

## Features

- Load any CSV file
- Display data as a clean, aligned table
- Filter by exact match or by numeric range
- Sort ascending/descending, alphabetically or numerically
- Statistics: min, max, average, median
- Group and count values in a column
- Export the current working set to a new CSV
- Interactive menu-driven CLI, with a reset option to undo filters/sorts

## Quick start

```bash
cd src
javac *.java
java Main
```

Then follow the menu prompts — load a CSV, then filter, sort, analyze, or export it.

```
=== CSV Analyzer ===
1. Load CSV file
2. Display data
3. Filter data
4. Sort data
5. Show statistics
6. Group and count
7. Export data
8. Exit
9. Reset
```

### Example workflow

1. Load `sample.csv`
2. Filter for `age` in range 25–100
3. Sort by `rating`, descending
4. Export the result to `filtered_results.csv`

## How it's organized

| Class | Responsibility |
|---|---|
| `Record` | One row of data — a `String[]` of values plus a shared column-name → index map, so any value can be looked up by name (`getValueByName("age")`) instead of by position |
| `CSVReader` | Reads a file into a header array and a list of `Record`s |
| `Display` | Pretty-prints the current data as a padded, aligned table |
| `Filter` | Returns a new list of records matching an exact value or falling within a numeric range |
| `Sorter` | Sorts a list of records by a given column, ascending or descending (bubble sort; numeric if the column parses as a number, lexicographic otherwise) |
| `Stats` | Computes min, max, average, and median for a numeric column |
| `GroupBy` | Counts how many records share each distinct value in a column |
| `Exporter` | Writes the current headers + records back out to a CSV file |

`Main` ties everything together as a menu loop: it keeps track of the original `records` and a `workingSet` that filters/sorts get applied to, so you can chain operations (filter, then sort, then export) without reloading the file, and reset back to the original data at any point.

## Challenges along the way

- Keeping track of an `ArrayList` of `Record`s that each wrap a `String[]` — lists of objects wrapping arrays got confusing fast.
- Sorting a list of `Record` objects without quietly sorting shared references — `Sorter` deep-copies each `Record` before sorting so the original `workingSet`/`records` lists are never mutated underneath you.
- First real use of `BufferedReader`/`BufferedWriter` and `FileReader`/`FileWriter` for file I/O.
- Getting comfortable with `HashMap`s for the column-name lookups, and string utilities like `String.join` and `String.format` for clean output.

## Possible next steps

- A simple GUI instead of the CLI menu
- Support for combining multiple filter conditions at once
- A faster sort than bubble sort for larger files
