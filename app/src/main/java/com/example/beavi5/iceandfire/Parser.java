package com.example.beavi5.iceandfire;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.beavi5.iceandfire.adapter.RVHeroAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by beavi5 on 22.07.2017.
 */

public class Parser {
   // private static ArrayList<Character> listHeroes;
    ArrayList<Character> listHeroes=new ArrayList<>();
    RecyclerView recyclerView;
    String feedUrl;
    RVHeroAdapter adapter;
    int page;

    public  String json;
     static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public Parser(RecyclerView recyclerView) {
         adapter=new RVHeroAdapter(listHeroes);
        this.recyclerView = recyclerView;
        this.recyclerView.setAdapter(adapter);
        page=0;
    }

    public  List<Character> parse(){
        page++;
        new myAsyncTask().execute();




/*


        }*/


        return null;
    }

    class myAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            String s="";
            try {
                 s = Parser.readUrl("https://www.anapioficeandfire.com/api/characters?page="+page+"&pageSize=50");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String json = s;
            Gson gson = new Gson();
            Character[] heroes = gson.fromJson(json, Character[].class);



            ArrayList<Character> newList = new ArrayList<Character>(Arrays.asList(heroes));
            listHeroes.addAll(newList);
            for (Character character :listHeroes) {
                Log.d("arr", character.getGender());

            }
//            listHeroes.addAll(listHeroes);


           adapter.notifyDataSetChanged();

        }

        }
}
