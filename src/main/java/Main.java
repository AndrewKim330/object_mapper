import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("andrew");
        user.setAge(35);

        Car car1 = new Car();
        car1.setName("Macan");
        car1.setCarNum("11가 1111");
        car1.setType("SUV");

        Car car2 = new Car();
        car2.setName("Veloster");
        car2.setCarNum("22가 2222");
        car2.setType("hatchback");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

//                System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name: " + _name);
        System.out.println("age: " + _age);

//        String _list = jsonNode.get("cars").asText(); // -> not work
//        System.out.println("cars: " + _list);
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode)cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode) jsonNode; // not set method on jsonNode
        objectNode.put("name", "ruben");
        objectNode.put("age", 30);

        System.out.println(objectNode.toPrettyString());

    }
}
