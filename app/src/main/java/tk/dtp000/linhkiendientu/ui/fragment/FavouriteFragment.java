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
import tk.dtp000.linhkiendientu.data.dao.model.Favourite;
import tk.dtp000.linhkiendientu.ui.adapter.FavouriteAdapter;
import tk.dtp000.linhkiendientu.ui.constract.FavouriteFragmentConstract;
import tk.dtp000.linhkiendientu.ui.constract.FavouriteFragmentPresenter;

import java.util.List;

public class FavouriteFragment extends Fragment implements FavouriteFragmentConstract.IView {
    private FavouriteFragmentConstract.IPresenter mPresenter;
    private RecyclerView rcFavourite;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourite, container, false);
        initGUI(rootView);
        initData();

        return rootView;
    }

    private void initData() {
        mPresenter = new FavouriteFragmentPresenter();
        mPresenter.setView(this);
        mPresenter.getFavouriteList();
    }

    private void initGUI(View rootView){
        rcFavourite = rootView.findViewById(R.id.rc_favourite);
        rcFavourite.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setFavouriteListToView(List<Favourite> favouriteList) {
        FavouriteAdapter adapter = new FavouriteAdapter(getContext(), favouriteList);
        rcFavourite.setLayoutManager(new LinearLayoutManager(getContext()));
        rcFavourite.setAdapter(adapter);
    }
}
