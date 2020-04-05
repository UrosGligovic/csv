# csv
Java 8 library for parsing csv files

Example use:
```
  Csv csv = new Csv("C:\\Users\\User\\Documents\\BigFilesPlay\\csvExample.csv");
        
  csv.stream()
     .forEach(x->System.out.println(x.get("columnName")));
 ```
