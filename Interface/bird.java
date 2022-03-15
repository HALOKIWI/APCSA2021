
public class bird extends animal implements canFly, canWalk{
    public bird(String n, double w, int x, int y, int z){
        super(n, w, x, y, z);
    }
    public void chirp(){
        System.out.println("chirp");
    }
    public void fly(int x, int y){

    }
    public void lift(int z){

    }
    public void walk(int x, int y){

    }
    public void run(int x, int y, int speed){

    }
}