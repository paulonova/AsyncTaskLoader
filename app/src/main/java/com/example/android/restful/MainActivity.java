package com.example.android.restful;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> { // String matches with the object in AsyncTaskLoader<String>

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);
    }

    /**Action starts here when I click the button
     * forceLoad() starts the onCreateLoader()*/
    public void runClickHandler(View view) {
//        getSupportLoaderManager().initLoader(0, null, this).forceLoad(); // Don´t recreate the Loader each time I call it..
        getSupportLoaderManager().restartLoader(0, null, this).forceLoad();// Recreate the Loader each time I call it..


    }

    public void clearClickHandler(View view) {
        output.setText("");
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        output.append("Creating loader\n");
        return new MyTaskLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        output.append("Loader finished, returned: " + data + "\n");

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }


    //Support repository version
    /**So right away you can see that a task loader architecture is a lot simpler than AsyncTask.
     * There's only one type to declare that's the return value and you can pass data into the
     * loader when you initialize it*/
    private static class MyTaskLoader extends AsyncTaskLoader<String>{

        public MyTaskLoader(Context context) {
            super(context);
        }

        @Override
        public String loadInBackground() {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "From the loader";// this is the data..
        }


        /**The job of this method is to return the data to you and then give you a
         * chance to modify it any way you like.*/
        @Override
        public void deliverResult(String data) {
            data += ", delivered";
            super.deliverResult(data);
        }
    }


}
