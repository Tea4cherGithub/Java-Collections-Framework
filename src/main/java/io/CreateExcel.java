package io;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

public class CreateExcel {

    private static String FONT_NAME = "Courier New";

    private static final String[][] mainHeader = new String[][] {
            new String[] {
                    "name", "lastname"
            },
            new String[] {
                    "имя", "фамилия"
            }
    };

    public static void main(String[] args) {

        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("Отчет");
        Font headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName(FONT_NAME);

        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillBackgroundColor((short) 0xf8cbad);
        headerStyle.setFont(headerFont);

        Font primaryFont = wb.createFont();
        primaryFont.setFontHeightInPoints((short) 12);
        primaryFont.setFontName(FONT_NAME);
        primaryFont.setBold(false);

        CellStyle primaryStyle = wb.createCellStyle();
        primaryStyle.setFont(primaryFont);
        primaryStyle.setAlignment(HorizontalAlignment.CENTER);

        CellStyle styleCenter = wb.createCellStyle();
        styleCenter.setAlignment(HorizontalAlignment.CENTER);

        int rowNum = 0;
        Cell cell;
        for (String[] headerRow : mainHeader) {
            Row row = sheet.createRow(rowNum++);

            for (int i = 0; i < headerRow.length; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(headerStyle);
                cell.setCellValue(headerRow[i]);
            }
        }

        Row row = sheet.createRow(rowNum);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            for (Person dataRow : List.of(new Person("Nikita", "Nesterenko"), new Person("Dima", "Leshenko"))) {
                row = sheet.createRow(rowNum++);

                cell = row.createCell(0);
                cell.setCellStyle(styleCenter);
                cell.setCellValue(dataRow.getName());
                cell = row.createCell(1);
                cell.setCellStyle(styleCenter);
                cell.setCellValue(dataRow.getLastname());
                cell = row.createCell(2);
                cell.setCellStyle(styleCenter);
            }

            final int[] columnSize = new int[]{50, 50};

            IntStream.range(0, row.getPhysicalNumberOfCells() - 1).forEach(i -> sheet.setColumnWidth(i, columnSize[i] * 250));

            wb.write(out);

            byte[] rsl = out.toByteArray();
            Files.write(Path.of("C:\\Users\\Nikita\\Desktop\\qq\\result.xlsx"), rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
