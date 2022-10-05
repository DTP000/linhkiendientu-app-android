package tk.dtp000.linhkiendientu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tk.dtp000.linhkiendientu.R;
import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;
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
        rcOrderDetail = rootVIew.findViewById(R.id.rc_order_detail);
    }

    private void initData(){
        mPresenter = new OrderFragmentPresenter();
        mPresenter.setView(this);
    }

    @Override
    public void setOrderDetailListToView(List<OrderDetail> orderDetailList) {
        OrderDetailAdapter adapter = new OrderDetailAdapter(getContext(), orderDetailList);
        rcOrderDetail.setAdapter(adapter);
        rcOrderDetail.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
