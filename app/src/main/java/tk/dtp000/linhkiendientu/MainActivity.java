package tk.dtp000.linhkiendientu;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.dtp000.linhkiendientu.data.remote.RetrofitContrller;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.fragment.FavouriteFragment;
import tk.dtp000.linhkiendientu.ui.fragment.HomeFragment;
import tk.dtp000.linhkiendientu.ui.fragment.NotificationFragment;
import tk.dtp000.linhkiendientu.ui.fragment.OrderFragment;
import tk.dtp000.linhkiendientu.ui.fragment.UserFragment;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testAPI();
        initGUI();

    }

    private void testAPI(){
        Call<List<Product>> call = RetrofitContrller.service().productListByCategory(9);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.i("testAPI", response.toString());
                Log.i("testAPI", String.valueOf(response.body()));
//                mView.setProductListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.i("testAPI", t.getMessage());
            }
        });
    }

    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        return true;
                    case R.id.order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                        return true;
                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                        return true;
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}