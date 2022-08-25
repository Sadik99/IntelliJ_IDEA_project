public class Box<T> {
    private T contents;

    void add(T thing){
        if(contents==null)contents=thing;
        else System.out.println("The box is full..!!");
    }

    T remove(){
        if(contents==null){
            System.out.println("The box is empty..!!");
            return null;
        }
        else{
            T thing=contents;
            contents=null;
            return thing;
        }
    }
}
