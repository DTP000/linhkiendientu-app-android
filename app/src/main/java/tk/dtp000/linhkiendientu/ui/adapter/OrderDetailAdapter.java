package tk.dtp000.linhkiendientu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tk.dtp000.linhkiendientu.ProductDetailActivity;
import tk.dtp000.linhkiendientu.R;
import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;
import tk.dtp000.linhkiendientu.utils.Constants;
import tk.dtp000.linhkiendientu.utils.StringHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    private List<OrderDetail> productList;
    private Context mContext;

    public OrderDetailAdapter(Context context, List<OrderDetail> productList){
        mContext = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderDetail product = productList.get(position);
//        System.out.println(productList.size()+"haha");
        Picasso.get().load(product.image).into(holder.imgOrderDetail);
//        holder.imgOrderDetail.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.tv_product_name1.setText(product.name);
        holder.tvPrice.setText(StringHelper.currencyFormat(product.price));
        holder.tvQuanlity.setText(product.quantity + "");

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, ProductDetailActivity.class);
//                intent.putExtra(Constants.PRODUCT_ID, product.id);
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgOrderDetail;
        private TextView tv_product_name1;
        private TextView tvPrice, tvTotalPrice, tvQuanlity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOrderDetail = itemView.findViewById(R.id.img_cart);
            tv_product_name1 = itemView.findViewById(R.id.name_cart);
            tvPrice = itemView.findViewById(R.id.price_cart);
            tvTotalPrice = itemView.findViewById(R.id.item_total_price);
            tvQuanlity = itemView.findViewById(R.id.quantity_detail);
        }
    }
}
