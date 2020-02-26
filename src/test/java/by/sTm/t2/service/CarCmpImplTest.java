package by.sTm.t2.service;

import by.sTm.t2.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarCmpImplTest {
    CarCmpImpl carCmp = new CarCmpImpl();

    @Test
    void doCompareByPrice() {
        List<Car> carList = new ArrayList<>();
        carList.add(
                Car.builder()
                        .id(1)
                        .sMark("BMW")
                        .sModel("M5 F10")
                        .iPrice(120000)
                        .sImgPath("BMW-F10-M5.jpg")
                        .sInfo("BMW M5 Competition предлагает максимальную производительность с еще более ярко выраженной спортивной исключительностью.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(2)
                        .sMark("Audi")
                        .sModel("r8")
                        .iPrice(140000)
                        .sImgPath("Audi-R8.jpg")
                        .sInfo("Audi R8 — среднемоторный полноприводный спортивный автомобиль, производимый немецким автопроизводителем Audi с 2007 года.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(3)
                        .sMark("LADA")
                        .sModel("Vesta Sport")
                        .iPrice(25000)
                        .sImgPath("LADA-Vesta-Sport.jpg")
                        .sInfo("Автомобиль, созданный ради скорости, крепче держится на дороге. И вслед за движением стрелки спидометра каждый элемент конструкции начинает работать с максимальной отдачей.")
                        .build()
        );

        //--По цене (Vesta самая дешёвая)
        Assertions.assertNotEquals(25000, carList.get(0).getIPrice());
        carCmp.doCompare(carList, Car.COMPARE_BY_PRICE, false);
        Assertions.assertEquals(25000, carList.get(0).getIPrice());
    }

    @Test
    void doCompareByModel() {
        List<Car> carList = new ArrayList<>();
        carList.add(
                Car.builder()
                        .id(1)
                        .sMark("BMW")
                        .sModel("M5 F10")
                        .iPrice(120000)
                        .sImgPath("BMW-F10-M5.jpg")
                        .sInfo("BMW M5 Competition предлагает максимальную производительность с еще более ярко выраженной спортивной исключительностью.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(2)
                        .sMark("Audi")
                        .sModel("r8")
                        .iPrice(140000)
                        .sImgPath("Audi-R8.jpg")
                        .sInfo("Audi R8 — среднемоторный полноприводный спортивный автомобиль, производимый немецким автопроизводителем Audi с 2007 года.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(3)
                        .sMark("LADA")
                        .sModel("Vesta Sport")
                        .iPrice(25000)
                        .sImgPath("LADA-Vesta-Sport.jpg")
                        .sInfo("Автомобиль, созданный ради скорости, крепче держится на дороге. И вслед за движением стрелки спидометра каждый элемент конструкции начинает работать с максимальной отдачей.")
                        .build()
        );

        //--По модели (r8 самая последняя)
        Assertions.assertNotEquals("r8", carList.get(2).getSModel());
        carCmp.doCompare(carList, Car.COMPARE_BY_MODEL, false);
        Assertions.assertEquals("r8", carList.get(2).getSModel());
    }

    @Test
    void doCompareByIdReverse() {
        List<Car> carList = new ArrayList<>();
        carList.add(
                Car.builder()
                        .id(1)
                        .sMark("BMW")
                        .sModel("M5 F10")
                        .iPrice(120000)
                        .sImgPath("BMW-F10-M5.jpg")
                        .sInfo("BMW M5 Competition предлагает максимальную производительность с еще более ярко выраженной спортивной исключительностью.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(2)
                        .sMark("Audi")
                        .sModel("r8")
                        .iPrice(140000)
                        .sImgPath("Audi-R8.jpg")
                        .sInfo("Audi R8 — среднемоторный полноприводный спортивный автомобиль, производимый немецким автопроизводителем Audi с 2007 года.")
                        .build()
        );
        carList.add(
                Car.builder()
                        .id(3)
                        .sMark("LADA")
                        .sModel("Vesta Sport")
                        .iPrice(25000)
                        .sImgPath("LADA-Vesta-Sport.jpg")
                        .sInfo("Автомобиль, созданный ради скорости, крепче держится на дороге. И вслед за движением стрелки спидометра каждый элемент конструкции начинает работать с максимальной отдачей.")
                        .build()
        );

        //--По номеру в обратном порядке (BMW самая последняя)
        Assertions.assertNotEquals(1, carList.get(2).getId());
        carCmp.doCompare(carList, Car.COMPARE_BY_ID, true);
        Assertions.assertEquals(1, carList.get(2).getId());
    }
}