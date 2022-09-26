package tk.dtp000.linhkiendientu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.adapter.ProductAdapter;
import tk.dtp000.linhkiendientu.ui.constract.CategoryConstract;
import tk.dtp000.linhkiendientu.ui.constract.CategoryPresenter;
import tk.dtp000.linhkiendientu.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryConstract.IView{
    private CategoryConstract.IPresenter mPresenter;
    private RecyclerView rcCategory;

    private ImageView ivCategoryImage;
    private TextView tvCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        initGUI();
        initData();
    }

    private void initGUI(){
        ivCategoryImage = findViewById(R.id.iv_category_image);
        tvCategoryName = findViewById(R.id.tv_category_name);
        rcCategory = findViewById(R.id.rc_category);
    }

    private void initData() {
        int categoryId = getIntent().getIntExtra(Constants.CATEGORY_ID, 1);

        mPresenter = new CategoryPresenter();
        mPresenter.setView(this);
        mPresenter.getProductListByCategory(categoryId);
        mPresenter.getCategory(categoryId);
    }

    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(this, productList);
        rcCategory.setLayoutManager(new LinearLayoutManager(this));
        rcCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCategoryToView(Category category) {
        Picasso.get().load(category.image).into(ivCategoryImage);
        tvCategoryName.setText(category.name);
    }
}