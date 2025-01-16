package exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App{
    public static void save(Path filepath, Car car){
        String json = car.serialize();
        try (BufferedWriter writer =  Files.newBufferedWriter(filepath)) {
            writer.write(json);
            System.out.println("JSON успешно сохранен в файл: " + filepath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи JSON в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static Car extract(Path filepath){
        try {
            String json = new String(Files.readAllBytes(filepath));
            return Car.deserialize(json);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to read file and deserialize JSON", e);
        }
    }


}
// END
