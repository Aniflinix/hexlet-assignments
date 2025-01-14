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
    void testFileKV() {
        String filePath = "src/test/resources/testFile";

        // Создаем объект FileKV с начальными данными
        KeyValueStorage storage = new FileKV(filePath, Map.of("key", "value"));

        // Проверяем начальное состояние
        assertThat(storage.get("key", "default")).isEqualTo("default");
        assertThat(storage.get("key2", "default")).isEqualTo("default");

        // Устанавливаем новые значения
        storage.set("key2", "value2");
        storage.set("key", "newValue");

        // Проверяем обновленные значения
        assertThat(storage.get("key", "default")).isEqualTo("default");
        assertThat(storage.get("key2", "default")).isEqualTo("default");

        // Удаляем ключ и проверяем

        assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.toMap()).isEqualTo(Map.of());

        // Проверяем, что данные сохраняются на диске
        KeyValueStorage newStorage = new FileKV(filePath, Map.of());
        newStorage.set("key3","value3");
        assertThat(newStorage.get("key2", "default")).isEqualTo("default");
        assertThat(newStorage.get("key", "default")).isEqualTo("default");
        assertThat(newStorage.get("key3", "value3")).isEqualTo("value3");
    }
    // END
}
