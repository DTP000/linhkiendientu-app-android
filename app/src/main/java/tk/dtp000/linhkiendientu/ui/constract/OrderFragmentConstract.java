package tk.dtp000.linhkiendientu.ui.constract;

import tk.dtp000.linhkiendientu.data.dao.model.OrderDetail;

import java.util.List;

public interface OrderFragmentConstract {
    interface IView{
        void setOrderDetailListToView(List<OrderDetail> orderDetailList);
    }

    interface IPresenter{
        void setView(IView view);
        void getOrderDetailList();
    }
}
