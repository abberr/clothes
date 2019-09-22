import mapper.ClothesMapper;
import model.Garment;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            printUsageInfo();
            return;
        }

        String filePath = args[0];
        System.out.println("Parsing " + filePath + "...");
        String content;
        try {
            content = Files.readString(Paths.get(filePath), Charset.defaultCharset());
        } catch (IOException ex) {
            System.out.println("File not found!");
            printUsageInfo();
            return;
        }

        List<Garment> clothes;

        if (filePath.endsWith(".xml")) {
            clothes = ClothesMapper.readXml(content);
        } else if (filePath.endsWith(".json")) {
            clothes = ClothesMapper.readJson(content);
        } else if (filePath.endsWith(".csv")) {
            clothes = ClothesMapper.readCsv(content);
        } else {
            System.out.println("Invalid file format!");
            printUsageInfo();
            return;
        }

        System.out.println();
        System.out.println("Brand\t\tType\t\tSize\t\tColor");
        System.out.println("----------------------------------------------------");
        clothes.stream().sorted().forEach(System.out::println);
    }

    private static void printUsageInfo() {
        System.out.println("Usage: java -jar <jarfile> <fileName>");
        System.out.println("Supported files are [.xml .json .csv]");
    }
}
