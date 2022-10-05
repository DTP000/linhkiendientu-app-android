package tk.dtp000.linhkiendientu.data.dao;

import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    OrderDetail find(int id);
    List<OrderDetail> all();
    void insert(OrderDetail product);
    void update(OrderDetail product);
    void delete(int id);
}
