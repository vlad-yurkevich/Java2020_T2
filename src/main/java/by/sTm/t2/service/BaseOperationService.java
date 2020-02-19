package by.sTm.t2.service;

import java.util.List;

//--Исполняем через дженерик
public interface BaseOperationService<T> {
    List<T> getList();
    void add(T object);
    void deleteById(int objectId);
    T getById(int objectId);
}
