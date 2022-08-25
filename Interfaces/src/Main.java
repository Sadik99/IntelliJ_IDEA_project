public class Main {
    public static void main(String[] args) {
        ShopKeeper shopKeeper=new ShopKeeper("Sadik");
        TeaCup teaCup=new TeaCup();
        String shops="My_Shop";
        Object[] objects={shopKeeper,teaCup,shops};
        for(Object object:objects){
            if(object instanceof Chattable){
                String response=((Chattable)object).chat();
                System.out.println(response);
            }
        }

        Chattable[] chatTables={shopKeeper,teaCup};
        for(Chattable chattable:chatTables){
            String response= chattable.chat();
            System.out.println(response);
        }
    }
}