package com.epam.task1.help;

import com.epam.task1.container.Van;
import com.epam.task1.products.Coffee;
import java.util.ArrayList;
import static com.epam.task1.help.SearchHelper.*;
import static com.epam.task1.help.TextOutputHelper.*;
import static java.lang.System.exit;

public class VanLauncher {

    public void launchVan(){
        double vanAmount;
        double maxCost;
        System.out.print("Введите объем фургона ");
        vanAmount = Double.parseDouble(enterText());
        System.out.print("Введите максиальную стоимость груза ");
        maxCost = Double.parseDouble(enterText());

        Van van = new Van(vanAmount,maxCost);

        while (true){
            switch (menu()){
                case 1: addCoffee(van); break;
                case 2: showVan(van); break;
                case 3: sortVan(van); break;
                case 4: searchProduct(van); break;
                case 5: deleteProduct(van); break;
                case 6: exit(0); break;
                default: System.out.println("Нет такого варианта"); break;
            }
        }
    }

    //Добавление в фургон товаров
    private void addCoffee(Van van){
        Coffee coffee;
        String physicalState;
        String kind;
        double amount;
        double packAmount;
        double cost;
        double weight;
        int count;
        System.out.print("Введите состояние - 1) Зерно  2) Молотый  3) Растворисый в банках  4) Растворимый в пакетах: ");
        physicalState = setPhysicalState(Integer.parseInt(enterText()));
        System.out.print("Введите сорт - 1) Арабика  2) Либерика  3)Робуста :");
        kind = setKind(Integer.parseInt(enterText()));
        System.out.print("Введите объем товара: ");
        amount = Double.parseDouble(enterText());
        System.out.print("Введите объем упаковки: ");
        packAmount = Double.parseDouble(enterText());
        System.out.print("Введите стоимость товара: ");
        cost = Double.parseDouble(enterText());
        System.out.print("Введите вес товара: ");
        weight = Double.parseDouble(enterText());
        System.out.print("Введите количество: ");
        count = Integer.parseInt(enterText());
        for(int i=0; i<count; i++) {
            if((van.getBalanceCost()-cost)>=0 && (van.getBalanceAmount()-amount-packAmount)>=0) {
                coffee = new Coffee(physicalState, kind, amount, packAmount, cost, weight);
                van.getVan().add(coffee);
                van.setBalanceCost(van.getBalanceCost()-cost);
                van.setBalanceAmount(van.getBalanceAmount()-amount-packAmount);
                System.out.println("Товар добавлен");
            }
            else {
                System.out.println("Нельзя добавить товар. Объем фургона или стоимость товара переполнены");
                break;
            }
        }
        System.out.println();
    }

    //Метод для вывода всего содержимого фургона
    private void showVan(Van van){
        System.out.println("Изначальный объем: "+van.getVanAmount());
        System.out.println("Доступный объем: "+van.getBalanceAmount());
        System.out.println("Максимальная стоимость: "+van.getMaxCost());
        System.out.println("Доступная стоимость: "+van.getBalanceCost());
        for (Coffee coffee : van.getVan()) {
            showVanElement(coffee);
        }

    }

    //Сортировка по отношению цена/вес
    private void sortVan(Van van_elem){
        Coffee buff;
        ArrayList<Coffee> van = van_elem.getVan();
        for (int i = 0; i < van.size()-1; i++) {
            for (int j = i+1; j < van.size(); j++) {
                if ((van.get(i).getCost()/van.get(i).getWeight())>(van.get(j).getCost()/van.get(j).getWeight())){
                    buff = van.get(i);
                    van.set(i, van.get(j));
                    van.set(j, buff);
                }
            }
        }
        System.out.println("Отсортировано");
        System.out.println();
    }

    //Поиск в фургоне товаров по параметрам
    private void searchProduct(Van van_elem){
        ArrayList<Coffee> van = van_elem.getVan();
        System.out.println("Поиск по: 1)Стоимости 2)Весу 3)Суммарному объему 4)Физ. состоянию 5)Сорту ");
        switch (Integer.parseInt(enterText())){
            case 1: searchCost(van);
                break;
            case 2: searchWeight(van);
                break;
            case 3: searchAmount(van);
                break;
            case 4: searchPhysicalState(van);
                break;
            case 5: searchKind(van);
                break;
            default:
                System.out.println("Ошибка!");
        }
    }

    //Удаление продукта из фургона
    private void deleteProduct(Van van_elem){
        int i =0;
        ArrayList<Coffee> van = van_elem.getVan();
        for (Coffee coffee :van) {
            System.out.print(((i++)+1)+") ");
            System.out.print("Цена: "+coffee.getCost()+" ||| ");
            System.out.println("Суммарный объем: "+(coffee.getPackAmount()+coffee.getAmount())+" ||| ");

        }
        System.out.println("Какой товар вы хотите удалить?");
        int index = Integer.parseInt(enterText());
        if(index<=van.size())
            van.remove(van.get(index-1));
        else System.out.println("веден неверный индекс");

    }

}
