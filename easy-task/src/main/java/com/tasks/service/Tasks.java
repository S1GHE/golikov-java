package com.tasks.service;

import com.tasks.model.Company;
import com.tasks.model.Employee;
import com.tasks.model.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Tasks {
    public Map<String, Integer> count(List<Employee> employees) {
        int countIndividual = 0;
        int countCompany = 0;

        for (Employee employee : employees) {
            if (employee instanceof Individual) {
                countIndividual++;
            } else if (employee instanceof Company) {
                countCompany++;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("Individuals", countIndividual);
        result.put("Companies", countCompany);

        return result;
    }

    public List<String> getYoungEmployees(List<Employee> employees){
        List<String> youngEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee instanceof Individual) {
                Individual individual = (Individual) employee;
                if (individual.getAge() < 20) {
                    String fullName = String.format("%s %s", individual.getFirstName(), individual.getLastName());
                    youngEmployees.add(fullName);
                }
            }
        }

        return youngEmployees;
    }

    public void printEmployeesAsTable(List<Employee> employees) {
        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s%n", "ID", "Имя", "Фамилия", "Возраст", "Название компании", "Тип компании");
        System.out.println("--------------------------------------------------------------------------");

        for (Employee employee : employees) {
            if (employee instanceof Individual) {
                Individual individual = (Individual) employee;
                System.out.printf("%-5d | %-15s | %-15s | %-10d | %-15s | %-10s%n",
                        individual.getId(),
                        individual.getFirstName(),
                        individual.getLastName(),
                        individual.getAge(),
                        "-",
                        "-");
            } else if (employee instanceof Company) {
                Company company = (Company) employee;
                System.out.printf("%-5d | %-15s | %-15s | %-10s | %-15s | %-10s%n",
                        company.getId(),
                        "-",
                        "-",
                        "-",
                        company.getName(),
                        company.getType().toString());
            }
        }
    }
}
