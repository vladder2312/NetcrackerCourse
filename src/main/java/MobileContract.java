import java.util.Date;

public class MobileContract extends Contract{
    private int minutes;
    private int megaBytes;
    private int sms;

    public MobileContract(long id, Date startDate, Date endDate, Client client, int minutes, int megaBytes, int sms) {
        super(id, startDate, endDate, client);
        this.minutes = minutes;
        this.megaBytes = megaBytes;
        this.sms = sms;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMegaBytes() {
        return megaBytes;
    }

    public void setMegaBytes(int megaBytes) {
        this.megaBytes = megaBytes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }
}
