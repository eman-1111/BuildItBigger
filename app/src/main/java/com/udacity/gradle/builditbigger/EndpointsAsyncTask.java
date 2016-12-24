package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eman.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Eman on 12/21/2016.
 */

public  class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;
    public AsyncFinish mAsyncFinish = null;

    public interface AsyncFinish{
        void processFinish(String output);
    }

    public EndpointsAsyncTask(AsyncFinish mAsyncFinish){
        this.mAsyncFinish = mAsyncFinish;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.129:8080/_ah/api/")//home
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")//virtual device
 //                   .setRootUrl("http://192.168.1.112:8080/_ah/api/")//work
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }


        try {
            Log.e("IOB", "Before");
            String names = myApiService.tellJoke(" ").execute().getData();
            Log.e("IO", names);
            return names;
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
            return e.getMessage();
        }
    }



    @Override
    protected void onPostExecute(String result) {
        mAsyncFinish.processFinish(result);

        // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(context,JokesDisplay.class);
//        intent.putExtra("JOKE_EXTRA", result);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
    }

}



