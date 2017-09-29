package cl.sebastianmena.miindicadorexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sebastián Mena on 29-09-2017.
 */

public class Interceptor {

    private static final String BASE_URL = "http://mindicador.cl/";

    public Miindicador getBasic(){

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Miindicador indicatorRequest = interceptor.create(Miindicador.class);
        return  indicatorRequest;
    }
}
