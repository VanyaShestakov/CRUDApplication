package Application.REST.Controller;

import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import Application.REST.Exceptions.IncorrectPatientException;
import Application.REST.Exceptions.NoSuchPatientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if (!patientService.contains(id)){
            throw new NoSuchPatientException
                    ("Patient with id=" + id + " not found");
        }
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/sex={sex}")
    public List<Patient> givePatientsBySex(@PathVariable String sex) {
        if (!sex.matches("^[F|M]$")) {
            throw new IncorrectPatientException
                    ("Sex entered incorrectly: '" + sex + "'. Enter 'F' or 'M' symbol");
        }
        return patientService.getPatientsBySex(sex);
    }

    @PostMapping("/patients")
    public void postPatient(@RequestBody Patient patient) {
        if (!(patient.isFull() && patient.getId() == 0)) {
            throw new IncorrectPatientException
                    ("For POST request all patient fields must be not null and id should not be specified");
        }
        patientService.savePatient(patient);
    }

    @PutMapping("/patients")
    public void putPatient(@RequestBody Patient patient) {
        if (!patientService.contains(patient.getId())){
            throw new NoSuchPatientException
                    ("Patient with id=" + patient.getId() + " not found");
        }
        if (!patient.isFull()) {
            throw new IncorrectPatientException
                    ("For PUT request all patient fields must be not null");
        }
        patientService.updatePatient(patient);
    }

    @DeleteMapping("/patients/id={id}")
    public void deletePatient(@PathVariable int id) {
        if (!patientService.contains(id)) {
            throw new NoSuchPatientException
                    ("Patient with id=" + id + " not found");
        }
        patientService.deletePatient(patientService.getPatientById(id));
    }
}
