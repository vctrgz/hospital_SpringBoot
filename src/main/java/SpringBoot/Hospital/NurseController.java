package SpringBoot.Hospital;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nurse")

public class NurseController {
	
	private List<Nurse> nurses;
	
	public NurseController() {
		nurses = new ArrayList<Nurse>();
		nurses.add(new Nurse("Juan", "juan@nurse.com", "123"));
		nurses.add(new Nurse("Jose", "jose@nurse.com", "123"));
		nurses.add(new Nurse("Carlos", "carlos@nurse.com", "123"));
		nurses.add(new Nurse("Javi", "javi@nurse.com", "123"));
	}
	
	@GetMapping("/nurses")
	public List<Nurse> getAllNurses(){
		return nurses;
	}
	
	public boolean login(String user, String password) {
		return false;
	}
	
	
}