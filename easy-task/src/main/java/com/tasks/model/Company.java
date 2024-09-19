package com.tasks.model;

import com.tasks.enums.CompanyType;

public class Company extends Employee{
    private String name;
    private CompanyType type;

    public Company(long id, String email, String phone, String address, BankAccount bankAccount,
                   String name, CompanyType type) {
        super(id, email, phone, address, bankAccount);
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getType(){
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }
}
