package Application.Controller;

import Application.DB.DAO.PatientDAO;
import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public String showStartView() {
        return "start-view";
    }

    @GetMapping("/patients")
    public String showTable(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "patients-view";
    }

    @GetMapping("add-patient")
    public String showAddPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patinet-view";
    }

}
