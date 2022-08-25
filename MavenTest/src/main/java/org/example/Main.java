package org.example;

import com.google.gson.Gson;
public class Main {
    public static void main(String[] args) throws NoClassDefFoundError{

        System.out.println("Hello world!");
        Gson gson=new Gson();
        MyApp myApp=new MyApp();
        myApp.setName("Sadik");
        myApp.setAge(23);
        System.out.printf("Info is : %s%n",gson.toJson(myApp));
    }
}