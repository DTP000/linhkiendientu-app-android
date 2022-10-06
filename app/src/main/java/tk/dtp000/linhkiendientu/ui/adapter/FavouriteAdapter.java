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
import tk.dtp000.linhkiendientu.data.dao.model.Favourite;
import tk.dtp000.linhkiendientu.utils.Constants;
import tk.dtp000.linhkiendientu.utils.StringHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    private List<Favourite> productList;
    private Context mContext;

    public FavouriteAdapter(Context context, List<Favourite> productList){
        mContext = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Favourite product = productList.get(position);
//        System.out.println(productList.size()+"haha");
        Picasso.get().load(product.image).into(holder.imgFavourite);
        holder.tvFavouriteName.setText(product.name);
        holder.tvPrice.setText(StringHelper.currencyFormat(product.price));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra(Constants.PRODUCT_ID, product.id);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgFavourite;
        private TextView tvFavouriteName;
        private TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFavourite = itemView.findViewById(R.id.imgProduct);
            tvFavouriteName = itemView.findViewById(R.id.tv_product_name1);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
