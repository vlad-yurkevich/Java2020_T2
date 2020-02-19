package by.sTm.t2.service;

import by.sTm.t2.domain.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CarServiceImpl implements CarService{
    private final List<Car> listCar = new ArrayList<>();

    @PostConstruct
    public void init(){
        listCar.add(
                Car.builder()
                        .id(1)
                        .sMark("BMW")
                        .sModel("M5 F10")
                        .iPrice(120000)
                        .sImgPath("BMW-F10-M5.jpg")
                        .sInfo("BMW M5 Competition предлагает максимальную производительность с еще более ярко выраженной спортивной исключительностью.")
                        .build()
        );
        listCar.add(
                Car.builder()
                        .id(2)
                        .sMark("Audi")
                        .sModel("r8")
                        .iPrice(140000)
                        .sImgPath("Audi-R8.jpg")
                        .sInfo("Audi R8 — среднемоторный полноприводный спортивный автомобиль, производимый немецким автопроизводителем Audi с 2007 года.")
                        .build()
        );
        listCar.add(
                Car.builder()
                        .id(3)
                        .sMark("LADA")
                        .sModel("Vesta Sport")
                        .iPrice(25000)
                        .sImgPath("LADA-Vesta-Sport.jpg")
                        .sInfo("Автомобиль, созданный ради скорости, крепче держится на дороге. И вслед за движением стрелки спидометра каждый элемент конструкции начинает работать с максимальной отдачей.")
                        .build()
        );
    }

    @Override
    public List<Car> getList() {
        doSort(false);
        return this.listCar;
    }

    @Override
    public void add(Car object) {
        this.listCar.add(object);
    }

    @Override
    public void deleteById(int objectId) {
        this.listCar.removeIf(
          el -> el.getId() == objectId
        );
    }

    @Override
    public Car getById(int objectId) {
        return this.listCar.stream() //--Так делать не надо :)
                .filter(car -> car.getId() == objectId)
                .findFirst()
                .orElseThrow(RuntimeException::new); //--В 11 Джаве можно без аргумента
    }

    private void doSort(boolean reverse)
    {
        if (!reverse){ Collections.sort(listCar, Car.COMPARE_BY_ID); }
        else { Collections.sort(listCar, Collections.reverseOrder(Car.COMPARE_BY_ID)); }
    }
}
