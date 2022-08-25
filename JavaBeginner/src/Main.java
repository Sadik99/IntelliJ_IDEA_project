import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        PezDispenser pez=new PezDispenser("Sadik");
//        System.out.printf("Max PEZ allowed %d \n",PezDispenser.MAX_PEZ);
//        System.out.printf("The dispenser is %s %n",pez.getPezDispenser());
//        if(pez.isEmpty()) System.out.println("Pez is Empty!");
//        if(!pez.dispense())System.out.println("Dispense Not possible!");
//        try{
//            pez.fill(10);
//            System.out.println("fill done!");
//        }catch (IllegalArgumentException ioe){
//            System.out.println(ioe);
//        }
//        if(!pez.isEmpty()) System.out.println("Pez isn't Empty!!");
//        if(pez.dispense())System.out.println("Dispense possible!");
//        String[] fintechTrainee=new String[]{"Sadik","Beg","Faiaz","Samim","Rumman"};
//        Arrays.sort(fintechTrainee, Comparator.comparing(String::length));
//        for(String s:fintechTrainee){
//            System.out.print(s+' ');
//        }

//        Object[] list={new Dog(),new DogFoods()};
//        for(Object obj:list){
//            if(obj instanceof Animals)
//                ((Animals) obj).sound();
//        }
        Dog dog1 = new Dog("bark");
        Dog dog2 = new Dog("woof");
       // System.out.println(dog.toString());
       // dog.findFood();
        System.out.println(dog1.equals(dog2));






    }
}