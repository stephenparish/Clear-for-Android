package com.clear.app;

import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // hide the status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, TODO));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	  if ((((TextView) view).getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG) < 1) {
	        	  view.setBackgroundColor(Color.parseColor("#222222"));
	        	  ((TextView) view).setTextColor(Color.parseColor("#777777"));
	        	  ((TextView) view).setPaintFlags(((TextView) view).getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        	  } else {
        		  view.setBackgroundColor(Color.parseColor("#FF0000"));
        		  ((TextView) view).setTextColor(Color.parseColor("#FFFFFF"));
        		  ((TextView) view).setPaintFlags(((TextView) view).getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
        	  }
          }
        });
        
        // need to figure a way to make this work, can't apply the gradient colored list just yet
        for (int i = 0; i < lv.getChildCount(); i++) {
        	View listItem = lv.getChildAt(i);
        	listItem.setBackgroundColor(Color.parseColor("#FF4400"));
        	listItem.refreshDrawableState();
        }
        lv.refreshDrawableState();
    }
    static final String[] TODO = new String[] {
        "Hey look!", 
        "It's clear!", 
        "...",
        "on Android?",
        "This dude totally screwed up the colors."
      };
}