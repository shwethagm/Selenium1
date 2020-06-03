package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {
    private final Object String="";
    public String path;
    public FileInputStream fis = null;
    ArrayList<String> list = new ArrayList<>();
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;
    String SheetName=null;



    public  Excel(String path) {
        this.path=path;
        FileInputStream fis;
        // String username=

        try {
            File file = new File(System.getProperty("user.dir") + "//src//test//java//data.xlsx");
            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("SheetName");
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getRowCount(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1)
            return 0;
        else{
            sheet = workbook.getSheetAt(index);
            int number=sheet.getLastRowNum()+1;
            return number;
        }

    }
        public String getCellData(String sheetName,String colName, int rowNum){
            try {
                if (rowNum <= 1) {
                    return "";
                }

                int index = workbook.getSheetIndex(sheetName);
                int col_Num = -1;
                if (index == -1)
                    return "";

                sheet = workbook.getSheetAt(index);
                row = sheet.getRow(0);
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    //System.out.println(row.getCell(i).getStringCellValue().trim());
                    if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                        col_Num = i;
                }
                if (col_Num == -1)
                    return "";
                sheet = workbook.getSheetAt(index);
                row = sheet.getRow(rowNum - 1);
                if (row == null)
                    return "";
                cell = row.getCell(col_Num);

                if (cell == null) {
                    return "";

                }
              else{
                    System.out.println(cell.getStringCellValue());
                    return cell.getStringCellValue();
                }
                          } catch (Exception e) {

                e.printStackTrace();
                return "row " + rowNum + " or column " + colName + " does not exist in xls";
            }
        }
    }