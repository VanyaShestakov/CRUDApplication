package Application.DB.DAO;

import Application.DB.Entity.Patient;

import java.util.List;

public interface PatientDAO {

    public List<Patient> getAll();

    public Patient getById(int id);

    public void save(Patient patient);

    public void update(Patient patient);

}
