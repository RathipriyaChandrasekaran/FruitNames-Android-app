package com.rathipriya.fruitnames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{

	private Context mContext;
	int width;
	int height;

	// Keep all Images in array
	// Create Array thumbs resource id's:
	private int thumb[] = { R.drawable.apple, R.drawable.banana,
			R.drawable.blackberry,R.drawable.blueberries,
			R.drawable.cherry, R.drawable.grapes, R.drawable.kiwi,
			R.drawable.mango, R.drawable.oranges,
			R.drawable.peaches, R.drawable.pomegranate ,R.drawable.pineapple,
			R.drawable.raspberry, R.drawable.starwberry, R.drawable.watermelon

	};
	
	// Constructor
	public ImageAdapter(Context c,int width,int height){
		mContext = c;
		this.width=width;
		this.height=height;
	}

	@Override
	public int getCount() {

		return thumb.length;
	}

	@Override
	public Object getItem(int position) {
		return thumb[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Inflate the item layout and set the views
		View listItem = convertView;
		int pos = position;
		if (listItem == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			listItem = inflater.inflate(R.layout.row_item, null);
		}
		ImageView imageView = new ImageView(mContext);
		imageView.setImageResource(thumb[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(width, height));
		 
		return imageView;
	}
}
