package project.ton.dao.i;

import java.util.List;

import project.ton.model.Provider;

public interface ProviderDAO {

	public abstract Provider create(Provider provider);
	
	public abstract Provider recoveryProvider(String email, String IdProvider);

    public abstract Provider update(String email, String senha);

    public abstract Provider update(Provider provider);

    public abstract boolean delete(String email, String senha);

    public abstract boolean delete(String pCpf);

    public abstract List<Provider> search();

    public abstract List<Provider> searchByName(String pNome);

}
