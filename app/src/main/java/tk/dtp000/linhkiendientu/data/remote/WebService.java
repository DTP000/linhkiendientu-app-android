package tk.dtp000.linhkiendientu.data.remote;

import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("categories/")
    Call<List<Category>> categoryList();

    @GET("categories/show.php")
    Call<Category> category(@Query("id") int id);

    @GET("products/")
    Call<List<Product>> productList();

    @GET("products/show.php")
    Call<Product> product(@Query("id") int id);

    @GET("products/hot.php")
    Call<List<Product>> hotProducts();

    /**
     * localhost/api/products/filter.php?categoryId=1
     * @param categoryId
     * @return
     */
    @GET("products/filter.php")
    Call<List<Product>> productListByCategory(@Query("categoryId") int categoryId);
}
