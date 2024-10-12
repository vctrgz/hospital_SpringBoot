package SpringBoot.Hospital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    
    private List<Nurse> nurses;
    
    public NurseController() {
        nurses = new ArrayList<>();
        nurses.add(new Nurse("Juan", "juan@nurse.com", "123"));
        nurses.add(new Nurse("Jose", "jose@nurse.com", "123"));
        nurses.add(new Nurse("Carlos", "carlos@nurse.com", "123"));
        nurses.add(new Nurse("Javi", "javi@nurse.com", "123"));
    }

    // Get all registered nurses
    @GetMapping("/nurses")
    public List<Nurse> getAllNurses() {
        return nurses;
    }
    
    // Login functionality
    @PostMapping("/login")	
	public @ResponseBody ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
		boolean loginCorrecto = false;
		for (Nurse nurse : nurses) {
			if (nurse.getUser().equals(loginRequest.getUser()) && nurse.getPassword().equals(loginRequest.getPassword())) {
				loginCorrecto = true;
				break;
			}
		}
		if (loginCorrecto) {
			return ResponseEntity.ok(loginCorrecto);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginCorrecto);
		}
	}
  
    // Find nurse by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Nurse> findByName(@PathVariable String name) {
        for (Nurse nurse : nurses) {
            if (name.equals(nurse.getName())) {
                return ResponseEntity.ok(nurse);
            }
        }
        return ResponseEntity.notFound().build();
    }
}

