package Application.DB.Service;

import Application.DB.Entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAll();
}
