import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Contract entity
 */
public class Contract {
    private final long id;
    private Calendar startDate;
    private Calendar endDate;
    private Client client;
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Contract(long id, Calendar startDate, Calendar endDate, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ID: " + id +
                ", Start date: " + dateFormat.format(startDate.getTime()) +
                ", End date: " + dateFormat.format(endDate.getTime()) +
                ", Client: " + client +
                '}';
    }
}
