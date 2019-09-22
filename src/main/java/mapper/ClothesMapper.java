package mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.ClothesWrapper;
import model.Garment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClothesMapper {

    public static List<Garment> readXml(String content) throws IOException {
        return new XmlMapper().readValue(content, ClothesWrapper.class).getClothes();
    }

    public static List<Garment> readJson(String content) throws IOException {
        return new ObjectMapper().readValue(content, ClothesWrapper.class).getClothes();
    }

    public static List<Garment> readCsv(String content) {

        return Arrays.stream(content.split("\n"))
                .skip(1)
                .map(line -> {
                    var garment = new Garment();
                    garment.setType(line.split(",")[0].trim());
                    garment.setSize(line.split(",")[1].trim());
                    garment.setBrand(line.split(",")[2].trim());
                    garment.setColor(line.split(",")[3].trim());
                    return garment;
                })
                .collect(Collectors.toList());
    }
}
