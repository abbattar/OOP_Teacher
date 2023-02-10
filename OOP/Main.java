//Написать программу с семью классами, описывающими данных в таблице персонажей.
//Для каждого создать по два конструктора и геттеры приватных полей.
//А также метод возвращающий строку с кратким описанием персонажа.
//В основной программе создать списки с пятью экземплярами каждого персонажа и вывести информацию обо все в консоль.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> farmer = new ArrayList<>();
        String[] farmerNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : farmerNames) {
            farmer.add(new Farmer(name));
        }
        for (BaseHero character : farmer) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> rogue = new ArrayList<>();
        String[] rogueNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : rogueNames) {
            rogue.add(new Rogue(name));
        }
        for (BaseHero character : rogue) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> sniper = new ArrayList<>();
        String[] sniperNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : sniperNames) {
            sniper.add(new Sniper(name));
        }
        for (BaseHero character : sniper) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> crossbowman = new ArrayList<>();
        String[] crossbowmanNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : crossbowmanNames) {
            crossbowman.add(new Crossbowman(name));
        }
        for (BaseHero character : crossbowman) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> spearman = new ArrayList<>();
        String[] spearmanNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : spearmanNames) {
            spearman.add(new Spearman(name));
        }
        for (BaseHero character : spearman) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> mage = new ArrayList<>();
        String[] mageNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : mageNames) {
            mage.add(new Mage(name));
        }
        for (BaseHero character : mage) {
            System.out.println(character);
        }
        System.out.println("====================");

        ArrayList<BaseHero> monk = new ArrayList<>();
        String[] monkNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        for (String name : monkNames) {
            monk.add(new Monk(name));
        }
        for (BaseHero character : monk) {
            System.out.println(character);
        }
        System.out.println("====================");

    }
}
