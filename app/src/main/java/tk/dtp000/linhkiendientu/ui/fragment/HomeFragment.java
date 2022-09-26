package tk.dtp000.linhkiendientu.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tk.dtp000.linhkiendientu.R;
import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.adapter.CategoryAdapter;
import tk.dtp000.linhkiendientu.ui.adapter.ProductAdapter;
import tk.dtp000.linhkiendientu.ui.constract.HomeFragmentConstract;
import tk.dtp000.linhkiendientu.ui.constract.HomeFragmentPresenter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentConstract.IView {
    private HomeFragmentConstract.IPresenter mPresenter;
    private RecyclerView rc;
    private RecyclerView rcHotProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initGUI(rootView);
        initData();

        return rootView;
    }

    private void initGUI(View rootView){
        rc = rootView.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rcHotProducts = rootView.findViewById(R.id.rc_hot_products);

    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getCategoryList();
        mPresenter.getHotProducts();
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

    @Override
    public void setHotProductsToView(List<Product> productList) {
        Log.i("debugF", "vo duoc day rui");
        for (Product ct :
                productList) {
            Log.i("debug", String.format("prd id => %d, name => %s, desc => %s\n\n", ct.id, ct.name, ct.categoryId));
        }
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcHotProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcHotProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
