package dfguerrero.com.androidassignment1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    public static final String TAG = "TAG";
    protected int counter =0;
    TextView counterView;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       /* if((savedInstanceState != null)&&(savedInstanceState.getString("counter")!=null)){
            counter = savedInstanceState.getString("counter");
        }*/

        setContentView(R.layout.activity_main);
        counterView = (TextView) findViewById(R.id.count);
        name = (TextView) findViewById(R.id.textView3);


    }


    public void randomClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Intent randomIntent = new Intent(this, RandomActivity.class);
        startActivity(randomIntent);


    }

    public void quotesClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Intent quotesIntent = new Intent(this, QuotesActivity.class);
        startActivity(quotesIntent);
    }

    public void animalsClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Intent animalsIntent = new Intent(this, AnimalsActivity.class);
        startActivity(animalsIntent);


    }

    public void jokesClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Intent jokesIntent = new Intent(this, JokesActivity.class);
        startActivity(jokesIntent);


    }

    public void inspirationClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Intent scienceIntent = new Intent(this, InspirationActivity.class);
        startActivity(scienceIntent);


    }

    public void musicClick(View v) {
        counter++;
        counterView.setText("(" + counter + ")");
        Log.d(TAG, "MusicCount");
        Intent muse = new Intent(getApplicationContext(), MusicActivity.class);
        startActivity(muse);

    }

    public void lastClick(View v) {

        Intent lastIntent = new Intent(this, LastActivity.class);
        startActivity(lastIntent);


    }

    /****************************
     * Saving the Counter State
     ****************************/


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("counter", counterView.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        String counter = inState.getString("counter");
        counterView.setText(counter);
    }

}
