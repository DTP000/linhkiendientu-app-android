package tk.dtp000.linhkiendientu.ui.constract;

import android.content.Context;

import tk.dtp000.linhkiendientu.data.dao.DatabaseDao;
import tk.dtp000.linhkiendientu.data.dao.DatabaseSQlite;
import tk.dtp000.linhkiendientu.data.remote.RetrofitContrller;
import tk.dtp000.linhkiendientu.data.remote.WebService;
import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter implements  HomeFragmentConstract.IPresenter{
    private HomeFragmentConstract.IView mView;

    public HomeFragmentPresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }
    @Override
    public void setView(HomeFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategoryList() {
        WebService service = RetrofitContrller.service();
        service.categoryList().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mView.setCategoryListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHotProducts() {
        WebService service = RetrofitContrller.service();
        service.hotProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setHotProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

}
