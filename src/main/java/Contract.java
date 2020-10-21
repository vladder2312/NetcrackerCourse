import java.util.Date;

public class Contract {
    private final long id;
    private Date startDate;
    private Date endDate;
    private Client client;

    public Contract(long id, Date startDate, Date endDate, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
