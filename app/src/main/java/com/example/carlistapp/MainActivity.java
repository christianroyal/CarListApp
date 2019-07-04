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
        PersonObject personObject = new PersonObject("Ferrari LaFerrari","Red","https://compareceleb.com/uploads/posts/2018-01/1515403862_denzel-washington-height-weight-body-measurements.jpg");
        PersonObject personObject1 = new PersonObject("Mercedes Benz C63","dob","https://m.media-amazon.com/images/M/MV5BMTk2OTY5MzcwMV5BMl5BanBnXkFtZTgwODM4MDI5MjI@._V1_SY1000_CR0,0,666,1000_AL_.jpg");
        PersonObject personObject2 = new PersonObject("Porsche 911","dob","https://www.tsn.ca/polopoly_fs/1.1327309.1561303868!/fileimage/httpImage/image.jpg_gen/derivatives/landscape_620/lewis-hamilton.jpg");
        PersonObject personObject3 = new PersonObject("Lamborghini Urus ","dob","");
        PersonObject personObject4 = new PersonObject("Maserati Levante","dob","");
        PersonObject personObject5 = new PersonObject("Dodge Challenger Hellcat","dob","");
        PersonObject personObject6 = new PersonObject("Saleen S7","dob","");
        PersonObject personObject7 = new PersonObject("Shelby Cobra","dob","");
        PersonObject personObject8 = new PersonObject("","dob","");
        PersonObject personObject9 = new PersonObject("Samantha Jenkins","dob","");
        PersonObject personObject10 = new PersonObject("Samantha Jenkins","dob","");

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
