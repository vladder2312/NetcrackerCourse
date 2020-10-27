package netcracker;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Client entity
 */
public class Client {
    private final long id;
    private Calendar birth;
    private String fio;
    private String gender;
    private String passport;
    private int age;
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Client(long id, Calendar birth, String fio, String gender, String passport) {
        this.id = id;
        this.birth = birth;
        this.fio = fio;
        this.gender = gender;
        this.passport = passport;
        age = Years.yearsBetween(new LocalDate(birth.getTimeInMillis()), LocalDate.now()).getYears();
    }

    public long getId() {
        return id;
    }

    public Calendar getBirth() {
        return birth;
    }

    public void setBirth(Calendar birth) {
        this.birth = birth;
        age = Years.yearsBetween(new LocalDate(birth.getTimeInMillis()), LocalDate.now()).getYears();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "netcracker.Client{" +
                "ID: " + id +
                ", Birth date: " + dateFormat.format(birth.getTime()) +
                ", Full name: " + fio +
                ", Gender: " + gender +
                ", Passport: " + passport +
                ", Age: " + age +
                '}';
    }
}