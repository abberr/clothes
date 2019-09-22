package mapper;

import model.Garment;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ClothesMapperTest {

    private static final String FILE_PATH_CSV = "src/test/resources/clothes.csv";
    private static final String FILE_PATH_XML = "src/test/resources/clothes.xml";
    private static final String FILE_PATH_JSON = "src/test/resources/clothes.json";

    @Test
    public void csvMapperTest() throws IOException {
        String content = Files.readString(Paths.get(FILE_PATH_CSV), Charset.defaultCharset());

        List<Garment> clothes = new ClothesMapper().readCsv(content);

        assertTrue("All clothes mapped", clothes.size() == 10);
    }

    @Test
    public void xmlMapperTest() throws IOException {
        String content = Files.readString(Paths.get(FILE_PATH_XML), Charset.defaultCharset());

        List<Garment> clothes = new ClothesMapper().readXml(content);

        assertTrue("All clothes mapped", clothes.size() == 8);
    }

    @Test
    public void jsonMapperTest() throws IOException {
        String content = Files.readString(Paths.get(FILE_PATH_JSON), Charset.defaultCharset());

        List<Garment> clothes = new ClothesMapper().readJson(content);

        assertTrue("All clothes mapped", clothes.size() == 10);
    }

}
