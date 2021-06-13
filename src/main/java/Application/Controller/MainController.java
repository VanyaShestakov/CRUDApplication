package Application.Controller;

import Application.DAO.PatientDAO;
import Application.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    PatientDAO patientDAO;

    @GetMapping("/patients")
    public String showTable(Model model) {
        model.addAttribute("patients", patientDAO.getAll());
        return "patients-view";
    }

}
