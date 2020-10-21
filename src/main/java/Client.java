import java.util.Date;

public class Client {
    private final long id;
    private Date birth;
    private String fio;
    private String gender;
    private String passport;

    public Client(long id, Date birth, String fio, String gender, String passport) {
        this.id = id;
        this.birth = birth;
        this.fio = fio;
        this.gender = gender;
        this.passport = passport;
    }

    public long getId() {
        return id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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
}