package SpringBoot.Hospital;

import java.util.ArrayList;

public class NurseController {
	ArrayList <Nurse> nurses;
	public NurseController() {
		nurses = new ArrayList<Nurse>();
		nurses.add(new Nurse("Juan", "juan@nurse.com", "123"));
		nurses.add(new Nurse("Jose", "jose@nurse.com", "123"));
		nurses.add(new Nurse("Carlos", "carlos@nurse.com", "123"));
		nurses.add(new Nurse("Javi", "javi@nurse.com", "123"));
	}
	public boolean login(String user, String password) {
		
		return false;
	}
}