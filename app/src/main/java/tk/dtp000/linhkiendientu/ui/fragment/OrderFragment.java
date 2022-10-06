package tk.dtp000.linhkiendientu.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tk.dtp000.linhkiendientu.R;
import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;
import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.ui.adapter.OrderDetailAdapter;
import tk.dtp000.linhkiendientu.ui.constract.OrderFragmentConstract;
import tk.dtp000.linhkiendientu.ui.constract.OrderFragmentPresenter;

import java.util.List;

public class OrderFragment extends Fragment implements OrderFragmentConstract.IView {
    private OrderFragmentConstract.IPresenter mPresenter;
    private RecyclerView rcOrderDetail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootVIew = inflater.inflate(R.layout.fragment_order, container, false);

        initGUI(rootVIew);
        initData();

        return rootVIew;
    }

    private void initGUI(View rootVIew){

        rcOrderDetail = rootVIew.findViewById(R.id.recycleView_giohang);
    }

    private void initData(){
        mPresenter = new OrderFragmentPresenter();
        mPresenter.setView(this);
        mPresenter.getOrderDetailList();
    }

    @Override
    public void setOrderDetailListToView(List<OrderDetail> orderDetailList) {
        for (OrderDetail ct :
                orderDetailList) {
            Log.i("debug", String.format("order id => %d, name => %s\n\n", ct.id, ct.name));
        }
        OrderDetailAdapter adapter = new OrderDetailAdapter(getContext(), orderDetailList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        rcOrderDetail.setLayoutManager(layoutManager);
        rcOrderDetail.setAdapter(adapter);

    }

}
