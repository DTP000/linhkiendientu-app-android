package tk.dtp000.linhkiendientu.data.remote.entity;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("price")
    public double price;

    @SerializedName("image")
    public String image;

    @SerializedName("category_id")
    public int categoryId;

}