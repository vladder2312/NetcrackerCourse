import java.util.Date;

public class InternetContract extends Contract {
    private double speed; //МБит

    public InternetContract(long id, Date startDate, Date endDate, Client client, double speed) {
        super(id, startDate, endDate, client);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
