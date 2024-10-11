package SpringBoot.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
            response.put("status", "success");
            response.put("message", "Login successful");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid username or password");
        }
        return response;
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
