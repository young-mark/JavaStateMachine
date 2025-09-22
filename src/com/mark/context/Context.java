package com.mark.context;

import java.util.Scanner;

public class Context {
    // fields, getters, setters
    private Scanner scanner;
    private Integer principal = null;
    private Float interestRate = null;
    private Byte paymentTerms = null;

    // constructor function
    public Context(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return this.scanner;
    }


    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Integer getPrincipal() {
        return this.principal;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Float getInterestRate() {
        return this.interestRate;
    }

    public void setPaymentTerms(Byte paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Byte getPaymentTerms() {
        return this.paymentTerms;
    }
}
