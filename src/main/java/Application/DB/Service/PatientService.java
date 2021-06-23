package Application.DB.Service;

import Application.DB.Entity.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    public List<Patient> getAllPatients();

    public Patient getPatientById(int id);

    public Map<Integer, String> getFullNames();

    public void savePatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatient(Patient patient);
}
