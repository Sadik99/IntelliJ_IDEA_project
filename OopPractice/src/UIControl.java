public abstract class UIControl {
    private boolean isEnabled = true;
    public void enable()
    {
        isEnabled=true;
    }
    public void disable(){
        isEnabled=false;
    }

//    public UIControl(boolean isEnabled) {
//        this.isEnabled=isEnabled;
//        System.out.println("UIControl");
//    }

    public abstract void render();
    public boolean isEnabled(){
        return isEnabled;
    }

}
