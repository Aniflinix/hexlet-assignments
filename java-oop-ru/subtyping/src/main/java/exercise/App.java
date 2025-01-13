package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        // Получаем текущие данные базы данных в виде Map
        Map<String, String> originalData = storage.toMap();

        // Удаляем все существующие данные из базы
        for (String key : originalData.keySet()) {
            storage.unset(key);
        }

        // Добавляем данные с поменянными местами ключами и значениями
        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
