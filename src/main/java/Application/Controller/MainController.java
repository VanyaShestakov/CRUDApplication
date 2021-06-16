package Application.Controller;

import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import Application.FormValues.FormValues;
import Application.Model.PatientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/add-patient")
    public String showAddPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("values", new FormValues());
        return "add-patient-view";
    }

    @PostMapping("/save-patient")
    public String savePatient(@ModelAttribute @Valid Patient patient, BindingResult result,
                              @ModelAttribute("values") FormValues values) {
        if (result.hasErrors()) {
            return "add-patient-view";
        }
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/choose-patient")
    public String showUpdatePatientView(Model model){
        model.addAttribute("fullNames", patientService.getFullNames());
        model.addAttribute("patientId", new PatientId());
        return "choose-patient-view";
    }

    @PostMapping("/change-patient")
    public String showChangePatientView(@ModelAttribute("choice") PatientId id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id.getId()));
        model.addAttribute("values", new FormValues());
        return "change-patient-view";
    }

    @PostMapping("/save-patient-changes")
    public String savePatientChanges(@ModelAttribute @Valid Patient patient, BindingResult result,
                              @ModelAttribute("values") FormValues values) {
        if (result.hasErrors()) {
            return "change-patient-view";
        }
        patientService.saveChanges(patient);
        return "redirect:/patients";
    }



}
