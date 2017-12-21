package com.tutorialsee.ecommer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class ListbaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Beanclasses>bean;

    public ListbaseAdapter(Context context, ArrayList<Beanclasses> bean) {
        this.context = context;
        this.bean = bean;

    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list, null);

            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.subtitle = (TextView)convertView.findViewById(R.id.subtitle);
            viewHolder.shop = (TextView)convertView.findViewById(R.id.shop);
            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }


        Beanclasses bean = (Beanclasses)getItem(position);

        viewHolder.image.setImageResource(bean.getImage());
        viewHolder.title.setText(bean.getTitle());
        viewHolder.subtitle.setText(bean.getSubtitle());
        viewHolder.shop.setText(bean.getShop());

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(context, ProductCategories.class);
                context.startActivity(ii);

            }
        });
        return convertView;
    }
    class ViewHolder {
        ImageView image;
        TextView title;
        TextView subtitle;
        TextView shop;

    }
}