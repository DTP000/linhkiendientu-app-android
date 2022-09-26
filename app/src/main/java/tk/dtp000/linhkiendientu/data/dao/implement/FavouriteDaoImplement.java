package tk.dtp000.linhkiendientu.data.dao.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import tk.dtp000.linhkiendientu.data.dao.DatabaseHelper;
import tk.dtp000.linhkiendientu.data.dao.FavouriteDao;
import tk.dtp000.linhkiendientu.data.dao.model.Favourite;


import java.util.ArrayList;
import java.util.List;

public class FavouriteDaoImplement extends DatabaseHelper implements FavouriteDao {
    public FavouriteDaoImplement(Context context) {
        super(context);
    }

    @Override
    public Favourite find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("favourites", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Favourite product = new Favourite(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2),  cursor.getDouble(3), cursor.getString(4), cursor.getInt(5));
        return null;
    }

    @Override
    public List<Favourite> all() {
        List<Favourite>  productList = new ArrayList<>();
        String query = "SELECT * FROM favourites";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Favourite product = new Favourite(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2),  cursor.getDouble(3), cursor.getString(4), cursor.getInt(5));
            productList.add(product);
            cursor.moveToNext();
        }
        return productList;
    }

    @Override
    public void insert(Favourite product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", product.name);
        values.put("quantity", product.quantity);
        values.put("price", product.price);
        values.put("image", product.image);
        values.put("categoryId", product.categoryId);


        db.insert("favourites", null, values);
        db.close();
    }

    @Override
    public void update(Favourite product) {

    }

    @Override
    public void delete(int id) {

    }
}
