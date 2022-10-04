package tk.dtp000.linhkiendientu.data.remote;

import tk.dtp000.linhkiendientu.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitContrller {
    private static Retrofit retrofit;

    public static WebService service(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WebService.class);
    }
}
