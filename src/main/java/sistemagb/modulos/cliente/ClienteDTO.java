package sistemagb.modulos.cliente;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sistemagb.modulos.enums.TipoPessoa;
import sistemagb.modulos.municipio.Municipio;
import sistemagb.modulos.uf.UF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private Long id;
	private String nome;
	private String endereco;
	private String rua;
	private String numero;
	private String bairro;
	private Long municipioId;
	private Integer ufId;
	private String cpf;
	private String cnpj;
	private Date dataNascimento;
	private TipoPessoa tipoPessoa;

}
