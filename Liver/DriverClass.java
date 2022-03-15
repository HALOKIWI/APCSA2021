import java.util.*;


public class DriverClass {
	
	private static ArrayList<Integer> to;
	private static ArrayList<Integer> result;
	private static ArrayList<ArrayList<Integer>> canDonateTo;
	private static int maxPairs = 0;
	private static HashMap<String, Boolean> bloodMatch = new HashMap<String, Boolean>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of pairs:");
		int numPairs = sc.nextInt();
		ArrayList<Donor> donors = new ArrayList<Donor>();
		ArrayList<Recipient> recipients = new ArrayList<Recipient>();
		
		
		
		for(int i = 1; i <= numPairs; i++) {
			System.out.printf("Donor #%d\n", i);
			
			System.out.println("ID:");
			double ID = sc.nextDouble();
			System.out.println("Name:");
			String name = sc.next();
			System.out.println("Date of birth (yyyy/MM/dd):");
			String dateOfBirth = sc.next();
			System.out.println("Blood Type (A, a, B, b, AB, ab, O, o) (A = A+, a = A-, vice versa):");
			String typeStr = sc.next();
			Person.BloodType bloodType = Person.BloodType.valueOf(typeStr);
			System.out.println("Longitude:");
			double longitude = sc.nextDouble();
			System.out.println("Latitude:");
			double latitude = sc.nextDouble();
			
			System.out.printf("Recipient #%d\n", i);
			
			System.out.println("ID:");
			double rID = sc.nextDouble();
			System.out.println("Name:");
			String rname = sc.next();
			System.out.println("Date of birth(yyyy/MM/dd):");
			String rdateOfBirth = sc.next();
			System.out.println("Blood Type(A, B, AB, O):");
			String rtypeStr = sc.next();
			Person.BloodType rbloodType = Person.BloodType.valueOf(rtypeStr);
			System.out.println("Longitude:");
			double rlongitude = sc.nextDouble();
			System.out.println("Latitude:");
			double rlatitude = sc.nextDouble();
			System.out.println("Life expectancy");
			double lifeExpectancy = sc.nextDouble();
			
			Donor donor = new Donor(ID, name, dateOfBirth, bloodType, longitude, latitude,
					rID);
			Recipient recipient = new Recipient(rID, rname, rdateOfBirth, rbloodType, rlongitude, rlatitude,
					ID, lifeExpectancy);
			
			donors.add(donor);
			recipients.add(recipient);
		}
		
		
		for(int i = 0; i < numPairs; i++) {
			System.out.println();
			System.out.printf("donor #%d %-20s recipient #%d\n\n", i + 1, "", i + 1);
			System.out.printf("ID: %f %-16s ID: %f\n", donors.get(i).getID(), "", recipients.get(i).getID());
			System.out.printf("Name: %s %-21s Name: %s\n", donors.get(i).getName(), "", recipients.get(i).getName());
			System.out.printf("Date of birth: %s %-3s Date of birth: %s\n", donors.get(i).getDateOfBirth(), "", recipients.get(i).getDateOfBirth());
			System.out.printf("Blood type: %s %-15s Blood type: %s\n", donors.get(i).getBloodType().toString(), "", recipients.get(i).getBloodType().toString());
			System.out.printf("Longitude: %f %-9s Longitude: %f\n", donors.get(i).getLongitude(), "", recipients.get(i).getLongitude());
			System.out.printf("Latitude: %f %-10s Latitude: %f\n", donors.get(i).getLatitude(), "", recipients.get(i).getLatitude());
			System.out.printf("Donate to: %f %-9s Donate from: %f\n", donors.get(i).getDonateTo(), "", recipients.get(i).getDonateFrom());
			System.out.printf("Life expectancy: %f\n",recipients.get(i).getLifeExpectancy());
			System.out.printf("-----------------------------------------------------------------------------\n");
		}
		
		initMatchingChart();
		canDonateTo = new ArrayList<>(numPairs);
		for(int i = 0; i < numPairs; i++) {
			canDonateTo.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < numPairs; i++) {
			for(int j = 0; j < numPairs; j++) {
				Donor d = donors.get(i);
				Recipient r = recipients.get(j);
				if(bloodMatch.get(d.getBloodType().toString() + r.getBloodType().toString()) != null &&
						Math.abs(d.getAge() - r.getAge()) <= 5.0 &&
						distCoordinatesToKm(d.getLongitude(), d.getLatitude(), r.getLongitude(), r.getLatitude()) <= 1000.0) {
					//System.out.printf("%f can donate to %f\n", d.getID(), r.getID());
					canDonateTo.get(i).add(j);
				}
			}
		}
		
		to = new ArrayList<Integer>(numPairs);
		result = new ArrayList<Integer>(numPairs);
		for(int i = 0; i < numPairs; i++) {
			to.add(null);
			result.add(null);
		}
		pick(0, numPairs);
		
		if(maxPairs <= 0) {
			System.out.println("No one can donate or recieve.");
		}
		else {
			System.out.printf("Atmost %d pairs of donors and recipients can benefit from this exchange\n", maxPairs);
			for(int i = 0; i < numPairs; i++) {
				if(result.get(i) != null) {
					Donor d = donors.get(i);
					Recipient r = recipients.get(result.get(i));
					System.out.printf("Donor %s (ID: %f) can donate to Recipient %s (ID: %f)\n", d.getName(), d.getID(), r.getName(), r.getID());
				}
			}
		}
		
		sc.close();
	}
	
	private static void pick(int i, int n) {
		if(i == n) {
			int pairs = check(n, to);
			if(pairs > maxPairs) {
				maxPairs = pairs;
				result = new ArrayList<Integer>(to);
			}
			return;
		}
		for(int j = -1; j < canDonateTo.get(i).size(); j++) {
			if(j == -1) {
				pick(i + 1, n);
			}
			else {
				to.set(i, canDonateTo.get(i).get(j));
				pick(i + 1, n);
				to.set(i, null);
			}
		}
	}
	
	private static int check(int n, ArrayList<Integer> al) {
		Set<Integer> sDonors = new HashSet<Integer>();
		Set<Integer> sRecipients = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			if(al.get(i) != null) {
				sDonors.add(i);
				sRecipients.add(al.get(i));
			}
		}
		if(sDonors.equals(sRecipients)) {
			return sDonors.size();
		}
		return -1;
	}
	
	private static void initMatchingChart(){
		bloodMatch.put("oAB", true);
		bloodMatch.put("oab", true);
		bloodMatch.put("oA", true);
		bloodMatch.put("oa", true);
		bloodMatch.put("oB", true);
		bloodMatch.put("ob", true);
		bloodMatch.put("oO", true);
		bloodMatch.put("oo", true);
		
		bloodMatch.put("OAB", true);
		bloodMatch.put("OA", true);
		bloodMatch.put("OB", true);
		bloodMatch.put("OO", true);
		
		bloodMatch.put("bAB", true);
		bloodMatch.put("bab", true);
		bloodMatch.put("bB", true);
		bloodMatch.put("bb", true);
		
		bloodMatch.put("BAB", true);
		bloodMatch.put("BB", true);
		
		bloodMatch.put("aAB", true);
		bloodMatch.put("aab", true);
		bloodMatch.put("aA", true);
		bloodMatch.put("aa", true);
		
		bloodMatch.put("AAB", true);
		bloodMatch.put("AA", true);
		
		bloodMatch.put("abAB", true);
		bloodMatch.put("abab", true);
		
		bloodMatch.put("ABAB", true);
	}
	
	private static double distCoordinatesToKm(double lon1, double lat1, double lon2, double lat2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1.609344;
		return dist;
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
