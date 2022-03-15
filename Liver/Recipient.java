
public class Recipient extends Person{

	double donateFrom;
	double lifeExpectancy;

	Recipient(double ID, String Name, String DateOfBirth, BloodType bloodType,
			double Longitude, double Latitude, double donateFrom, double lifeExpectancy){
		super(ID, Name, DateOfBirth, bloodType, Longitude, Latitude);
		this.donateFrom = donateFrom;
		this.lifeExpectancy = lifeExpectancy;
	}
	
	public double getDonateFrom() {
		return donateFrom;
	}
	
	public double getLifeExpectancy() {
		return lifeExpectancy;
	}
}
