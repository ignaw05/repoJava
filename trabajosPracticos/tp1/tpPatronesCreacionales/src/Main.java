package main.java;

import main.java.singleton.Database;

public class Main {
    public static void main(String[] args) {

        // SINGLETON
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println(db1 == db2); //  Deberia devolver true por ser la misma instancia

        // FACTORY

}
}