import java.util.Calendar;
import java.util.Date;

public class TeleContract extends Contract {
    private ChanelKit chanelKit;

    public TeleContract(long id, Calendar startDate, Calendar endDate, Client client, ChanelKit chanelKit) {
        super(id, startDate, endDate, client);
        this.chanelKit = chanelKit;
    }

    public ChanelKit getChanelKit() {
        return chanelKit;
    }

    public void setChanelKit(ChanelKit chanelKit) {
        this.chanelKit = chanelKit;
    }

    @Override
    public String toString() {
        return "Контракт {" +
                "ID: " + getId() +
                ", Start date: " + getDateFormat().format(getStartDate().getTime()) +
                ", End date: " + getDateFormat().format(getEndDate().getTime()) +
                ", Client: " + getClient() +
                '}';
    }
}
