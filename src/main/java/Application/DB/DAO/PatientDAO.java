package Application.DB.DAO;

import Application.DB.Entity.Patient;

import java.util.List;

public interface PatientDAO {

    public List<Patient> getAll();
}
