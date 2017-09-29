package cl.sebastianmena.miindicadorexample.network;

import android.os.AsyncTask;

import java.io.IOException;

import cl.sebastianmena.miindicadorexample.models.Wrapper;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastián Mena on 29-09-2017.
 */

public class GetIndicatorByDate extends AsyncTask<String,Void,Wrapper>{
    @Override
    protected Wrapper doInBackground(String... strings) {

        Miindicador miindicador = new Interceptor().getBasic();
        Call<Wrapper> indicator = miindicador.indicatorByDate(strings[0],strings[1]);
        try{
            Response<Wrapper> response = indicator.execute();
            if (200 == response.code() && response.isSuccessful()){

                return response.body();
            }else{

                return null;

            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
