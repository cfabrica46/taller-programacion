package appointments;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
 
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class Appointment {
	
	public String DoctorDNI;
	String id ;
	String StartTime;
	String EndTime;
	int Duration;
	boolean Free;
	String patienDNI;
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	 public static void AddAppointment() throws JsonGenerationException, JsonMappingException, IOException {
	        Appointment appoint = new Appointment();
	        appoint.DoctorDNI = "123";
	        appoint.endTime = "10:00";
	        appoint.duration = 30;
	        appoint.free = true;

	        mapper.writeValue(new File("output.json"), appoint);
	    }

	public static Map<String, Appointment> getAppointments() throws IOException, ParseException {
		Object obj = JSONValue.parse(new File("appointments.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		Appointment appointment = new Appointment();
		appointment.DoctorDNI = (String) jsonObject.get("DoctorDNI");
		appointment.id = (String) jsonObject.get("id");
		appointment.StartTime = (String) jsonObject.get("StartTime");
		appointment.endTime = (String) jsonObject.get("endTime");
		appointment.duration = (int) jsonObject.get("duration");
		appointment.free = (boolean) jsonObject.get("free");
		appointment.patienDNI = (String) jsonObject.get("patienDNI");
		
		Map<String, Appointment> appoints = new HashMap<String, Appointment>();
		
		for ( String key : jsonObject.keySet() ) {
			appoints.put("key", appointment);
		}
		
		return appoints;
	}
	
	public static int GetNumberFreeAppointmentsByDoctorDNI(String dni) throws IOException, ParseException {
		Map<String, Appointment> appointments = getAppointments();
		
		int numberAppointments = 0;
		
		for (Map.Entry<String, Appointment> appointment : appointments.entrySet()) {
			if(appointment.getValue().doctorDNI.equals(dni) && appointment.getValue().Free) {
				numberAppointments++;
			}
		}
		
		return numberAppointments;
	}
	
	public static void UpdateData(Map<String, Appointment> appoints) throws JsonGenerationException, JsonMappingException, IOException {
		Appointment[] appointments = appoints.values().toArray(new Appointment[appoints.size()]);
		
		  mapper.writeValue(new File("output.json"), appointments);
	}
	
}
