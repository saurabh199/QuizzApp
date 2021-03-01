package com.proprofs.proprofsquizzes;

/**
 * Created by Shubham Jain on 12-07-2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeatureAdapter extends ArrayAdapter<ListItem> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<ListItem> mGridData = new ArrayList<ListItem>();

    public FeatureAdapter(Context mContext, int layoutResourceId, ArrayList<ListItem> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }
    /**
     * Updates grid data and refresh grid items.
     *
     * @param mGridData
     */
    public void setGridData(ArrayList<ListItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }
    /* @Override
     public int getCount() {
         return 6;
     }*/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.linearLayout = (LinearLayout) row.findViewById(R.id.clicks);
            holder.imageView = (ImageView) row.findViewById(R.id.feimage);
            holder.name = (TextView) row.findViewById(R.id.fquiz);
            holder.title = (TextView) row.findViewById(R.id.title);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ListItem item = mGridData.get(position);
//        holder.titleTextView.setText(Html.fromHtml(item.getTitle()));

            holder.name.setText("" + item.getFeaturedName());

            Picasso.with(mContext).load(item.getFeaturedImage()).into(holder.imageView);
            holder.title.setText("" + item.getFeaturedTitle());
           /* holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ftitle = mGridData.get(position).getFeaturedTitle();//run karo??o
                    // now you get url title what is next ???
                    openDetailActivity(mContext, ftitle);
                }
            });*/
            return row;
        }


    static class ViewHolder {
        TextView name;
        ImageView imageView;
        LinearLayout linearLayout;
        TextView title;

    }
    /*private void openDetailActivity(Context mContext, String title)
    {
        Intent intent = new Intent(mContext,QuizActivity.class);
        intent.putExtra("title",title);
        mContext.startActivity(intent);
    }*/
}
