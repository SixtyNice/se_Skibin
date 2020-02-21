package sef.module7.activity;

public class Main {
    public static void main(String[] args) {
        Denomination a = new DenominationImpl("USD", "U.S. Dollar", "$");
        System.out.println(a.getName());
        System.out.println(a.getDescription());
        System.out.println(a.getSymbol());

    }
}
