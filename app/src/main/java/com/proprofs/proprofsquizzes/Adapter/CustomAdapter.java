package com.proprofs.proprofsquizzes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.proprofs.proprofsquizzes.ParseResponse;
import com.proprofs.proprofsquizzes.R;
import com.proprofs.proprofsquizzes.volley.AppController;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avanish Singh on 25/08/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private List<ParseResponse.QuizBean> nQuizitem;
     private Context mContext;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomAdapter(Context mContext, List<ParseResponse.QuizBean> nQuizitem) {
        this.mContext = mContext;
        this.nQuizitem = nQuizitem;
    }

    @Override
    public int getCount() {
        return nQuizitem.size();
    }

    @Override
    public Object getItem(int position) {
        return nQuizitem.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.question_layout, null);

        ParseResponse.QuizBean item = (ParseResponse.QuizBean) getItem(position);

        ImageView thumbNail = (ImageView) view
                .findViewById(R.id.image);

        TextView questionNo = (TextView) view.findViewById(R.id.questionNo);
        TextView question = (TextView) view.findViewById(R.id.question);
        RadioButton answer = (RadioButton)view.findViewById(R.id.answer);

        question.setText(item.getQuestion());
        String q = item.getQuestion();
        System.out.println("qqqqqqqqqqqqqq  "+q);

        Picasso.with(mContext).load(item.getQuesImage()).into(thumbNail);
        List kk = item.getKeys();

        answer.setText(item.getKeys().toString());













        return view;
    }
}
