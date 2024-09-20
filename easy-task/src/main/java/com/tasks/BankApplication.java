package com.tasks;

import com.tasks.model.Employee;
import com.tasks.service.ExcelParser;
import com.tasks.service.Tasks;

import java.util.List;

public class BankApplication {

    public static void main(String[] args){
        System.out.println("bim bim bam bam --------- start app --------- bim bim bam bam\n");

        String filePath = "src/main/resources/java-test.xlsx";

        ExcelParser parser = new ExcelParser();
        Tasks tasks = new Tasks();

        List<Employee> employees = parser.parseExcel(filePath);

        System.out.println("bim bim bam bam --------- tasks #1 --------- bim bim bam bam");
        System.out.println(String.format("Количество физических лиц: %d", tasks.count(employees).get("Individuals")));

        System.out.println("bim bim bam bam --------- tasks #2 --------- bim bim bam bam");
        for (String fullName : tasks.getYoungEmployees(employees)){
            System.out.println(fullName);
        }

        System.out.println("bim bim bam bam --------- tasks #3 --------- bim bim bam bam");
        System.out.println(String.format("Количество юридических лиц: %d", tasks.count(employees).get("Companies")));

        System.out.println("bim bim bam bam --------- Таблица --------- bim bim bam bam");
        tasks.printEmployeesAsTable(employees);
    }
}
