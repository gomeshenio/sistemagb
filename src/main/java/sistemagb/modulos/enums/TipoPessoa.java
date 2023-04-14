package sistemagb.modulos.enums;

public enum TipoPessoa {
	FISICA(0, "Pessoa Física"), 
	JURIDICA(1, "Pessoa Jurídica");
	
	private String descricao;
	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private TipoPessoa(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

//	public static TipoAnotacao recuperaEnum(Integer codigo) {
//		
//		TipoAnotacao[] tipos = TipoAnotacao.values();
//		for (int i = 0; i < tipos.length; i++) {
//			if (tipos[i].getCodigo().equals(codigo)) {
//				return tipos[i];
//			}
//		}
//		return null;
//	}

}
