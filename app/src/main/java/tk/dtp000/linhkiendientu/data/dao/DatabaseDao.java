package tk.dtp000.linhkiendientu.data.dao;

public abstract class DatabaseDao {
    private static DatabaseDao instance;
    public static void init(DatabaseDao inst){
        instance = inst;
    }
    public static DatabaseDao getInstance(){
        return instance;
    }
    public abstract FavouriteDao getProductDao();
    public abstract OrderDetailDao getOrderDetailDao();

}
