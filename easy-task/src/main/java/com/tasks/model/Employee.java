package com.tasks.model;


public class Employee {
    private long id;
    private String email;
    private String phone;
    private String address;
    private BankAccount bankAccount;

    public Employee(long id, String email, String phone, String address, BankAccount bankAccount){
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    public long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public BankAccount getBankAccount(){
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
