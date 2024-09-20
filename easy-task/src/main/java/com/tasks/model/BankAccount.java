package com.tasks.model;

public class BankAccount {
    private String iban;
    private String bic;
    private String accountHolder;

    public BankAccount(String iban, String bic, String accountHolder){
        // Вопрос #1: А это нужно как-то валидировать или так сойдет?

        this.iban = iban;
        this.bic = bic;
        this.accountHolder = accountHolder;
    }

    public String getIban(){
        return iban;
    }

    public void setIban(String iban){
        // Вопрос #2: Является ли это реализацией инкапсуляции? А не просто сеттер ради сеттера
        this.iban = iban;
    }

    public String getBic(){
        return bic;
    }

    public void setBic(){
        this.bic = bic;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
}
