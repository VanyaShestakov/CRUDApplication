package Application.DB.Entity;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Enter the name")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Enter the surname")
    private String surname;

    @Column(name = "age")
    @Min(value = 0)
    @Max(value = 110)
    private int age;

    @Column(name = "city")
    @NotBlank(message = "Enter the city")
    private String city;

    @Column(name = "diagnosis")
    @NotBlank(message = "Enter the diagnosis")
    private String diagnosis;

    @Column(name = "sex")
    @NotBlank(message = "Choose the sex")
    private String sex;

    public Patient(String name, String surname, int age, String city, String diagnosis, String sex) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFull() {
        return
        this.name != null &&
        this.surname != null &&
        this.city != null &&
        this.diagnosis != null &&
        this.sex != null;
    }
}

