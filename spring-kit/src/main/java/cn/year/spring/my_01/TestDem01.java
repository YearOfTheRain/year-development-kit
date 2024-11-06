package cn.year.spring.my_01;

/**
 * @author YearOfTheRain
 * @create 2024-11-05  10:47
 */
public class TestDem01 {

    public static void main(String[] args) {

        // 第一版
        CatService catService = new CatService();
        System.out.println(catService.cry());
        DogService dogService = new DogService();
        System.out.println(dogService.cry());


    }
}
