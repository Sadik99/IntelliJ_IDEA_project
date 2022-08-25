import exeptions.ExceptionDemo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ExceptionDemo.show();
        } catch (Throwable e) {
            //throw new RuntimeException(e);
            System.out.println("An unexpected error occurred!");
        }
    }
}