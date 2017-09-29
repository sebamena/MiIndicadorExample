package cl.sebastianmena.miindicadorexample.network;

import cl.sebastianmena.miindicadorexample.models.Wrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Sebastián Mena on 29-09-2017.
 */

public interface Miindicador {

    @GET("api/{indicator}/{date}/")
    Call<Wrapper> indicatorByDate(@Path("indicator") String indicator, @Path("date") String date);

}
