package sistemagb.modulos.uploaddownload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	public static String saveFile(String fileName, MultipartFile multiPartFile) throws IOException {
		Path uploadDirectory = Paths.get("Files-Upload");
		
		String fileCode = RandomStringUtils.randomAlphanumeric(8);
		
		try (InputStream inputStream = multiPartFile.getInputStream()) {
			Path filePath = uploadDirectory.resolve(fileCode + "-" + fileName);
			Files.copy(inputStream,  filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erro ao salvar arquivo: " + fileName, ioe);
		}
		
		return fileCode;
	}
}
