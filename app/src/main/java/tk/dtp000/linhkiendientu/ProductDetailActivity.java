package tk.dtp000.linhkiendientu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import tk.dtp000.linhkiendientu.data.dao.DatabaseDao;
import tk.dtp000.linhkiendientu.data.dao.model.Favourite;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;
import tk.dtp000.linhkiendientu.ui.constract.ProductDetailConstract;
import tk.dtp000.linhkiendientu.ui.constract.ProductDetailPresenter;
import tk.dtp000.linhkiendientu.utils.Constants;
import tk.dtp000.linhkiendientu.utils.StringHelper;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends BaseActivity implements ProductDetailConstract.IView {
    private ProductDetailConstract.IPresenter mPresenter;

    private ImageView imgProduct;
    private TextView tvName;
    private TextView tvPrice, quantity_detail;
    private ImageButton ibBtnBack;
    private ImageButton ibBtnFavourite, btn_add, btn_sub;
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
        quantity_detail = findViewById(R.id.quantity_detail);
        btn_add = findViewById(R.id.btn_add_quality);
        btn_sub = findViewById(R.id.btn_sub_quality);
    }

    private void initData() {

        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);
        ibBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            @Override
            public void onClick(View view) {
                int quanlity = Integer.parseInt((String) quantity_detail.getText());
                if( quanlity < 50 ) {
                    temp = quanlity+1;
                    quantity_detail.setText(temp);
                }
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
    }

    @Override
    public void setProductToView(Product product) {
        mProduct = product;
        Picasso.get().load(product.image).into(imgProduct);
        tvName.setText(product.name);
        tvPrice.setText(StringHelper.currencyFormat(product.price));
    }
}