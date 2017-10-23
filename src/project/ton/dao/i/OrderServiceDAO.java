package project.ton.dao.i;

import java.util.List;

import project.ton.model.OrderService;

public interface OrderServiceDAO {
	public abstract OrderService createOrderService(OrderService OrderService);

    public abstract OrderService recoveryOrderService(int id);

    public abstract OrderService update(OrderService order);

    public abstract boolean deleteOrderService(int id);

    public abstract List<OrderService> search ();

    public abstract List<OrderService> searchByNome(int id);

}
