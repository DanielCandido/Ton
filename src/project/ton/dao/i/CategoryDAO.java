package project.ton.dao.i;

import java.util.List;

import project.ton.model.Category;

public interface CategoryDAO {
	public abstract Category createCategory(Category category);

    public abstract Category recoveryCategory(int id);

    public abstract Category update(Category category);

    public abstract boolean deleteCategory(int id);

    public abstract List<Category> search();

}
