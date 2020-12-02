package netcracker.contract;

import com.opencsv.CSVReader;
import netcracker.Client;
import netcracker.contract.models.*;
import netcracker.validator.ContractValidator;
import netcracker.validator.ValidationInfo;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Parser of contracts from CSV file
 */
public class ContractParser {

    /**
     * Reads contracts from a CSV file
     *
     * @param reader file reader that has a full path
     * @return list of contracts
     */
    public List<Contract> readFile(Reader reader) throws Exception {
        List<Contract> contracts = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
            System.out.println(Arrays.toString(line));
            Contract contract = new Contract(
                    Integer.parseInt(line[0]),
                    new GregorianCalendar(Integer.parseInt(line[1].substring(0, 4)), Integer.parseInt(line[1].substring(5, 7)), Integer.parseInt(line[1].substring(8))),
                    new GregorianCalendar(Integer.parseInt(line[2].substring(0, 4)), Integer.parseInt(line[2].substring(5, 7)), Integer.parseInt(line[2].substring(8))),
                    new Client(Long.parseLong(line[3]),
                            new GregorianCalendar(Integer.parseInt(line[4].substring(0, 4)), Integer.parseInt(line[4].substring(5, 7)), Integer.parseInt(line[4].substring(8))),
                            line[5],
                            line[6],
                            line[7])
            );
            switch (line[8]) {
                case "internet" -> contracts.add(new InternetContract(
                        contract.getId(),
                        contract.getStartDate(),
                        contract.getEndDate(),
                        contract.getClient(),
                        Integer.parseInt(line[9])
                ));
                case "mobile" -> contracts.add(new MobileContract(
                        contract.getId(),
                        contract.getStartDate(),
                        contract.getEndDate(),
                        contract.getClient(),
                        Integer.parseInt(line[9]),
                        Integer.parseInt(line[10]),
                        Integer.parseInt(line[11])
                ));
                case "tv" -> {
                    ChannelPackage channelPackage;
                    switch (line[9]) {
                        case "minimum" -> channelPackage = ChannelPackage.MINIMUM;
                        case "default" -> channelPackage = ChannelPackage.DEFAULT;
                        case "kids" -> channelPackage = ChannelPackage.KIDS;
                        case "horror" -> channelPackage = ChannelPackage.HORROR;
                        case "music" -> channelPackage = ChannelPackage.MUSIC;
                        case "sport" -> channelPackage = ChannelPackage.SPORT;
                        case "maximum" -> channelPackage = ChannelPackage.MAXIMUM;
                        default -> channelPackage = null;
                    }
                    contracts.add(new TeleContract(
                            contract.getId(),
                            contract.getStartDate(),
                            contract.getEndDate(),
                            contract.getClient(),
                            channelPackage
                    ));
                }
            }
        }
        reader.close();
        csvReader.close();
        System.out.println("Validation result:");
        for (ValidationInfo info : ContractValidator.validate(contracts)) {
            System.out.println(info);
        }
        return contracts;
    }
}
