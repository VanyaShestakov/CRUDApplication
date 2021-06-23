package Application.REST.Controller;

import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> giveAllPatients() {
        return patientService.getAllPatients();
    }
}
