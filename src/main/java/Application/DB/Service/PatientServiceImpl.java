package Application.DB.Service;

import Application.DB.DAO.PatientDAO;
import Application.DB.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    @Transactional
    public Patient getPatientById(int id) {
        return patientDAO.getById(id);
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        patientDAO.save(patient);
    }


    @Override
    @Transactional
    public Map<Integer, String> getFullNames() {
        Map<Integer, String> fullNames = new HashMap<>();
        List<Patient> patients = getAll();
        for (Patient patient: patients) {
           fullNames.put(patient.getId(), patient.getName() + " " + patient.getSurname());
        }
        return fullNames;
    }

    @Override
    @Transactional
    public void saveChanges(Patient patient) {
        patientDAO.update(patient);
    }


}
