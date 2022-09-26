package tk.dtp000.linhkiendientu.data.dao;

import tk.dtp000.linhkiendientu.data.dao.model.Favourite;

import java.util.List;

public interface FavouriteDao {
    Favourite find(int id);
    List<Favourite> all();
    void insert(Favourite product);
    void update(Favourite product);
    void delete(int id);
}
