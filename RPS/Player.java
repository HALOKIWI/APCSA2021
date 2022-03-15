public interface Player{
	//returns the name of the student
	public String getName();
	//returns r (rock) p (paper) or s (scissors)
	public char getChoice();
	//receives the result if needed
	public void result(char r);
}