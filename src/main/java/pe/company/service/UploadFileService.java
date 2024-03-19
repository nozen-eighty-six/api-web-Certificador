package pe.company.service;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	
	private String folder="images//";
	
	public String saveImage(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(folder+file.getOriginalFilename());
			Files.write(path, bytes);
			return file.getOriginalFilename();
		}
		//En caso no guarda la imagen
		return "default.jpg";
		
	}
	
	//Eliminar la imagen cuando se elimina el producto
	public void deleteImage(String nombre ) {
		
		String ruta ="images//";
		
		File file = new File(ruta+nombre);
		file.delete();
		
	}

}
