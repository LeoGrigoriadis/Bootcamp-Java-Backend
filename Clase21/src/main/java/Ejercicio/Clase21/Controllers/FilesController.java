package Ejercicio.Clase21.Controllers;

import Ejercicio.Clase21.Controllers.Service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                    .addFlashAttribute("message", message)
                    .addFlashAttribute("class", "success");
            return "redirect:/clients";
        } catch (Exception e) {
            message = "Error al cargar el archivo: " + file.getOriginalFilename() + "!";
            redirectAttrs
                    .addFlashAttribute("message", message)
                    .addFlashAttribute("class", "success");
            return "redirect:/clients";
        }
    }
}