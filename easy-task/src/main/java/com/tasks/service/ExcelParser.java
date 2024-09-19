package com.tasks.service;

import com.tasks.model.*;
import com.tasks.enums.CompanyType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {
    public List<Employee> parseExcel(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                    continue;
                }


                if (row == null || row.getCell(0) == null || row.getCell(0).getCellType() == CellType.BLANK) {
                    continue;
                }

                long id;
                String idCellValue = getCellValue(row.getCell(0));

                try {
                    id = (long) Double.parseDouble(idCellValue.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: значение ID не является числом. Значение: '" + idCellValue + "'");
                    continue;
                }

                String email = getCellValue(row.getCell(1));
                String phone = getCellValue(row.getCell(2));
                String address = getCellValue(row.getCell(3));

                String iban = getCellValue(row.getCell(13));
                String bic = getCellValue(row.getCell(14));
                String accountHolder = getCellValue(row.getCell(15));
                BankAccount bankAccount = new BankAccount(iban, bic, accountHolder);

                Employee employee = null;

                boolean isIndividual = !getCellValue(row.getCell(7)).isEmpty() || !getCellValue(row.getCell(8)).isEmpty();
                boolean isCompany = !getCellValue(row.getCell(10)).isEmpty() && getCellValue(row.getCell(11)).matches("SARL|SARS");

                if (isIndividual) {
                    String firstName = getCellValue(row.getCell(5));
                    String lastName = getCellValue(row.getCell(6));
                    boolean hasChildren = Boolean.parseBoolean(getCellValue(row.getCell(7)));

                    int age;
                    try {
                        age = (int) Double.parseDouble(getCellValue(row.getCell(8)).trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: значение возраста не является числом. Значение: '" + getCellValue(row.getCell(8)) + "'");
                        continue;
                    }

                    employee = new Individual(id, email, phone, address, bankAccount, firstName, lastName, hasChildren, age);
                } else if (isCompany) {
                    String name = getCellValue(row.getCell(10));
                    CompanyType companyType;
                    try {
                        companyType = CompanyType.valueOf(getCellValue(row.getCell(11)).toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: неверный тип компании. Значение: '" + getCellValue(row.getCell(11)) + "'");
                        continue;
                    }

                    employee = new Company(id, email, phone, address, bankAccount, name, companyType);
                } else {
                    System.out.println("Ошибка: не удалось определить тип объекта.");
                    continue;
                }

                employees.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
