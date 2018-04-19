package com.epam.task1.help;

import com.epam.task1.products.Coffee;
import java.util.ArrayList;
import static com.epam.task1.help.TextOutputHelper.*;

public class SearchHelper {
    public static void searchCost(ArrayList<Coffee> van){
        double min;
        double max;
        System.out.println("Введите минимальное значение");
        min= Double.parseDouble(enterText());
        System.out.println("Введите максимальное значение");
        max = Double.parseDouble(enterText());
        for (Coffee coffee :van) {
            if (coffee.getCost()>=min && coffee.getCost()<=max)
                showVanElement(coffee);
        }
    }
    public static void searchWeight(ArrayList<Coffee> van){
        double min;
        double max;
        System.out.println("Введите минимальное значение");
        min= Double.parseDouble(enterText());
        System.out.println("Введите максимальное значение");
        max = Double.parseDouble(enterText());
        for (Coffee coffee :van) {
            if (coffee.getWeight()>=min && coffee.getWeight()<=max)
                showVanElement(coffee);
        }
    }
    public static void searchAmount(ArrayList<Coffee> van){
        double min;
        double max;
        System.out.println("Введите минимальное значение");
        min= Double.parseDouble(enterText());
        System.out.println("Введите максимальное значение");
        max = Double.parseDouble(enterText());
        for (Coffee coffee :van) {
            if ((coffee.getAmount()+coffee.getPackAmount())>=min && (coffee.getAmount()+coffee.getPackAmount())<=max)
                showVanElement(coffee);
        }
    }
    public static void searchPhysicalState(ArrayList<Coffee> van){
        String buff;
        System.out.print("Введите состояние - 1) Зерно  2) Молотый  3) Растворисый в банках  4) Растворимый в пакетах: ");
        buff = setPhysicalState(Integer.parseInt(enterText()));
        for (Coffee coffee :van) {
            if (coffee.getPhysicalState().equals(buff))
                showVanElement(coffee);
        }
    }
    public static void searchKind(ArrayList<Coffee> van){
        String buff;
        System.out.print("Введите сорт - 1) Арабика  2) Либерика  3)Робуста :");
        buff = setKind(Integer.parseInt(enterText()));
        for (Coffee coffee :van) {
            if (coffee.getKind().equals(buff))
                showVanElement(coffee);
        }
    }
}
