package com.proprofs.proprofsquizzes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.proprofs.proprofsquizzes.Model.Keys;
import com.proprofs.proprofsquizzes.Model.Quiz;
import com.proprofs.proprofsquizzes.R;
import com.proprofs.proprofsquizzes.volley.AppController;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Avanish Singh on 17/08/2016.
 */
public class QuestionsAdapter extends BaseAdapter {

    private Activity context;
    private LayoutInflater inflater;
    private List<Quiz> feedItems;
    private List<Keys> keyItems;

    //Context context;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public QuestionsAdapter(Activity context, List<Quiz> feedItems, List<Keys> keyItems) {
        this.context = context;
        this.feedItems = feedItems;
        this.keyItems = keyItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.question_layout, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        ImageView thumbNail = (ImageView) convertView
                .findViewById(R.id.image);

        TextView questionNo = (TextView) convertView.findViewById(R.id.questionNo);
        TextView question = (TextView) convertView.findViewById(R.id.question);
        RadioButton answer = (RadioButton)convertView.findViewById(R.id.answer);
    /* NetworkImageView profilePic = (NetworkImageView) convertView
                .findViewById(R.id.image);
*/

      //  DataQuestions item = feedItems.get(position);
        Quiz item = feedItems.get(position);
      //  Glide.with(context).load(item.getQuesImage()).crossFade().fitCenter().into(thumbNail);
       Picasso.with(context).load(item.getQuesImage()).into(thumbNail);
      //  thumbNail.setImageUrl(item.getQuesImage(), imageLoader);
        question.setText(item.getQuestion());

     Keys keyee = keyItems.get(position);
        String k = keyee.getOption();
      answer.setText(k);
       // questionNo.setText(item.getq);

        // Converting timestamp into x ago format
       /* // Chcek for empty status message
        if (!TextUtils.isEmpty(item.getStatus())) {
            statusMsg.setText(item.getStatus());
            statusMsg.setVisibility(View.VISIBLE);
        } else {
            // status is empty, remove from view
            statusMsg.setVisibility(View.GONE);
        }*/

        // Checking for null feed url
       /* if (item.getUrl() != null) {
            url.setText(Html.fromHtml("<a href=\"" + item.getUrl() + "\">"
                    + item.getUrl() + "</a> "));

            // Making url clickable
            url.setMovementMethod(LinkMovementMethod.getInstance());
            url.setVisibility(View.VISIBLE);
        } else {
            // url is null, remove from the view
            url.setVisibility(View.GONE);
        }
*/
        // user profile pic
        //profilePic.setImageUrl(item.getQuesImage(), imageLoader);

        // Feed image


        return convertView;
    }








}


