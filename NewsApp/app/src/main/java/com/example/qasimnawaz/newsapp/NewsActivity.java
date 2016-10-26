package com.example.qasimnawaz.newsapp;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NewsActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "DEBUGGING";
    String link;
    String result;
    String loadurl = "https://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=";
    String ghi = "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=dance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Bundle bundle = getIntent().getExtras();
        link = bundle.getString("content");

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo.isConnected()) {

            new LoadFeed().execute(ghi);

        }else{
            Log.e(DEBUG_TAG,"no internet");
        }
        Log.e(DEBUG_TAG, link );

    }

    public class LoadFeed extends AsyncTask<String, Void, String>{

        ProgressDialog dialog;
        String result = null;

        @Override
        protected void onPreExecute() {
            ProgressDialog dialogue = new ProgressDialog(NewsActivity.this);
        }

        @Override
        protected String doInBackground(String... params) {

            URL feedapi = null;
            try {
                feedapi = new URL(ghi);

                HttpURLConnection connection = (HttpURLConnection) feedapi.openConnection();

                connection.setRequestMethod("GET");
                connection.connect();

                int rsponse = connection.getResponseCode();
                Log.e(DEBUG_TAG, String.valueOf(rsponse));
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
                StringBuilder builder = new StringBuilder();
                String line;
                while((line = reader.readLine()) !=null){
                    builder.append(line).append("\n");
                }

                stream.close();
                String result = builder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;


        }




        @Override
        protected void onPostExecute(String s) {

            Log.e(DEBUG_TAG,s);

            String url = null;
            WebView webView = (WebView) findViewById(R.id.webview);

//            WebSettings webSettings = webView.getSettings();
//            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//            webSettings.setJavaScriptEnabled(true);


            try {
                JSONObject rootObject = new JSONObject(s);

                if(rootObject != null){

                    JSONObject responseData = rootObject.getJSONObject("responseData");

                    JSONObject feed = responseData.getJSONObject("feed");

                    JSONArray entries = feed.getJSONArray("entries");

                    JSONObject item;
                    for(int i =0; i<entries.length(); i++){

                        if(i == 0) {

                            item = entries.getJSONObject(i);
                            url = item.getString("content");

                        }
                        if(i != 0){

                            url += "\n\n";
                            item = entries.getJSONObject(i);

                            url += item.getString("content");
                        }

                    }

                    webView.loadDataWithBaseURL(null, url , "text/html" , "UTF-8",null);

                }
            } catch (JSONException e) {
                Log.e(DEBUG_TAG,"JSON ExcePtion" + e.getMessage());
            }

        }
        }
    }

