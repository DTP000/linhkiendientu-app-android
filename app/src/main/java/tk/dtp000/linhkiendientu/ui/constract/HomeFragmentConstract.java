package tk.dtp000.linhkiendientu.ui.constract;

import tk.dtp000.linhkiendientu.data.remote.entity.Category;
import tk.dtp000.linhkiendientu.data.remote.entity.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);
        void setHotProductsToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getHotProducts();
    }
}
