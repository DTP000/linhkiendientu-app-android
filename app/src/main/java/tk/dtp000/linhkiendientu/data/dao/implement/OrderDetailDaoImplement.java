package tk.dtp000.linhkiendientu.data.dao.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import tk.dtp000.linhkiendientu.data.dao.DatabaseHelper;
import tk.dtp000.linhkiendientu.data.dao.OrderDetailDao;
import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImplement extends DatabaseHelper implements OrderDetailDao {
    public OrderDetailDaoImplement(Context context) {
        super(context);
    }

    @Override
    public OrderDetail find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("order_details", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
//        int id, String name, String image, String description, int quantity, double price, int categoryId
            OrderDetail product = new OrderDetail(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getDouble(6), cursor.getInt(7));
            return product;
        } else {
            return null;
        }
    }

    @Override
    public List<OrderDetail> all() {
        List<OrderDetail>  productList = new ArrayList<>();
        String query = "SELECT * FROM order_details";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            OrderDetail product = new OrderDetail(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getDouble(6), cursor.getInt(7));
            productList.add(product);
            cursor.moveToNext();
        }
        return productList;
    }

    @Override
    public void insert(OrderDetail product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("product_id", product.id);
        values.put("name", product.name);
        values.put("price", product.price);
        values.put("quantity", product.quantity);
        values.put("image", product.image);
        values.put("description", product.description);
        values.put("categoryId", product.categoryId);


        db.insert("order_details", null, values);
        db.close();
    }

    @Override
    public void update(OrderDetail product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.name);
        values.put("price", product.price);
        values.put("quantity", product.quantity);
        values.put("image", product.image);
        values.put("description", product.description);
        values.put("categoryId", product.categoryId);

        db.update("order_details", values, "product_id = ?", new String[] { String.valueOf(product.id) });
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("order_details", "id = ?", new String[] { String.valueOf(id) });
        db.close();
    }
}
