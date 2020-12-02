package netcracker.validator;

import netcracker.Client;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Client validator
 */
public class ClientValidator {

    /**
     * Validates client. Changes info.
     * @param client validating client
     * @param info validation info
     */
    public static void validate(Client client, ValidationInfo info) {
        checkId(client.getId(), info);
        checkBirth(client.getBirth(), info);
        checkFio(client.getFio(), info);
        checkGender(client.getGender(), info);
        checkPassport(client.getPassport(), info);
    }

    /**
     * Validating client's ID
     * @param id client's id
     * @param info validation info
     */
    private static void checkId(long id, ValidationInfo info) {
        if (id == 0) {
            info.getMessageList().add("Client's ID value must not be 0");
            info.setStatus(ValidationStatus.ERROR);
        } else if (Math.abs(id) < 32768) {
            info.getMessageList().add("Client's ID value is short");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("Client's ID value passed validation");
        }
    }

    /**
     * Validating client's birth
     * @param birth client's birth
     * @param info validation info
     */
    private static void checkBirth(Calendar birth, ValidationInfo info) {
        if (birth.after(LocalDate.now())) {
            info.getMessageList().add("Client's birth after present time");
            info.setStatus(ValidationStatus.ERROR);
        } else if (birth.after(LocalDate.now().minusYears(14))) {
            info.getMessageList().add("Client's age under 14");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("Client's birth value passed validation");
        }
    }

    /**
     * Validating client's full name
     * @param fio client's full name
     * @param info validation info
     */
    private static void checkFio(String fio, ValidationInfo info) {
        String[] words = fio.split(" ");
        if (words.length == 1) {
            info.getMessageList().add("Client's full name contains one word");
            info.setStatus(ValidationStatus.ERROR);
        } else if (words.length == 2) {
            info.getMessageList().add("Client's full name without secondary name");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("Client's full name value passed validation");
        }
    }

    /**
     * Validating client's gender
     * @param gender client's gender
     * @param info validation info
     */
    private static void checkGender(String gender, ValidationInfo info) {
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")) {
            info.getMessageList().add("Client has a different gender");
            info.setStatus(ValidationStatus.WARNING);
        } else {
            info.getMessageList().add("Client's gender value passed validation");
        }
    }

    /**
     * Validating client's passport
     * @param passport client's passport number
     * @param info validation info
     */
    private static void checkPassport(String passport, ValidationInfo info) {
        for (int i = 0; i < passport.length(); i++) {
            if (Character.isAlphabetic(passport.charAt(i))) {
                info.getMessageList().add("Client's passport number has a letter(s)");
                info.setStatus(ValidationStatus.WARNING);
            }
        }
    }
}
