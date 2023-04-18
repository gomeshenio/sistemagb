package sistemagb.modulos.cliente;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistemagb.modulos.enums.TipoPessoa;
import sistemagb.modulos.municipio.Municipio;
import sistemagb.modulos.uf.UF;

@Table(name = "clientes")
@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nome", length = 255)
	private String nome;
	
	@Column(name = "endereco", length = 200)
	private String endereco;
	
	@Column(name = "rua", length = 200)
	private String rua;
	
	@Column(name = "numero", length = 200)
	private String numero;
	
	@Column(name = "bairro", length = 200)
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	@Column(name = "cpf", length = 200)
	private String cpf;
	
	@Column(name = "cnpj", length = 200)
	private String cnpj;
	
	@Column(name = "data_nascimento", length = 200)
	private Date dataNascimento;
	
	@Column(name = "tipo_pessoa", length = 200)
	private TipoPessoa tipoPessoa;
	
	
	
}

/*
Cliente:
Nome
Endereço (Rua, Numero, Bairro, Município e Estado) 
Ponto de referência 
Endereço 
CPF / CNPJ 
Data de nascimento 
Tipo: Pessoa Física ou Jurídica 
 */
