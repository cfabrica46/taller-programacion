package doctors; 

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map; 
import java.util.HashMap; 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Doctors { 

	public static enum Specialty {Dermatologist, Neurologist, Psychiatrist, Pediatrician};

	public static class Doctor {
		private String DNI;
		private String password;
		private String name;
		private int age;
		private Specialty specialty;
		private String[] appointmentsID;

		public Doctor(String DNI, String password, String name, int age, Specialty specialty, String[] appointmentsID){
			this.DNI = DNI;
			this.password = password;
			this.name = name;
			this.age = age;
			this.specialty = specialty;
			this.appointmentsID = appointmentsID;
		}

		public String getDNI(){
			return DNI;
		}

		public void setDNI(){
			this.DNI = DNI;
		}

		public String getPassword(){
			return password;
		}

		public void setPassword(){
			this.password = password;
		}

		public String getName(){
			return name;
		}

		public void setName(){
			this.name = name;
		}

		public int getAge(){
			return age;
		}

		public void setAge(){
			this.age = age;
		}

		public Specialty getSpecialty(){
			return specialty;
		}

		public void setSpecialty(){
			this.specialty = specialty;
		}

		public String[] getAppointmentsID(){
			return appointmentsID;
		}

		public void setAppointmentsID(){
			this.appointmentsID = appointmentsID;
		}
	} 

	public static Map<String, Doctor> dataDoctors = new HashMap<>();

    //Method to read file
    public static void init() {
       
       	JSONArray doctorsJSON = new JSONArray();//JSON array that represents the doctors

    	//Iterate the map of the doctors and add them to the JSON array
    	for(Map.Entry<String, Doctor> entry : dataDoctors.entrySet()){
    		Doctor thisDoctor = entry.getValue();

    		JSONObject doctorJSON = new JSONObject();
    		doctorJSON.put("dni", thisDoctor.DNI); 
    		doctorJSON.put("password", thisDoctor.password);
    		doctorJSON.put("name", thisDoctor.name); 
    		doctorJSON.put("age", thisDoctor.age); 
    		doctorJSON.put("specialty", thisDoctor.specialty); 

    		JSONArray appointmentsJSON = new JSONArray(); 
		
    		//Iterate the AppointmentsIDs and add them to appointmentJSON
    		for(int i = 0; i < thisDoctor.getAppointmentsID().length; i++){
    			appointmentsJSON.add(thisDoctor.getAppointmentsID()[i]);
    		}
    		doctorJSON.put("appointmentsID", appointmentsJSON); 

    		doctorsJSON.add(doctorJSON);
    	}

    	//Write the JSON array to the doctors.json file
    	try (FileWriter file = new FileWriter("doctors.json")) {
			file.write(doctorsJSON.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
   }

   //Method to get all doctors
   public static Map<String, Doctor> getDoctors() {
   	return dataDoctors;
   }

   //Method to verify if the credentials passed are correct
   public static boolean checkCredentials(String dni, String password)  {
		for(Map.Entry<String, Doctor> entry : dataDoctors.entrySet()){
			Doctor thisDoctor = entry.getValue();

			if (dni == thisDoctor.DNI && password == thisDoctor.password) {
				return true;
			}
		}

   		return false;
	}

	//Method to get all the specialties
	public static ArrayList<Specialty> getSpecialties() { 
		ArrayList<Specialty> specialties = new ArrayList<Specialty>();
		specialties.add(Specialty.Dermatologist);
		specialties.add(Specialty.Neurologist);
		specialties.add(Specialty.Pediatrician);
		specialties.add(Specialty.Psychiatrist);

		return specialties; 
	}

	//Method to view all the specialties related to the doctors
	public static void viewSpecialties(ArrayList<Specialty> specialties) {
		for(int i = 0; i < specialties.size(); i++){
			System.out.println((i+1) + ". " + specialties.get(i)); 
		}
	}

	//Method to update the doctors data into the JSON file
	public static void updateData(Map<String, Doctor> docs) {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();

		for(Map.Entry<String, Doctor> entry : docs.entrySet()){
			doctors.add(entry.getValue());
		}

		JSONArray doctorsJSON = new JSONArray();//JSON array that represents the doctors

		//Iterate the ArrayList of the doctors and add them to the JSON array
		for(int i = 0; i < doctors.size(); i++){
			Doctor thisDoctor = doctors.get(i);

			JSONObject doctorJSON = new JSONObject();
			doctorJSON.put("dni", thisDoctor.DNI); 
			doctorJSON.put("password", thisDoctor.password);
			doctorJSON.put("name", thisDoctor.name); 
			doctorJSON.put("age", thisDoctor.age); 
			doctorJSON.put("specialty", thisDoctor.specialty); 

			JSONArray appointmentsJSON = new JSONArray();

			for(int j = 0; j < thisDoctor.appointmentsID.length; j++){
				appointmentsJSON.add(thisDoctor.appointmentsID[j]);
			}
			doctorJSON.put("appointmentsID", appointmentsJSON); 

			doctorsJSON.add(doctorJSON);
		}

		//Write the JSON array with the updated data to the doctors.json file
		try (FileWriter file = new FileWriter("doctors.json")) {
			file.write(doctorsJSON.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
