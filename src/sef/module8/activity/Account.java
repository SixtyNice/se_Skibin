package sef.module8.activity;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name
 *
 * @author John Doe
 */
public class Account {


    /**
     * Creates an Account object with the specified name.  If the accout name
     * given violates the minimum requirements, then an AccountException is thrown
     *
     * @param accountName
     * @throws AccountException
     */

    private String accountName;

    public Account(String accountName) throws AccountException {
        Pattern pattern = Pattern.compile("[a-zA-Z]\\d");
        Matcher matcher = pattern.matcher(accountName);

        if (accountName.length() < 4) {
            throw new AccountException(AccountException.NAME_TOO_SHORT, accountName);
        } else if (!matcher.find()) {
            throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);
        } else {
            this.accountName = accountName;
        }

    }


    /**
     * Returns the account name
     *
     * @return the account name
     */
    public String getName() {
        return accountName;
    }
}
