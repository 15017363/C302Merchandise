package com.example.a15017363.c302merchandise;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017363 on 6/6/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    Context context;
    int layoutResourceId;
    ArrayList<Item> itemList = null;


    public ItemAdapter(Context context, int resource, ArrayList<Item> itemList) {
        super(context, resource, itemList);
        this.context = context;
        this.layoutResourceId = resource;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemHolder();
            holder.itemName = (TextView)row.findViewById(R.id.tvName);
            holder.itemPrice = (TextView)row.findViewById(R.id.tvPrice);

            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
        }

        Item item1 = itemList.get(position);
        holder.itemName.setText("Item: "+item1.getItemName());
        holder.itemPrice.setText("Price: $"+item1.getPrice());

        return row;
    }

    static class ItemHolder
    {
        TextView itemName;
        TextView itemPrice;
    }

}
