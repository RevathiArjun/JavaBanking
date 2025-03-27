package com.task.bank.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.task.bank.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class ExcelUpload {

    public static boolean hasExcelFormat(MultipartFile file) {
        return Objects.requireNonNull(file.getContentType()).equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Student> parseExcel(InputStream is) {
        List<Student> students = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            boolean firstRow = true; 
         
                Row currentRow = rows.next();
                if (firstRow) {
                    firstRow = false;
                   // continue;
                }

                Student student = new Student();
                student.setRollNo(currentRow.getCell(0).getStringCellValue().trim());
                student.setName(currentRow.getCell(1).getStringCellValue().trim());

                students.add(student);
            }
        
       catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
        return students;
    }
}