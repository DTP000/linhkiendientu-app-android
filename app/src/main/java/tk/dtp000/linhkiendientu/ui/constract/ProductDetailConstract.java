package tk.dtp000.linhkiendientu.ui.constract;

import tk.dtp000.linhkiendientu.data.remote.entity.Product;

public interface ProductDetailConstract {
    interface IView{
        void setProductToView(Product product);
    }

    interface IPresenter{
        void setView(ProductDetailConstract.IView view);
        void getProduct(int productId);
    }
}
