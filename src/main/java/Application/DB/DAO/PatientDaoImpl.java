package Application.DB.DAO;

import Application.DB.Entity.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
class PatientDaoImpl implements PatientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Patient> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Patient", Patient.class).getResultList();
    }

    @Override
    public Patient getById(int id) {
        return sessionFactory.getCurrentSession().get(Patient.class, id);
    }

    @Override
    public void save(Patient patient) {
        sessionFactory.getCurrentSession().persist(patient);
    }

    @Override
    public void update(Patient patient) {
        sessionFactory.getCurrentSession().update(patient);
    }

    @Override
    public void delete(Patient patient) {
        sessionFactory.getCurrentSession().delete(patient);
    }


}
