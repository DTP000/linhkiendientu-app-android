package tk.dtp000.linhkiendientu.ui.constract;

import tk.dtp000.linhkiendientu.data.dao.model.Favourite;

import java.util.List;

public interface FavouriteFragmentConstract {
    interface IView{
        void setFavouriteListToView(List<Favourite> favouriteList);
    }

    interface IPresenter{
        void setView(IView view);
        void getFavouriteList();
    }
}
