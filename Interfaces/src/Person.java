public class Person implements Chattable{
    String name;
    Person(String name){
        this.name=name;
    }
    @Override
    public String chat(){
        return "Hi, I am Person..!!";
    }
}
