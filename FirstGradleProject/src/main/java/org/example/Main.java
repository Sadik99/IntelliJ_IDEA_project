package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.EXCEL);
            printer.printRecord("Sadik","Hassan",5,"Love it!");
            printer.printRecord("Sakib","Hasan",4,"pretty good, Would be better with an annotation or two.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}