package com.tasks;

import com.tasks.model.Employee;
import com.tasks.service.ExcelParser;

import java.util.List;

public class BankApplication {
    public static void main(String[] args){
        System.out.println("bim bim bam bam --------- start app --------- bim bim bam bam");

        String filePath = "src/main/resources/java-test.xlsx";
        ExcelParser parser = new ExcelParser();
        List<Employee> employees = parser.parseExcel(filePath);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
