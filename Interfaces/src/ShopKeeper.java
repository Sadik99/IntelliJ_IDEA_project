public class ShopKeeper extends Person implements Seller{
    ShopKeeper(String name) {
        super(name);
    }

    @Override
    public String chat() {
        return "Hi, I am a Shop Keeper..!!";
    }
    void sellGoods(){

    }
}
