public class Dog extends Animals{
 Dog(String sound){
     super(sound);
 }

    @Override
    public void sound() {
        super.sound();
        System.out.println("**Wags tails**");
    }

    @Override
    void findFood() {
        System.out.println("*looks at humans");
        sound();
    }
}
