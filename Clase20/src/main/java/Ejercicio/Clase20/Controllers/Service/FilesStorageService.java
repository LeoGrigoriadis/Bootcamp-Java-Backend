package Ejercicio.Clase20.Controllers.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    public void init();
    public void save(MultipartFile file);
    public void deleteAll();
}
