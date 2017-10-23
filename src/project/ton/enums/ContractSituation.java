package project.ton.enums;

public enum ContractSituation {
	
	ACCEPT ('A'), DECLINE('R');
	
	
	//Atributo
	private char codigo;

	//Construtores
	private ContractSituation(char pCodigo){
		codigo = pCodigo;
	}
	
	public static ContractSituation fromChar(char pCodigo)
	{
		ContractSituation[] tSituation = values();
		
		for (ContractSituation tContractProvider : tSituation)
		{
			if (pCodigo == tContractProvider.codigo)
				return tContractProvider;
		}
		
		return null;
	}
	
	   // Métodos normais
    public char getCodigo()
    {
        return codigo;
    }

	
}
