
public class Donor extends Person{
	
	private double donateTo;
	
	Donor(double ID, String Name, String DateOfBirth, BloodType bloodType,
			double Longitude, double Latitude, double donateTo){
		super(ID, Name, DateOfBirth, bloodType, Longitude, Latitude);
		this.donateTo = donateTo;
	}
	
	public double getDonateTo() {
		return donateTo;
	}
	
}
