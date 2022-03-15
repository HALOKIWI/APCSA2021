
public class dog extends animal  implements canWalk{
    private String breed;
    public dog(String n, double w, int x, int y, int z, String b){
        super(n, w, x, y, z);
        breed = b;
    }
    public String getBreed(){
        return breed;
    }
    public void bark(){
        System.out.println("bark");
    }
    public void walk(int x, int y){

    }
    public void run(int x, int y, int speed){

    }
}