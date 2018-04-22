//добавь класс в пакет controller или runner
package com.epam.task1;

import com.epam.task1.help.VanLauncher;

//переименуй класс тоже в какой-нибудь Сontroller или Runner
public class Main {

    public static void main(String[] args) {
        VanLauncher launcher = new VanLauncher();
        launcher.launchVan();
    }
}
