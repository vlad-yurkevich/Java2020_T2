package by.sTm.t2.service;

import by.sTm.t2.domain.Car;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CarCmpImpl implements CarCmp {
    public void doCompare(List<Car> listCar, Comparator<Car> cmp, boolean reverse) {
        if (!reverse){ Collections.sort(listCar, cmp); }
        else { Collections.sort(listCar, Collections.reverseOrder(cmp)); }
    }
}