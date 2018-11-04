package com.movetogbg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {
    private Context context;

    private String[] cardTitles;
    private String[] cardMessages;
    private int drawableImage;

    private LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] cardTitles, String[] cardMessages, int drawableImage){
        this.context = context;
        this.cardTitles = cardTitles;
        this.cardMessages = cardMessages;
        this.drawableImage = drawableImage;


        inflater = (LayoutInflater.from(context.getApplicationContext()));
    }


    @Override
    public int getCount() {
        return cardTitles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(view == null){
            view = inflater.inflate(R.layout.listview_card, viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.CardTitle = view.findViewById(R.id.textViewTitle);
            viewHolder.CardMsg = view.findViewById(R.id.textViewMsg);
            viewHolder.imageView = view.findViewById(R.id.imageView);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.CardTitle.setText(cardTitles[i]);
        viewHolder.CardMsg.setText(cardMessages[i]);
        viewHolder.imageView.setImageResource(drawableImage);

        return view;
    }
}

