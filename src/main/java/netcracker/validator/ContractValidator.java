package netcracker.validator;

import netcracker.contract.models.Contract;
import netcracker.contract.models.InternetContract;
import netcracker.contract.models.MobileContract;
import netcracker.contract.models.TeleContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Contract validator
 */
public class ContractValidator {

    /**
     * Validating list of contract
     * @param contracts list of contracts to be validated
     * @return list of contract validation information
     */
    public static List<ValidationInfo> validate(List<Contract> contracts) {
        List<ValidationInfo> info = new ArrayList<>();
        for (Contract contract : contracts) {
            info.add(validate(contract));
        }
        return info;
    }

    /**
     * Contract validating
     * @param contract contract for validation
     * @return validation information
     */
    public static ValidationInfo validate(Contract contract) {
        ValidationInfo info = new ValidationInfo(ValidationStatus.OK, new ArrayList<>(), contract.getId());
        checkId(contract, info);
        checkStartDate(contract, info);
        checkEndDate(contract, info);
        checkClient(contract, info);
        if (contract.getClass() == MobileContract.class) {
            checkMinutes((MobileContract) contract, info);
            checkMegaBytes((MobileContract) contract, info);
            checkSms((MobileContract) contract, info);
        } else if (contract.getClass() == InternetContract.class) {
            checkSpeed((InternetContract) contract, info);
        } else if (contract.getClass() == TeleContract.class) {
            checkChannelPackage((TeleContract) contract, info);
        }
        return info;
    }

    /**
     * Validation contract ID
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkId(Contract contract, ValidationInfo info) {
        if (contract.getId() == 0) {
            info.getMessageList().add("ID value must not be 0");
            info.setStatus(ValidationStatus.ERROR);
        } else if (Math.abs(contract.getId()) < 32768) {
            info.getMessageList().add("ID value is short");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("ID value passed validation");
        }
    }

    /**
     * Validation contract start date
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkStartDate(Contract contract, ValidationInfo info) {
        if (contract.getStartDate().after(contract.getEndDate())) {
            info.getMessageList().add("Start date after end date");
            info.setStatus(ValidationStatus.ERROR);
        } else if (contract.getStartDate().equals(contract.getEndDate())) {
            info.getMessageList().add("Start date equals end date");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("Start date value passed validation");
        }
    }

    /**
     * Validation contract end date
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkEndDate(Contract contract, ValidationInfo info) {
        if (contract.getEndDate().before(contract.getStartDate())) {
            info.getMessageList().add("End date before start date");
            info.setStatus(ValidationStatus.ERROR);
        } else if (contract.getEndDate().equals(contract.getStartDate())) {
            info.getMessageList().add("End date equals start date");
        } else {
            info.getMessageList().add("End date value passed validation");
        }
    }

    /**
     * Validation client of the contract
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkClient(Contract contract, ValidationInfo info) {
        ClientValidator.validate(contract.getClient(), info);
    }

    /**
     * Validation mobile contract minutes
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkMinutes(MobileContract contract, ValidationInfo info) {
        if (contract.getMinutes() < 0) {
            info.getMessageList().add("Minutes must not be negative");
            info.setStatus(ValidationStatus.ERROR);
        } else {
            info.getMessageList().add("Minutes value passed validation");
        }
    }

    /**
     * Validation mobile contract megabytes
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkMegaBytes(MobileContract contract, ValidationInfo info) {
        if (contract.getMegaBytes() < 0) {
            info.getMessageList().add("MegaBytes must not be negative");
            info.setStatus(ValidationStatus.ERROR);
        } else {
            info.getMessageList().add("MegaBytes value passed validation");
        }
    }

    /**
     * Validation mobile contract sms
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkSms(MobileContract contract, ValidationInfo info) {
        if (contract.getSms() < 0) {
            info.getMessageList().add("SMS must not be negative");
            info.setStatus(ValidationStatus.ERROR);
        } else {
            info.getMessageList().add("SMS value passed validation");
        }
    }

    /**
     * Validation speed of internet contract
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkSpeed(InternetContract contract, ValidationInfo info) {
        if (contract.getSpeed() <= 0) {
            info.getMessageList().add("Internet speed must be greater than 0mb/s");
            info.setStatus(ValidationStatus.ERROR);
        } else {
            info.getMessageList().add("Speed value passed validation");
        }
    }

    /**
     * Validation channel package of television contract
     * @param contract contract to validate
     * @param info validation info
     */
    private static void checkChannelPackage(TeleContract contract, ValidationInfo info) {
        info.getMessageList().add("ChannelPackage value passed validation");
    }
}
