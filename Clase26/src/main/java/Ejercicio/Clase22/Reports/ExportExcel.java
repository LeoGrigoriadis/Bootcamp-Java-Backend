package Ejercicio.Clase22.Reports;

import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportExcel {
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;
    private ArrayList<Student> students;
    private List<Class> classes;
    public ExportExcel(ArrayList<Student> st){
        this.students=st;
        workbook=new XSSFWorkbook();
    }

    public ExportExcel(List<Class> cl) {
        this.classes=cl;
        workbook=new XSSFWorkbook();
    }


    private void readHeader(){
        if(classes!=null) {sheet = workbook.createSheet("Classes_List");}
        else {sheet = workbook.createSheet("Students_List");}

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(20);
        font.setBold(true);
        style.setFont(font);
        if(classes!=null){
            createCell(row, 0, "code", style);
            createCell(row, 1, "name", style);
        }else {
            createCell(row, 0, "Id", style);
            createCell(row, 1, "Dni", style);
            createCell(row, 2, "FirstName", style);
            createCell(row, 3, "LastName", style);
            createCell(row, 4, "Phone Number", style);
        }
    }

    private void createCell(Row row, int i, Object name, CellStyle style) {
        sheet.autoSizeColumn(i);
        Cell cell = row.createCell(i);

        if(name instanceof Integer) cell.setCellValue((Integer) name);
        else if(name instanceof Boolean) cell.setCellValue((Boolean) name);
        else if(name instanceof Long) cell.setCellValue((Long) name);
        else cell.setCellValue((String) name);
        cell.setCellStyle(style);
    }
    private void readBody(){
        int rowCounter=1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(20);
        style.setFont(font);

        if(classes!=null) {
            for (Class cl : classes){
                Row row = sheet.createRow(rowCounter);
                int counterColumn = 0;
                createCell(row, counterColumn++, counterColumn, style);
                createCell(row, counterColumn++, cl.getName(), style);

                rowCounter++;
            }
        }else{
            for (Student st : students) {
                Row row = sheet.createRow(rowCounter);
                int counterColumn = 0;
                createCell(row, counterColumn++, st.getId(), style);
                createCell(row, counterColumn++, st.getDni(), style);
                createCell(row, counterColumn++, st.getFirstname(), style);
                createCell(row, counterColumn++, st.getLastname(), style);
                createCell(row, counterColumn++, st.getPhNumber(), style);
                rowCounter++;
            }
        }
    }
    public void CreateXcelFile(HttpServletResponse response) throws IOException{
        readHeader();
        readBody();
        ServletOutputStream stream = response.getOutputStream();
        workbook.write(stream);
        workbook.close();
        stream.close();
    }
}
