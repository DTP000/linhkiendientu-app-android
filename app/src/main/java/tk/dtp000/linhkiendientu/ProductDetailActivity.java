package tk.dtp000.linhkiendientu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import tk.dtp000.linhkiendientu.data.dao.DatabaseDao;
import tk.dtp000.linhkiendientu.data.dao.model.Favourite;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.constract.ProductDetailConstract;
import tk.dtp000.linhkiendientu.ui.constract.ProductDetailPresenter;
import tk.dtp000.linhkiendientu.utils.Constants;
import tk.dtp000.linhkiendientu.utils.StringHelper;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

public class ProductDetailActivity extends BaseActivity implements ProductDetailConstract.IView {
    private ProductDetailConstract.IPresenter mPresenter;

    private ImageView imgProduct;
    private TextView tvName;
    private TextView tvPrice;
    private Spinner spinner_soluong;
    private ImageButton ibBtnBack;
    private ImageButton ibBtnFavourite;
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initGUI();
        initData();
    }

    private void initGUI() {
        imgProduct = findViewById(R.id.img_detail);
        tvName = findViewById(R.id.tv_product_name);
        tvPrice = findViewById(R.id.tv_product_price);
        ibBtnBack = findViewById(R.id.ib_btn_back);
        ibBtnFavourite = findViewById(R.id.ib_btn_favourite);
        spinner_soluong = findViewById(R.id.spinner_soluong);

    }

    private void initData() {

        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);
        ibBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ibBtnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Favourite favourite = new Favourite(
                        mProduct.id,
                        mProduct.name,
                        mProduct.quantity,
                        mProduct.price,
                        mProduct.image,
                        mProduct.categoryId
                );
                DatabaseDao.getInstance().getProductDao().insert(favourite);
            }
        });

        mPresenter = new ProductDetailPresenter();
        mPresenter.setView(this);
        mPresenter.getProduct(productId);

        Integer[] soluong = new Integer[]{1,5,10,15,20,50,100};
        ArrayAdapter<Integer> adapterSpin =
                new ArrayAdapter<>(this,R.layout.spinner_item,soluong);
        spinner_soluong.setAdapter(adapterSpin);
    }

    @Override
    public void setProductToView(Product product) {
        mProduct = product;
        Picasso.get().load(product.image).into(imgProduct);
        tvName.setText(product.name);
        tvPrice.setText(StringHelper.currencyFormat(product.price));
    }
}