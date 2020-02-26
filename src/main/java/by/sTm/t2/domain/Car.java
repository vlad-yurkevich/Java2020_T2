package by.sTm.t2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@Builder
public class Car {
    private int id;
    private String sMark;
    private String sModel;
    private int iPrice;
    private String sImgPath;
    private String sInfo;
    //--Задаём способ сортировки
    public static final Comparator<Car> COMPARE_BY_ID = Comparator.comparingInt(Car::getId); //--Прямое сравнивание Integer
    public static final Comparator<Car> COMPARE_BY_PRICE = (o1, o2) -> o1.getIPrice() - o2.getIPrice(); //--Через лямбды (чтобы помнить, что так тоже можно)
    public static final Comparator<Car> COMPARE_BY_MODEL = Comparator.comparing(obj -> obj.getSModel()); //--Появилось вроде в Java 8
}
