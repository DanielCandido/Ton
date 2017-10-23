package project.ton.dao.i;

import java.util.List;

import project.ton.model.User;

public interface UserDAO {
	   	
		public abstract User createUser(User user);

	    public abstract User recoveryUser(String email);

	    public abstract User updateUser(String email, String senha);

	    public abstract User update(User user);

	    public abstract boolean delete(String email, String senha);

	    public abstract boolean deleteUser(String pCpf);

	    public abstract List<User> search();

	    public abstract List<User> searchByNome(String pNome);

	    public abstract List<User> searchByCellPhone(String pCellPhone);



}
