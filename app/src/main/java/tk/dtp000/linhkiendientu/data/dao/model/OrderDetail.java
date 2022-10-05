package tk.dtp000.linhkiendientu.data.dao.model;

public class OrderDetail {
    public int id;
    public String name;
    public String image;
    public String description;
    public int quantity;
    public double price;
    public int categoryId;

    public OrderDetail(int id, String name, String image, String description, int quantity, double price, int categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
    }
}
