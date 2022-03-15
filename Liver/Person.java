import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Person {
	public enum BloodType{
		O,
		o,
		A,
		a,
		B,
		b,
		AB,
		ab
	}
	private double ID;
	private String name;
	private String dateOfBirth;
	private BloodType bloodType;
	private double longitude;
	private double latitude;
	
	Person(double ID, String name, String dateOfBirth, BloodType bloodType,
			double longitude, double latitude){
		this.ID = ID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.bloodType = bloodType;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public BloodType getBloodType() {
		return bloodType;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getAge() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		double currentYear = Integer.parseInt(currentDate.substring(0, 4));
		double currentMonth = Integer.parseInt(currentDate.substring(5, 7));
		double currentDay = Integer.parseInt(currentDate.substring(8, 10));
		double birthYear = Integer.parseInt(dateOfBirth.substring(0, 4));
		double birthMonth = Integer.parseInt(dateOfBirth.substring(5, 7));
		double birthDay = Integer.parseInt(dateOfBirth.substring(8, 10));
		return currentYear - birthYear + (currentMonth - birthMonth) / 12.0 + (currentDay - birthDay) / 365.0;
	}
	
}
