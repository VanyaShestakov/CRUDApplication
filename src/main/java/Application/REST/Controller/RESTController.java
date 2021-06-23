package Application.REST.Controller;

import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import Application.REST.Exceptions.IncorrectSexValueException;
import Application.REST.Exceptions.NoSuchPatientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/patients/id={id}")
    public Patient givePatientById(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new NoSuchPatientException("Patient with id=" + id + " not found");
        }
        return patient;
    }

    @GetMapping("/patients/sex={sex}")
    public List<Patient> givePatientsBySex(@PathVariable String sex) {
        if (!sex.matches("^[F|M]$")) {
            throw new IncorrectSexValueException("Sex entered incorrectly: '" + sex + "'. Enter 'F' or 'M' symbol");
        }
        return patientService.getPatientsBySex(sex);
    }
}
