package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Car  deserialize(String json){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, Car.class);

        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to deserialize JSON into Car object", e);
        }

    }
    // END
}
