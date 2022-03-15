
public class Interface {
    public static void main(String[]args) {
        animal[]canWalkArray=new animal[4];
        canWalkArray[0]=new bird("B1",0,0,0,0);
        canWalkArray[1]=new bird("B2",0,0,0,0);
        canWalkArray[2]=new dog("D1",0,0,0,0,"D3");
        canWalkArray[3]=new dog("D2",0,0,0,0,"D4");
for(int i=0;i<4;i++){
    System.out.println(canWalkArray[i].getName());
    // canWalkArray[i].walk(0,0);

    }
}
}