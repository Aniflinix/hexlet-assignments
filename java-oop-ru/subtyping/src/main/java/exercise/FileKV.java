package exercise;

// BEGIN
import java.util.Map;
public class FileKV implements KeyValueStorage{
    private final String filepath;
    public FileKV(String filepath, Map <String,String> initialdata){
        this.filepath = filepath;
        Utils.writeFile(filepath,Utils.serialize(initialdata));

    }
    private Map<String, String> readData() {
        String content = Utils.readFile(filepath);
        return Utils.deserialize(content);
    }
    private void writeData(Map<String, String> data) {
        String serializedData = Utils.serialize(data);
        Utils.writeFile(filepath, serializedData);
    }

    @Override
    public void set(String key, String value){
        Map<String,String> data = readData();
    }
    @Override
    public void unset(String key) {
        Map<String, String> data = readData();
        data.remove(key);
        writeData(data);
    }


    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = readData();
        return data.getOrDefault(key, defaultValue);
    }


    @Override
    public Map<String, String> toMap() {
        return readData();
    }
}
// END
