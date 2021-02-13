package service;

import model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    List<Car> findCarByCount(int count);
}
