package Application.DAO;

import Application.Entity.Patient;
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
    @Transactional
    public List<Patient> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Patient", Patient.class).getResultList();
    }

}
