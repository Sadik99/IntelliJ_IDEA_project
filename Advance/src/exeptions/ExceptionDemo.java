package exeptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo {
    public static void show() throws IOException
    {
        try (var reader= new FileReader("file.txt");
             var write=new FileWriter("...")
        ) {
            var value= reader.read();
        } catch (IOException e) {
            System.out.println("Can't read data!");
        }
        var account=new Account();
        try {
            account.deposit(5);
        } catch (IOException e) {
            System.out.println("Hurry!");
            throw e;
        }
        try {
            account.withdraw(10);
        }catch (AccountException e) {
            e.printStackTrace();
        }
    }
    public static void sayHello(String name)
    {
        System.out.println(name.toUpperCase());
    }
}
