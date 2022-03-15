
public class fish extends animal implements canSwim{
    private int air = 100;
    public fish(String n, double w, int x, int y, int z){
        super(n, w, x, y, z);
    }
    public void breathe(){
        if (super.getZ()>-5 && air<100){
            air+=5;
        }
    }
    public void swim(int x, int y){

    }
    public void dive(int z){

    }
}