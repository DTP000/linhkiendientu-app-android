package tk.dtp000.linhkiendientu.data.remote;

import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("categories")
    Call<List<Category>> categoryList();

    @GET("category")
    Call<Category> category(@Query("id") int id);

    @GET("products")
    Call<List<Product>> productList();

    @GET("product")
    Call<Product> product(@Query("id") int id);

    @GET("products/hot")
    Call<List<Product>> hotProducts();

    /**
     * localhost/api/products/filter.php?categoryId=1
     * @param categoryId
     * @return
     */
    @GET("products/filter")
    Call<List<Product>> productListByCategory(@Query("categoryId") int categoryId);
}
