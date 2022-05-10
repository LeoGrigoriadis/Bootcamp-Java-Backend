package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Controllers.Service.StudentService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Report;
import Ejercicio.Clase22.Models.Student;
import Ejercicio.Clase22.Reports.ExportExcel;
import Ejercicio.Clase22.Reports.StudentPdfReport;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    StudentService ss;
    @Autowired
    ClassService cs;

    @GetMapping
    public String getForm(Model model){
        Report rep=new Report();
        model.addAttribute("report", rep);
        return "ReportIndex";
    }

    @GetMapping("/send")
    public String send(@ModelAttribute("report") Report report, Model model){
        return "redirect:/reports/"+report.getType()+"/"+report.getList();
    }

    @GetMapping("/PDF/Students")
    public void getPdfStudents(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","students.pdf");
        ArrayList<Student> students= (ArrayList<Student>) ss.findAll();
        StudentPdfReport pdfclass=new StudentPdfReport(students);
        pdfclass.export(response);
    }
    @GetMapping("/PDF/Classes")
    public void getPdfClasses(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","classes.pdf");
        List<Class> classes=cs.getAllClasses();
        StudentPdfReport pdfclass=new StudentPdfReport(classes);
        pdfclass.export(response);
    }

    @GetMapping("/Excel/Students")
    public void getExcelStudents(HttpServletResponse response) throws DocumentException,IOException{
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=Students_List.xlsx");
        ArrayList<Student> students=ss.getAllStudents();
        ExportExcel excel=new ExportExcel(students);
        excel.CreateXcelFile(response);
    }

    @GetMapping("/Excel/Classes")
    public void getExcelClasses(HttpServletResponse response) throws DocumentException,IOException{
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=Classes_List.xlsx");
        List<Class> classes= cs.getAllClasses();
        ExportExcel excel=new ExportExcel(classes);
        excel.CreateXcelFile(response);
    }

    @GetMapping("/Excel/Alphabetical")
    public void getExcelStudentsInAlphabeticalOrder(HttpServletResponse response) throws DocumentException,IOException{
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=Students_List.xlsx");
        ArrayList<Student> students=ss.getAllStudentsOrder();
        ExportExcel excel=new ExportExcel(students);
        excel.CreateXcelFile(response);
    }
}
