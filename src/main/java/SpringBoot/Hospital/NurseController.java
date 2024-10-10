package SpringBoot.Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {
	ArrayList <Nurse> nurses;
	public NurseController() {
		nurses = new ArrayList<Nurse>();
		nurses.add(new Nurse("Juan", "juan@nurse.com", "123"));
		nurses.add(new Nurse("Jose", "jose@nurse.com", "123"));
		nurses.add(new Nurse("Carlos", "carlos@nurse.com", "123"));
		nurses.add(new Nurse("Javi", "javi@nurse.com", "123"));
	}
	
	@PostMapping("/login")	
	public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
		Map<String, Object> response = new HashMap<>();
		boolean loginCorrecto = false;
		for (Nurse nurse : nurses) {
			if (nurse.getUser().equals(loginRequest.getUser()) && nurse.getPassword().equals(loginRequest.getPassword())) {
				loginCorrecto = true;
				break;
			}
		}
		if (loginCorrecto) {
			response.put("status", "succes");
			response.put("message", "Login successful");
		}else {
			response.put("status", "error");
			response.put("message", "Invalid username or password");
		}
		return response;
	}
}