package project.ton.dto;

import java.util.List;

import project.ton.model.Provider;

public class ProviderDTO extends AbstractDto<Provider>{

	/**
	 * @param pOK
	 * @param pMensagem
	 */
	/*atributos normais */
	private Provider provider;
	private List<Provider> list;

		/*Construtores de classe*/

	public ProviderDTO(boolean pOK, String pMensagem) {
		super(pOK, pMensagem);
	}

	public ProviderDTO(boolean pOK, String pMensagem, Provider pProvider) {
		super(pOK, pMensagem);
		provider = pProvider;
	}
	   public ProviderDTO(boolean pOk, String pMensagem, List<Provider> pList)
	    {
	        super(pOk, pMensagem);
	        list = pList;
	    }


	   /* metodos de acesso*/
	   public Provider getProvider()
	    {
	        return provider;
	    }

	    public void setProvider(Provider pProvider)
	    {
	        provider = pProvider;
	    }

	    public List<Provider> getList()
	    {
	        return list;
	    }

	    public void setList(List<Provider> pList)
	    {
	        list = pList;
	    }

}
