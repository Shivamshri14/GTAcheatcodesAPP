package com.saksham.gtacodes;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] cheats;
    private final String[] codes;

    public MyListAdapter(Activity context, String[] cheats,String[] codes)
    {
        super(context, R.layout.activity_listview, cheats);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.cheats = cheats;
        this.codes=codes;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_listview, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(cheats[position]);
        subtitleText.setText(codes[position]);

        return rowView;

    };
}
