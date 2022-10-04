package tk.dtp000.linhkiendientu.data.dao.model;

public class Favourite {
    public int id;
    public String name;
    public int quantity;
    public double price;
    public String image;
    public int categoryId;

    public Favourite(int id, String name, int quantity, double price, String image, int categoryId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
    }
}
