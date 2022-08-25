public class PezDispenser {
    public static final int MAX_PEZ=12;
    private int pezCount;
    final private String characterName;
    public PezDispenser(String characterName){
        this.characterName=characterName;
        pezCount=0;
    }
    public void fill(){
        pezCount=MAX_PEZ;
    }
    public void fill(int pezCount){
        this.pezCount+=pezCount;
        if(pezCount>MAX_PEZ)throw new IllegalArgumentException("Too many PEZ!!!");

    }
    public boolean isEmpty(){
        return pezCount==0;
    }
    public String getPezDispenser(){
        return characterName;
    }
    public boolean dispense(){
        if(!isEmpty()){
            pezCount--;
            return true;
        }
        return false;
    }

}
