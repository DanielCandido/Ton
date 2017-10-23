package project.ton.enums;

public enum OrderServiceSituation {
	PEDANT('P'), ATTENDED('A'), CANCELED('C');
	
	//Atributo
		private char codigo;
		
		//Construtores
		private OrderServiceSituation(char pCodigo)
		{
			codigo = pCodigo;
		}
		
		//Metodo estaticos
		public static OrderServiceSituation fromChar(char pCodigo)
		{
			OrderServiceSituation[] tSituation = values();
			
			for (OrderServiceSituation tSituationOrder : tSituation)
			{
				if (pCodigo == tSituationOrder.codigo)
					return tSituationOrder;
			}
			
			return null;
		}
		
		   // Métodos normais
	    public char getCodigo()
	    {
	        return codigo;
	    }
}
