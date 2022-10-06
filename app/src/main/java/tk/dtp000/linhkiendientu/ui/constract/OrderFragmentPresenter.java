package tk.dtp000.linhkiendientu.ui.constract;

import android.util.Log;

import tk.dtp000.linhkiendientu.data.dao.DatabaseDao;
import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;

import java.util.List;

public class OrderFragmentPresenter implements OrderFragmentConstract.IPresenter {
    private OrderFragmentConstract.IView mView;
    @Override
    public void setView(OrderFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getOrderDetailList() {
        List<OrderDetail> orderDetailList = DatabaseDao.getInstance().getOrderDetailDao().all();
        mView.setOrderDetailListToView(orderDetailList);
    }
}
