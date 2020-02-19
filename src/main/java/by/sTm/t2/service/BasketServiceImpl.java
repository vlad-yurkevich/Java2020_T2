package by.sTm.t2.service;

import by.sTm.t2.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    private final List<Car> listBasket = new ArrayList<>();

    @Override
    public List<Car> getList() {
        return this.listBasket;
    }

    @Override
    public void add(Car object) {
        this.listBasket.add(object);
    }

    @Override
    public void deleteById(int objectId) {
        this.listBasket.removeIf(
                el -> el.getId() == objectId
        );
    }

    @Override
    public Car getById(int objectId) {
        return this.listBasket.stream() //--Так делать не надо :)
                .filter(car -> car.getId() == objectId)
                .findFirst()
                .orElseThrow(RuntimeException::new); //--В 11 Джаве можно без аргумента
    }
}
