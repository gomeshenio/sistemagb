package sistemagb.modulos.uploaddownload;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("uploadFile")
public class FileUploadController {
	
	@PostMapping
	public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile multiPartFile) throws IOException {
		
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		Long size = multiPartFile.getSize();
		
		String fileCode = FileUploadUtil.saveFile(fileName, multiPartFile);
		
		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("C:\\catalogo/" + fileCode);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}











