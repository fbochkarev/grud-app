package service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "bmw", "525"));
        cars.add(new Car(2, "lada", "vesta"));
        cars.add(new Car(3, "mazda", "6"));
        cars.add(new Car(4, "toyota", "camry"));
        cars.add(new Car(5, "lexus", "ls500"));

        return cars;
    }

    @Override
    public List<Car> findCarByCount(int count) {
        return findAll().stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
