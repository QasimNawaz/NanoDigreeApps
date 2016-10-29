package com.example.qasimnawaz.newsapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qasimnawaz.newsapp.Adapters.WordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "DebuGGing";
    String keyword;
    EditText news;
    String word;
    private String feedURL = "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=";
    String[] links  = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news = (EditText) findViewById(R.id.search_edit_text);
        OnSearchClickListener();
    }

    private void OnSearchClickListener() {

        Button button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo.isConnected() && networkInfo.isAvailable()){
                    keyword = news.getText().toString();
                    keyword = keyword.replaceAll(" ","%20");
                    new Task().execute(feedURL+keyword);
                    Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
                }else  {
                    Toast.makeText(MainActivity.this,"No Networks",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private class Task extends AsyncTask<String, Void, ArrayList<WordAdapter>> {

        ProgressDialog dialog;
        String result = null;


        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("wait while a minute");
            dialog.setTitle("Loading...");
            dialog.show();
        }

        @Override
        protected ArrayList<WordAdapter> doInBackground(String... params) {

            ArrayList<WordAdapter> arrayList = new ArrayList<>();

            try {
                URL feedapi = new URL(feedURL+keyword);
                HttpURLConnection connection = (HttpURLConnection) feedapi.openConnection();

                connection.setRequestMethod("GET");
                connection.connect();

                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String line;
                while((line = reader.readLine()) !=null){
                    builder.append(line).append("\n");
                }
                stream.close();
                String result = String.valueOf(builder);

                JSONObject rootObject = new JSONObject(result);
                JSONObject feed = rootObject.getJSONObject("responseData");
                JSONArray entries = feed.getJSONArray("entries");
                for (int i =0; i<entries.length();i++){

                    JSONObject titles = entries.getJSONObject(i);
                    String title = titles.getString("title");
                    title = String.valueOf(Html.fromHtml(title));

                    links[i] = titles.getString("link");

                    arrayList.add(new WordAdapter(title));

                }
                Log.e(DEBUG_TAG, String.valueOf(entries.length()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return arrayList;

        }

        @Override
        protected void onPostExecute(ArrayList<WordAdapter> wordAdapters) {
            dialog.dismiss();
            ListAdapter adapter = new com.example.qasimnawaz.newsapp.Adapters.ListAdapter(MainActivity.this,wordAdapters);
            ListView list = (ListView) findViewById(R.id.items);
            list.setAdapter(adapter);
            final String url = "my message";

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                    intent.putExtra("content", links[position]);
                    startActivity(intent);
                }
            });
        }
    }
}

