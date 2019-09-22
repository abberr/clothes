# Clothes
This program reads a file containing a list of clothes, sorts them by size and prints the sorted list to standard out.

## Requirements
- Maven
- Java 11 or later

## How to build
`mvn install`

## How to run
`java -jar target/clothes-1.0-SNAPSHOT.jar filePath`

## Examples
```
$ java -jar target/clothes-1.0-SNAPSHOT.jar src/test/resources/clothes.csv
Parsing src/test/resources/clothes.csv...

Brand           Type            Size            Color
----------------------------------------------------
Calvin Klein    T-shirt         XS              Grey
H&M             Sweater         S               Black
Riley           Shirt           M               Blue
Adidas          Shirt           M               Pink
Ullared         Sweater         M               Red
Tiger           T-shirt         L               White
Vans            Tanktop         L               White
Gymshark        Sweatpants      L               Grey
Nike            T-shirt         L               White
FILA            Hoodie          XL              Black

 ```
 



