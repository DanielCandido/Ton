package project.ton.enums;

public enum ProviderSituation 
{
	S('S'), N('N');
	
	
	//Atributo
	private char codigo;
	
	//Construtores
	private ProviderSituation(char pCodigo)
	{
		codigo = pCodigo;
	}
	
	//Metodo estaticos
	public static ProviderSituation fromChar(char pCodigo)
	{
		ProviderSituation[] tSituation = values();
		
		for (ProviderSituation tSituationProvider : tSituation)
		{
			if (pCodigo == tSituationProvider.codigo)
				return tSituationProvider;
		}
		
		return null;
	}
	
	   // Métodos normais
    public char getCodigo()
    {
        return codigo;
    }

}
