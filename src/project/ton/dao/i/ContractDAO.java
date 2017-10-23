package project.ton.dao.i;

import java.util.List;

import project.ton.model.Contract;

public interface ContractDAO {
	
	public abstract Contract createContract(Contract contract);

    public abstract Contract recoveryContract(int id);

    public abstract Contract update(Contract contract);

    public abstract boolean delete(int id);

    public abstract List<Contract> search();

}
