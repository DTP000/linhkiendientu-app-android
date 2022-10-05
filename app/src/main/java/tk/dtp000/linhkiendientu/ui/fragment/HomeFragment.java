package tk.dtp000.linhkiendientu.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import tk.dtp000.linhkiendientu.R;
import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.adapter.CategoryAdapter;
import tk.dtp000.linhkiendientu.ui.adapter.ProductAdapter;
import tk.dtp000.linhkiendientu.ui.constract.HomeFragmentConstract;
import tk.dtp000.linhkiendientu.ui.constract.HomeFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentConstract.IView {
    private HomeFragmentConstract.IPresenter mPresenter;
    private RecyclerView rc;
    private RecyclerView rcHotProducts;
    private ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initGUI(rootView);
        initData();
        Slider();
        return rootView;
    }

    private void initGUI(View rootView){
        rc = rootView.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rcHotProducts = rootView.findViewById(R.id.rc_hot_products);
        viewFlipper = rootView.findViewById(R.id.viewFlipper);

    }


    private void Slider() {
        List<String> slider = new ArrayList<>();
        slider.add(getString(R.string.slide_1));
        slider.add(getString(R.string.slide_2));
        slider.add(getString(R.string.slide_3));
        for (int i = 0; i< slider.size();i++) {
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext())
                    .load(slider.get(i))
                    .into(imageView);

            //fix imageView vào ViewFlipper
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_step_1 = AnimationUtils.loadAnimation(getContext(),R.anim.slider_step_1);
        Animation animation_slide_step_2 = AnimationUtils.loadAnimation(getContext(),R.anim.slider_step_2);

        viewFlipper.setInAnimation(animation_slide_step_1);
        viewFlipper.setOutAnimation(animation_slide_step_2);
    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getCategoryList();
        mPresenter.getHotProducts();
    }

    @Override
    public void setHotProductsToView(List<Product> productList) {
        Log.i("debugF", "vo duoc day rui");
        for (Product ct :
                productList) {
            Log.i("debug", String.format("prd id => %d, name => %s, desc => %s\n\n", ct.id, ct.name, ct.categoryId));
        }
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcHotProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcHotProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCategoryListToView(List<Category> categoryList) {
        for (Category ct :
                categoryList) {
            Log.i("debug", String.format("category id => %d, name => %s, desc => %s\n\n", ct.id, ct.name, ct.description));
        }
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categoryList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showCategory(Category category) {

    }


}
