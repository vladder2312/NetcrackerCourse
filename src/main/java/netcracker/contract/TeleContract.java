package netcracker.contract;

import netcracker.Client;

import java.util.Calendar;

/**
 * Television contract entity
 */
public class TeleContract extends Contract {
    private ChannelPackage channelPackage;

    public TeleContract(long id, Calendar startDate, Calendar endDate, Client client, ChannelPackage channelPackage) {
        super(id, startDate, endDate, client);
        this.channelPackage = channelPackage;
    }

    public ChannelPackage getChanelKit() {
        return channelPackage;
    }

    public void setChanelKit(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

    @Override
    public String toString() {
        return "TeleContract{" +
                "ID: " + getId() +
                ", Start date: " + getDateFormat().format(getStartDate().getTime()) +
                ", End date: " + getDateFormat().format(getEndDate().getTime()) +
                ", Client: " + getClient() +
                '}';
    }
}
