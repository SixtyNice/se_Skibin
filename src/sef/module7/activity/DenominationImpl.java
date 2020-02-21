package sef.module7.activity;

import sef.module6.activity.Point2DImpl;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 *
 * @author John Doe
 */
public class DenominationImpl implements Denomination {

    private String name;
    private String description;
    private String symbol;

    /**
     * Creates a new instance with the specified parameters
     *
     * @param name        the name of the denomination
     * @param description a description
     * @param symbol
     */
    public DenominationImpl(String name, String description, String symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }

    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getDescription()
     */

    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getName()
     */

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getSymbol()
     */


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "Name: " + name + "," + " Description: " + description + "," + "Symbol: " + symbol;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenominationImpl denomination = (DenominationImpl) o;

        return this.name.equals(denomination.getName()) && this.symbol.equals(denomination.getSymbol()) && this.description.equals(denomination.getDescription());

    }


}
