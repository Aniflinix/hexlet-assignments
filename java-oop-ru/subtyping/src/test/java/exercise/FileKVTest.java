package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testFileKV(){
        String filePath = "src/test/resources/testFile";
        Map<String, String> initialData = Map.of("key1", "value1", "key2", "value2");
        Map<String, String> expectedData = Map.of(
                "key2", "value2",
                "key3", "value3"
        );
        KeyValueStorage storage = new FileKV(filePath, initialData);
        KeyValueStorage newStorage = new FileKV(filePath, Map.of());
        assertThat(newStorage.toMap()).isEqualTo(expectedData);
    }
    // END
}
