package tk.dtp000.linhkiendientu.data.remote;

import retrofit2.http.Path;
import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("categories")
    Call<List<Category>> categoryList();

    @GET("category/{id}")
    Call<Category> category(@Path("id") int id);

    @GET("products")
    Call<List<Product>> productList();

    @GET("product/{id}")
    Call<Product> product(@Path("id") int id);

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
