package Application.DB.Service;

import Application.DB.DAO.PatientDAO;
import Application.DB.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }
}
