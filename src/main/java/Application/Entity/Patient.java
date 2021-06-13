package Application.Entity;


import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "sex")
    private Character sex;

    public Patient(String name, String surname, int age, String city, String diagnosis, char sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.diagnosis = diagnosis;
        this.sex = sex;
    }

    public Patient() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}

