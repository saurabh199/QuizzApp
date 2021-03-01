package com.proprofs.proprofsquizzes.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.proprofs.proprofsquizzes.Adapter.CustomAdapter;
import com.proprofs.proprofsquizzes.FeatureAdapter;
import com.proprofs.proprofsquizzes.Interfaces.OnRadioButtonClicked;
import com.proprofs.proprofsquizzes.ListItem;
import com.proprofs.proprofsquizzes.Model.DataQuestionAnswer;
import com.proprofs.proprofsquizzes.Model.QuizItem;
import com.proprofs.proprofsquizzes.ParseResponse;
import com.proprofs.proprofsquizzes.R;
import com.proprofs.proprofsquizzes.RelateItems;
import com.proprofs.proprofsquizzes.volley.AppController;
import com.proprofs.proprofsquizzes.volley.CustomViewDisplay;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sony on 8/26/2016.
 */
public class Fragment_option4  extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private TextView question_number, question,percentage;
    private NetworkImageView question_image,ans_image;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private ListView featured_list, related_list;
    private Bundle bundle;
    ImageLoader imageLoader,ansimage;
    private OnRadioButtonClicked callBack;
    private String QuestionNumber;
    private QuizItem quizItem,quizItem1;
    private RelateItems relateItems;
    private RadioButton[] radioButtons;
    ListView listView,listView1;
    private ArrayList<ListItem> rechargeReports1 = new ArrayList<ListItem>();
    private ArrayList<ListItem> rechargeReports2 = new ArrayList<ListItem>();
    String title,name;
    CustomAdapter customAdapter1;;
    FeatureAdapter customAdapter2;
   // FeatureItems featureItems;
    FragmentTransaction ft;
    TextView textViewView;
    ParseResponse.QuizBean.KeysBean ansimg;
    int whichIndex;
    ProgressBar progressBar;
    private int progressStatus = 0;
    ListItem item;
    private CustomViewDisplay customViewDisplay;
    private static final String TAG = Fragment_option4.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        quizItem = bundle.getParcelable("Data");
        quizItem1 = bundle.getParcelable("quizItem1");
        item = bundle.getParcelable("list");
        System.out.println("item==========="+item);
       // featureItems = bundle.getParcelable("feature");
        System.out.println("quizItem1=========="+quizItem1);
        QuestionNumber = bundle.getString("question_number");
        System.out.println("QuestionNumber============"+QuestionNumber);

        imageLoader = AppController.getInstance().getImageLoader();
        System.out.println("imageLoader======="+imageLoader);

        ansimage = AppController.getInstance().getImageLoader();
        System.out.println("ansimage======"+ansimage);

        callBack = (OnRadioButtonClicked) getActivity();

       //   relateItems = bundle.getParcelable("relateItems");
      //  System.out.println("relateItems==========--------000000000000"+relateItems);

}
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        name = getArguments().getString("name");
        View view = inflater.inflate(R.layout.questions_layouts, null);
       // listView = (ListView) view.findViewById(R.id.listting);
   //     listView1 = (ListView) view.findViewById(R.id.listt);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

      //  textViewView = (TextView) view.findViewById(R.id.percentage);
          findIds(view);
              init();
        try {
            File httpCacheDir = new File(getActivity().getCacheDir(), "http");
            long httpCacheSize = 10 * 1024 * 1024; // 10 MiB
            HttpResponseCache.install(httpCacheDir, httpCacheSize);
        } catch (IOException e) {
            Log.i(TAG, "HTTP response cache installation failed:" + e);
        }
        //getActivity().onBackPressed();
       // overridePendingTransition(R.animator.right_to_left, R.animator.left_to_right);
//new MobileOperator().execute();
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {

        double total = bundle.getInt("total_question_number");
        double ques = bundle.getInt("questio");
        double result = 100 / total *ques;
        System.out.println("-------------"+result);
        question.setText(bundle.getString("question"));
       percentage.setText(""+ Math.round(result) + "%");
       //  question_number.setText("" + Math.round(100 / bundle.getInt("total_question_number") * bundle.getInt("question_number"))   + "%");
        customViewDisplay.sendvalue(Math.round(450 / bundle.getInt("total_question_number") * bundle.getInt("questio")));
        question.setText(quizItem.Question);
        question_number.setText(bundle.getString("question_number"));
        question_number.setText(bundle.getString("question_number"));

     //   textViewView.setText(bundle.getString(""));
     //   Picasso.with(getActivity()).load(featureItems.featuredImage).into(imageView);
        if (quizItem.QuestionImageUrl.equals(" ")) {
            String image = null;
            question_image.setImageUrl(image, imageLoader);
        } else {
            question_image.setImageUrl(quizItem.QuestionImageUrl, imageLoader);

        }
        question_image.setImageUrl(quizItem.QuestionImageUrl,imageLoader);
        Picasso.with(getActivity()).load((quizItem.AnsImage)).into(ans_image);
        int options = quizItem.MyKeys.size();
        /*if (quizItem.MyKeys.isEmpty()) {
            String ims= null;
            ans_image.setImageUrl(ims, ansimage);

        } else {
           ans_image.setImageUrl(ansimg.getAnsImage(),ansimage);
         //   quizItem.QuestionImageUrl
        }*/
        for (int i = 0; i < options; i++) {
            RadioButton radioButtons = new RadioButton(getActivity());
            radioButtons.setText(quizItem.MyKeys.get(i).getOption());
            radioButtons.setTag(quizItem.MyKeys.get(i).getAnswerId());
        //    radioButtons.setCompoundDrawables(quizItem.MyKeys.get(i).getAnsImage());
            // radioButtons.setForeground(Drawable.createFromPath(quizItem.MyKeys.get(i).getAnsImage()));
            //     radioButtons.setButtonDrawable(Integer.parseInt(quizItem.MyKeys.get(i).getAnsImage()));
            //    ans_image.setImageUrl(quizItem.MyKeys.get(i).getAnsImage(), ansimage);
            // radioButtons.setText(quizItem.MyKeys.get(i).getAnsImage());
            radioButtons.setPadding(20, 10, 10, 10);
            radioButtons.setOnCheckedChangeListener(this);
            radioButtons.setTextSize(18);
            radioButtons.setGravity(Gravity.TOP);
            radioButtons.setBackground(Drawable.createFromPath("#000000"));
            radioGroup.addView(radioButtons);
        }
    }
   /* private void ProgressStatus()
    {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }*/
    private void findIds(View view) {
        question = (TextView) view.findViewById(R.id.question);
        question_number = (TextView) view.findViewById(R.id.question_number);
        question_image = (NetworkImageView) view.findViewById(R.id.question_image);
        percentage = (TextView) view.findViewById(R.id.percentage);
        ans_image = (NetworkImageView) view.findViewById(R.id.ans_image);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioButtons);
        customViewDisplay = (CustomViewDisplay) view.findViewById(R.id.customViewShow);
         //textViewView = (TextView) view.findViewById(R.id.text5);
        // featured_list =(ListView)view.findViewById(R.id.featured_list);
        // related_list = (ListView)view.findViewById(R.id.related_list);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        DataQuestionAnswer dataQuestionAnswer = new DataQuestionAnswer(quizItem.QuestionId, new String[]{compoundButton.getTag().toString()});
        if (b) {
            callBack.onClicked(dataQuestionAnswer);

            System.out.println("whichIndex==========="+whichIndex);
        }
    }
}
