package project.ton.dao.i;

import java.util.List;

import project.ton.model.Provider;

public interface ProviderDAO {

	public abstract Provider create(Provider provider);

    public abstract Provider recovery(int id);

    public abstract Provider update(String email, String senha);

    public abstract Provider update(Provider provider);

    public abstract boolean delete(String email, String senha);

    public abstract boolean delete(String pCpf);

    public abstract List<Provider> search();

    public abstract List<Provider> searchByNome(String pNome);

    public abstract List<Provider> searchByCellPhone(String pCellPhone);


}
