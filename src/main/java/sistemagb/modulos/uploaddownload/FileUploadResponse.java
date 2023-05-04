package sistemagb.modulos.uploaddownload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResponse {
	
	private String fileName;
	private String downloadUri;
	private Long size;

}
