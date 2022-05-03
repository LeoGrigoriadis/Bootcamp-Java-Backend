package Ejercicio.Clase21.Controllers.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
    public void init();
    public void save(MultipartFile file);
    public void deleteAll();
}
