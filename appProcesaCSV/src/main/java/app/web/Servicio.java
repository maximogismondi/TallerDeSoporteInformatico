package app.web;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Servicio {

    private String ubicacionArchivo;

    public Servicio(){
        this.ubicacionArchivo = ".//src//main//resources//files//";
    }

    public void guardarArchivo(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(ubicacionArchivo + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }

}
