package Ejercicio.Clase20.Controllers;

import Ejercicio.Clase20.Controllers.Service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import Ejercicio.Clase20.Models.FileInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/uploads")
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @GetMapping()
    public String index() {
        return "upload";
    }

    @PostMapping("/store")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttrs) {
        String message = "";
        try {
            storageService.save(file);
            message = "Archivo añadido " + file.getOriginalFilename();
            redirectAttrs
                    .addFlashAttribute("mensaje", message)
                    .addFlashAttribute("clase", "success");
            return "redirect:/uploads";
        } catch (Exception e) {
            message = "Error al cargar el archivo: " + file.getOriginalFilename() + "!";
            redirectAttrs
                    .addFlashAttribute("mensaje", message)
                    .addFlashAttribute("clase", "success");
            return "redirect:/uploads";
        }
    }
}