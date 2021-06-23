package Application.DB.Service;

import Application.DB.DAO.PatientDAO;
import Application.DB.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public List<Patient> getAllPatients() {
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
        return getAllPatients().stream().collect(Collectors.toMap(Patient::getId, patient -> patient.getName() + " " + patient.getSurname()));
    }

    @Override
    @Transactional
    public void updatePatient(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    @Transactional
    public void deletePatient(Patient patient) {
        patientDAO.delete(patient);
    }


}
