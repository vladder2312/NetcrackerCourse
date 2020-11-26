package netcracker.contract.models;

import netcracker.Client;

import java.util.Calendar;

/**
 * Internet contract entity
 */
public class InternetContract extends Contract {

    /**
     * Internet speed under the netcracker.contract. Measured in megabits.
     */
    private int speed;

    public InternetContract(long id, Calendar startDate, Calendar endDate, Client client, int speed) {
        super(id, startDate, endDate, client);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "InternetContract{" +
                "ID: " + getId() +
                ", Start date: " + getDateFormat().format(getStartDate().getTime()) +
                ", End date: " + getDateFormat().format(getEndDate().getTime()) +
                ", Client: " + getClient() +
                ", Speed: " + speed +
                '}';
    }
}
