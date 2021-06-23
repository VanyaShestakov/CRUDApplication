package Application.Controller;

import Application.DB.Entity.Patient;
import Application.DB.Service.PatientService;
import Application.Model.FormValues;
import Application.Model.PatientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients-view";
    }

    @GetMapping("/add-patient")
    public String showAddPatientView(Model model, @RequestParam("operation") String operation) {
        model.addAttribute("operation", operation);
        model.addAttribute("patient", new Patient());
        model.addAttribute("values", new FormValues());
        return "patient-info-view";
    }

    @PostMapping("/saveorupdate-patient")
    public String savePatient(@ModelAttribute @Valid Patient patient, BindingResult result,
                              @ModelAttribute("values") FormValues values) {
        if (result.hasErrors()) {
            return "patient-info-view";
        }
        if (patient.getId() == 0) {
            patientService.savePatient(patient);
        } else {
            patientService.updatePatient(patient);
        }
        return "redirect:/patients";
    }

    @GetMapping("/choose-patient")
    public String showChoosePatientView(@RequestParam("operation") String operation, Model model){
        model.addAttribute("operation", operation);
        model.addAttribute("fullNames", patientService.getFullNames());
        model.addAttribute("patientId", new PatientId());
        return "choose-patient-view";
    }

    @PostMapping("/change-patient")
    public String showChangePatientView(@ModelAttribute("patientId") PatientId id, Model model,
                                        @RequestParam("operation") String operation ) {
        model.addAttribute("patient", patientService.getPatientById(id.getId()));
        model.addAttribute("values", new FormValues());
        model.addAttribute("operation", operation);
        return "patient-info-view";
    }

    @PostMapping("/delete-patient")
    public String deletePatient(@ModelAttribute("patientId") PatientId id){
        Patient patient = patientService.getPatientById(id.getId());
        patientService.deletePatient(patient);
        return "redirect:/patients";
    }

    @PostMapping("/save-patient-changes")
    public String savePatientChanges(@ModelAttribute @Valid Patient patient, BindingResult result,
                                     @ModelAttribute("values") FormValues values) {
        if (result.hasErrors()) {
            return "change-patient-view";
        }
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }



}
