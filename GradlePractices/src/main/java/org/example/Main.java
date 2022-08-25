package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Gson gson=new Gson();
        MyInfo myInfo=new MyInfo();
        myInfo.setName("Sakib Al Hasan");
        myInfo.setAge(35);
        System.out.println(gson.toJson(myInfo));
    }
}