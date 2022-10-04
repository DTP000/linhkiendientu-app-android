package tk.dtp000.linhkiendientu.ui.constract;

import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

public interface CategoryConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
        void setCategoryToView(Category category);
    }

    interface IPresenter{
        void setView(IView view);
        void getProductListByCategory(int categoryId);
        void getCategory(int categoryId);
    }
}
