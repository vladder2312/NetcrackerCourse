import java.util.Date;

public class TeleContract extends Contract {
    private ChanelKit chanelKit;

    public TeleContract(long id, Date startDate, Date endDate, Client client, ChanelKit chanelKit) {
        super(id, startDate, endDate, client);
        this.chanelKit = chanelKit;
    }

    public ChanelKit getChanelKit() {
        return chanelKit;
    }

    public void setChanelKit(ChanelKit chanelKit) {
        this.chanelKit = chanelKit;
    }
}
