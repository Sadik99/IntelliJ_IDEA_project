import java.util.Objects;

abstract class Animals {
     String sound;
    public void sound(){
        System.out.println(sound);
    }
    Animals(String sound){
        this.sound=sound;
    }
    abstract void findFood();

    @Override
    public String toString() {
        return getClass().getSimpleName()+ ": Sound = "+sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return Objects.equals(sound, animals.sound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sound);
    }
}
