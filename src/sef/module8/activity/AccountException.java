package sef.module8.activity;

import javafx.animation.ScaleTransition;

/**
 * This class represents the exception that can be thrown if the
 * name given to an Account instance violates naming rules
 *
 * @author John Doe
 */
@SuppressWarnings("serial")
public class AccountException extends Exception {


    public static final String NAME_TOO_SHORT = "Name must be longer than 4 characters";
    public static final String NAME_TOO_SIMPLE = "Name must contain a combination of letters and numbers";

    private String name;


    /**
     * Constructs an AccountException
     *
     * @param message The message to be set explaining the name violation (see static attributes)
     * @param name    The actual name
     */


    public AccountException(String message, String name) {

        super(message);

        this.name = name;
    }



/*
 boolean haveNumber = false;
        boolean haveLetters = false;

        String[] nameArray = name.split("");
        for (int i = 0; i < nameArray.length; i++) {
            if (isDigit(nameArray[i])) {
                haveNumber = true;
            }
            if (!(name.charAt(i) < '0' || name.charAt(i) > '9')) {
                haveLetters = true;
            }
        }


        if (name.length() <= 4) {
            throw new IllegalArgumentException(NAME_TOO_SHORT);
        } else if (!(haveNumber && haveLetters)) {
            throw new IllegalArgumentException(NAME_TOO_SIMPLE);
        } else {

            this.message = message;
        }
*\


 */




    /**
     * Returns the name passed to this Account exception
     *
     * @return
     */
    public String getName() {

        return name;

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
