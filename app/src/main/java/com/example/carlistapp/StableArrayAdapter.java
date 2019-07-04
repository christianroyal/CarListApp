package com.example.carlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noname.listviewapp.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

class StableArrayAdapter extends ArrayAdapter<PersonObject> {
    private HashMap<PersonObject, Integer> idMap = new HashMap<>();

    //Declare context and data to be described in class scope
    private Context context;
    private List<PersonObject> data;

    // Create constructor and pass values from constructor to the super class/parent
    StableArrayAdapter(Context context, List<PersonObject> data) {
        super(context, R.layout.customlayout, data);

        //init context and data
        this.context = context;
        this.data = data;



        for (int i = 0; i < data.size(); i++) {
            idMap.put(data.get(i), i);
        }
    }
    ImageView img;

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=  inflater.inflate(R.layout.customlayout,parent,false);

        img = (ImageView)itemView.findViewById(R.id.iv_image);

        TextView tvName=itemView.findViewById(R.id.tv_name);
        TextView tvDob=itemView.findViewById(R.id.tv_dob);
        PersonObject person = data.get(position);

        tvName.setText(person.getAuto());
        tvDob.setText(person.getColor());
        Picasso.with(context).load(person.getImageUrl()).placeholder(R.drawable.car).into(img);


        PersonObject p1 = new PersonObject("Automobile","Color","url");


        return itemView;


    }


    @Override
    public long getItemId(int position) {
        PersonObject item = getItem(position);
        return idMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
