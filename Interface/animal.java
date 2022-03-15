
public abstract class animal {
    String name;
    int age = 1;
    double weight;
    int x, y, z;
public animal(String nameIn,Double weightIn,int xin,int yin,int zin){
name=nameIn;
weight=weightIn;
x=xin;
y=yin;
z=zin;

}
    public void eat() {
        weight++;

    }

    public void age() {
        age++;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getPos(char value) {
        if (value == 'x') {
            return x;
        } else if (value == 'y') {
            return y;
        } else if (value == 'z') {
            return z;
        }
        return 0;
    }
}
