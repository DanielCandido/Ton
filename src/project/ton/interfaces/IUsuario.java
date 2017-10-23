package project.ton.interfaces;

import java.util.List;

import project.ton.model.User;



public interface IUsuario
{
    public User createUser(User user);

    public User recoveryUser(String email);

    public User updateUser(String email, String senha);

    public User update(String email);

    public boolean delete(String email, String senha);

    public boolean deleteUser(String email);

    public List<User> search ();

    public List<User> searchByNome(String pNome);

    public List<User> searchByCellPhone(String pCellPhone);

}
