package cl.sebastianmena.miindicadorexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import cl.sebastianmena.miindicadorexample.models.Wrapper;
import cl.sebastianmena.miindicadorexample.network.GetIndicatorByDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new BackgroundUF().execute("uf","29-09-2017");
                new BackgroundDolar().execute("dolar","29-09-2017");

            }
        });
    }

    private class BackgroundUF extends GetIndicatorByDate{

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            if (wrapper !=null){
                TextView textView = (TextView) findViewById(R.id.ufTv);
                textView.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }

            progressDialog.dismiss();

        }
    }

    private class BackgroundDolar extends GetIndicatorByDate{


        @Override
        protected void onPostExecute(Wrapper wrapper) {
            if (wrapper !=null){
                TextView textView = (TextView) findViewById(R.id.dolarTv);
                textView.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }



        }
    }


}
