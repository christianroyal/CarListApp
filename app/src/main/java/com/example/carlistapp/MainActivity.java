package com.example.carlistapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.noname.listviewapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // Declare views
    ListView listView;
    EditText etCount;
    Button btnLoad;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init views
        listView = findViewById(R.id.lv_list);
        etCount = findViewById(R.id.et_count_value);
        btnLoad = findViewById(R.id.btn_load);
        // Set onClickListener for Button
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<PersonObject> data = fetchPeople();
                setupListView(data);
            }
        });
    }

    private void setupListView(List<PersonObject> data) {
        Log.d(TAG, "setupListView: " + data);

        // Declare and Init our adapter
        StableArrayAdapter adapter = new StableArrayAdapter(MainActivity.this, data);

        // set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set onItemClickListener to ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // retrieve the value from the parent using the position passed in
                PersonObject value = (PersonObject) parent.getItemAtPosition(position);
                // Toast to show value that was clicked
                Toast.makeText(MainActivity.this, (CharSequence) value, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private List<PersonObject> fetchPeople() {
        // Declaring and Init values
        List<PersonObject> people = new ArrayList<>();
        PersonObject personObject = new PersonObject("Ferrari LaFerrari","Red","https://cimg2.ibsrv.net/ibimg/hgm/1920x1080-1/100/683/ferrari-laferrari_100683806.jpg");
        PersonObject personObject1 = new PersonObject("Mercedes Benz Project1","Silver","https://amp.businessinsider.com/images/59b6f7759803c51e008b45e3-1136-852.jpg");
        PersonObject personObject2 = new PersonObject("Porsche GT2","Silver","https://images-na.ssl-images-amazon.com/images/I/91oRztSpqvL._SX425_.jpg");
        PersonObject personObject3 = new PersonObject("Lamborghini Urus ","Yellow","https://cdn.motor1.com/images/mgl/rpZAX/s1/2019-lamborghini-urus.jpg");
        PersonObject personObject4 = new PersonObject("Maserati Levante","Blue","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/5p2a2423-1534175613.jpg?crop=1xw:1xh;center,top&resize=768:*");
        PersonObject personObject5 = new PersonObject("Dodge Challenger Hellcat","Lime Green","https://cdn-ds.com/stock/2017-Dodge-Challenger-SRT-Hellcat-Akron-OH/seo/ECL2585-2C3CDZC96HH591981/sz_666616/w_1280/h_853/2C3CDZC96HH591981_d89b123dd74fc70c.jpg");
        PersonObject personObject6 = new PersonObject("Saleen S7","Black","https://rmsothebys-cache.azureedge.net/e/0/e/0/8/2/e0e0823fda2a59b0231d5b5881dd0ea8ec6054ce.jpg");
        PersonObject personObject7 = new PersonObject("Shelby Cobra","Blue with White Stripes","https://cdn.bringatrailer.com/wp-content/uploads/2018/01/15174357458764daDSC_5724_cc-940x627.jpg");
        PersonObject personObject8 = new PersonObject("McLaren P1","Orange","https://www.carsinvasion.com/wp-content/uploads/2013/08/2013-McLaren-P1-Front.jpg");
        PersonObject personObject9 = new PersonObject("Koenesigg Agera R","Purple","https://images-na.ssl-images-amazon.com/images/I/716sNxtZoFL._SL1004_.jpg");
        PersonObject personObject10 = new PersonObject("Bugatti Chiron","Yellow and Black","https://2p2bboli8d61fqhjiqzb8p1a-wpengine.netdna-ssl.com/wp-content/uploads/2018/11/bugatti-chiron-yellow-1.jpg");

        // Add couple person
        people.add(personObject);
        people.add(personObject1);
        people.add(personObject2);
        people.add(personObject3);
        people.add(personObject4);
        people.add(personObject5);
        people.add(personObject6);
        people.add(personObject7);
        people.add(personObject8);
        people.add(personObject9);
        people.add(personObject10);



        //Return list of person
        return people;
    }


    private List<String> fetchData() {
        // Declaring and Init values
        List<String> list = new ArrayList<>();
        int count;
        String etValue = etCount.getText().toString();

        // Will try to run code in the try scope first
        // if that fails will run code in the catch scope
        try {
            count = Integer.valueOf(etValue);
        } catch (Exception ex) {
            count = 10;
        }

        // loop that adds numbers to the list
        for (int i = 0; i < count; i++) {
            list.add("" + i);
        }

        // returns the list
        return list;
    }
}
