import Player;
import Ting;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	Player all[]=new Player[3];
    all[0]=new Ting();
    all[1]=new Ting();
    all[2]=new Ting();
	int scores[]= new int[3];
	int pNum=3;
	for(int a = 0;a<pNum;a++){
		for(int b=0;b<pNum;b++){
			for(int rounds = 0; rounds<9;rounds++){
				char choiceA = all[a].getChoice();
				char choiceB = all[b].getChoice();
				all[a].result(choiceB);
				all[b].result(choiceA);
				if(choiceA == choiceB){
					System.out.println(all[a].getName()+" Tie with "+all[b].getName());
				}else if(choiceA =='r' && choiceB == 'p'){
					System.out.println(all[a].getName()+" lose against "+all[b].getName());
					scores[a]--;
					scores[b]++;
				}else if(choiceA =='r' && choiceB == 's'){
					System.out.println(all[a].getName()+" win against "+all[b].getName());
					scores[a]++;
					scores[b]--;
				}else if(choiceA =='p' && choiceB == 's'){
					System.out.println(all[a].getName()+" lose against "+all[b].getName());
					scores[a]--;
					scores[b]++;
				}else if(choiceA =='p' && choiceB == 'r'){
					System.out.println(all[a].getName()+" win against "+all[b].getName());
					scores[a]++;
					scores[b]--;
				}else if(choiceA =='s' && choiceB == 'r'){
					System.out.println(all[a].getName()+" lose against "+all[b].getName());
					scores[a]--;
					scores[b]++;
				}else if(choiceA =='s' && choiceB == 'p'){
					System.out.println(all[a].getName()+" win against "+all[b].getName());
					scores[a]++;
					scores[b]--;
				}
				
			}
		 
		}
		
	}
	System.out.println();
	for(int i=0;i<pNum;i++){
		System.out.println(all[i].getName()+"  "+scores[i]);
	}
}
}