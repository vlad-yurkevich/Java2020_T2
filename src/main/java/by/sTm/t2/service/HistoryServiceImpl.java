package by.sTm.t2.service;

import by.sTm.t2.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    private List<Car> listHistory = new ArrayList<>();

    @Override
    public void add(Car object) {
        this.listHistory.add(object);
    }

    @Override
    public Car getById(int objectId) {
        return listHistory.stream() //--Так делать не надо :)
                .filter(car -> car.getId() == objectId)
                .findFirst()
                .orElseThrow(RuntimeException::new); //--В 11 Джаве можно без аргумента
    }

    @Override
    public void deleteById(int objectId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Car> getList() {
        return this.listHistory;
    }
}
