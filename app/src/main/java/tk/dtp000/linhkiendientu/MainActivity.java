package tk.dtp000.linhkiendientu;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import tk.dtp000.linhkiendientu.ui.fragment.FavouriteFragment;
import tk.dtp000.linhkiendientu.ui.fragment.HomeFragment;
import tk.dtp000.linhkiendientu.ui.fragment.NotificationFragment;
import tk.dtp000.linhkiendientu.ui.fragment.OrderFragment;
import tk.dtp000.linhkiendientu.ui.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
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