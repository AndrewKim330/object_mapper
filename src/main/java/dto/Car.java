package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Car {
    private String name;

    @JsonProperty("car_num")
    private String carNum;
    @JsonProperty("TYPE")
    private String type;
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNum='" + carNum + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
