package by.sTm.t2.service;

import by.sTm.t2.domain.Car;

import java.util.Comparator;
import java.util.List;

public interface CarCmp {
    void doCompare(List<Car> listCar, Comparator<Car> cmp, boolean reverse);
}

