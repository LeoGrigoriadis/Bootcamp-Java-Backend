package Ejercicio.Clase22.Reports;

import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentPdfReport {
    private List<Student> students;
    private List<Class> classes;

    public StudentPdfReport(ArrayList<Student> students){
        this.students=students;
    }
    public StudentPdfReport(List<Class> classes){
        this.classes=classes;
    }

    public void headerTable(PdfPTable table){
        PdfPCell cell=new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(20);
        if(students!=null){
            cell.setPhrase(new Phrase("Id"));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Dni"));
            table.addCell(cell);
            cell.setPhrase(new Phrase("FirstName"));
            table.addCell(cell);
            cell.setPhrase(new Phrase("LastName"));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Phone Number"));
            table.addCell(cell);
        }else{
            cell.setPhrase(new Phrase("Code"));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Name"));
            table.addCell(cell);
        }
    }
    public void BodyTable(PdfPTable table){
        if(students!=null) {
            for (Student student: students){
                table.addCell(String.valueOf(student.getId()));
                table.addCell(String.valueOf(student.getDni()));
                table.addCell(student.getFirstname());
                table.addCell(student.getLastname());
                table.addCell(student.getPhNumber());
            }
        }else{
            for (Class cl:classes){
                table.addCell(String.valueOf(cl.getCode()));
                table.addCell(cl.getName());
            }
        }
    }
    public void export(HttpServletResponse hsr) throws DocumentException, IOException{
        Document doc= new Document(PageSize.A4);
        PdfWriter.getInstance(doc,hsr.getOutputStream());
        doc.open();
        Paragraph par;
        if(students!=null){
            par=new Paragraph("Lista de Estudiantes");
        }
        else {
            par=new Paragraph("Lista de Clases");
        }
        par.setAlignment(par.ALIGN_CENTER);
        doc.add(par);
        PdfPTable pdf;
        if(students!=null){
            pdf=new PdfPTable(5);
        }
        else {
            pdf=new PdfPTable(2);
        }
        headerTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();
    }
}
