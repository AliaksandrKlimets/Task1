package com.epam.task1.help;

import com.epam.task1.products.Coffee;
import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextOutputHelper {

    private static BufferedReader reader;
    private static String readerBuffer;

    //Меню для оператора switch
    static public int menu(){
        System.out.println("1) Добавить товар");
        System.out.println("2) Вывести содержимое фургона");
        System.out.println("3) Отсортировать содержимое фургона");
        System.out.println("4) Поиск товара по параметрам");
        System.out.println("5) Удалить элемент");
        System.out.println("6) Выход");
        return Integer.parseInt(enterText());
    }

    //Метод для ввода текста
   static public String enterText(){
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            readerBuffer = reader.readLine();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return readerBuffer;
    }

    //Выбор сорта
    public static String setKind(int i){
        switch (i){
            case 1: return "Арабика";
            case 2: return "Либерика";
            case 3: return "Робуста";
            default: return "Арабика";
        }
    }

    //Выбор физического состояния
    public static String setPhysicalState(int i){
        switch (i){
            case 1: return "Зерно";
            case 2: return "Молотый";
            case 3: return "Растворимый в банке";
            case 4: return "Растворимый в пакетах";
            default: return "Арабика";
        }
    }

    //Отображение товара
    public static void showVanElement(@NotNull Coffee coffee){
        System.out.print("Состояние: "+coffee.getPhysicalState()+" ||| ");
        System.out.print("Сорт: "+coffee.getKind()+" ||| ");
        System.out.print("Цена: "+coffee.getCost()+" ||| ");
        System.out.print("Вес: "+coffee.getWeight()+" ||| ");
        System.out.print("Цена/Вес: "+coffee.getCost()/coffee.getWeight());
        System.out.println();
    }
}

