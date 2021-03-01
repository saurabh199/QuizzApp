package com.proprofs.proprofsquizzes.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;
import com.proprofs.proprofsquizzes.Adapter.CustomAdapter;
import com.proprofs.proprofsquizzes.FeatureAdapter;
import com.proprofs.proprofsquizzes.ListItem;
import com.proprofs.proprofsquizzes.R;
import com.proprofs.proprofsquizzes.volley.AppController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 9/18/2016.
 */
public class ResponseFragment extends Fragment {
    private TextView responseText;
    private NetworkImageView ne;
    private Bundle bundle;
    ImageLoader imageLoader;
    String loader;
    String responsetext;
    TextView textView;
    String titlesss;
    String rating;
    RatingBar rate;
    Button button;
    Button facebook, what, twitter, share;

    String title;
    ProgressBar progressBar;
    ListView listView, listview1,listview2;
    ImageView responseImage;
    private ArrayList<ListItem> rechargeReports = new ArrayList<ListItem>();
    private ArrayList<ListItem> rechargeReports1 = new ArrayList<ListItem>();
    private ArrayList<ListItem> rechargeReports2 = new ArrayList<ListItem>();
   // ListViewAdapter customAdapter;
    CustomAdapter customAdapter1;
    FeatureAdapter customAdapter2;
    ShareDialog shareDialog;
    Button whart;
    //FacebookSdk.sdkInitialize(Activity.this);
    //shareDialog = new ShareDialog(act);

    public static String FACEBOOK_PAGE_ID = "YourPageName";
    Context context;
    CallbackManager callbackmanager;
    private LoginManager loginManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
      
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        responsetext = bundle.getString("desc");
        titlesss = bundle.getString("title");
        loader = bundle.getString("image");
        rating = bundle.getString("rating");
        imageLoader = AppController.getInstance().getImageLoader();
        title = bundle.getString("titles");
        System.out.println("title--------------------------------"+title);
        String uri="http://www.proprofs.com/quiz-school/story.php?title=" + title;
        // question_image.setImageUrl(quizItem.QuestionImageUrl,imageLoader);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.final_main1, null);

        FaceBookSDKIntialize();
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
//       progressBar.setVisibility(View.VISIBLE);
        facebook = (Button) view.findViewById(R.id.face);
        twitter = (Button) view.findViewById(R.id.twitter);
         whart = (Button) view.findViewById(R.id.what);
        responseText = (TextView) view.findViewById(R.id.resposeText);
        responseText.setText(responsetext);
        textView = (TextView) view.findViewById(R.id.titles);
        textView.setText(titlesss);
        share = (Button) view.findViewById(R.id.share);
        //   responseImage = (NetworkImageView) view.findViewById(R.id.responseImage);
        //  responseImage.setImageUrl(loader, imageLoader);
        responseImage = (ImageView) view.findViewById(R.id.grid_item_image);
        Glide.with(getActivity()).load(loader).into(responseImage);
        //rate = (RatingBar) view.findViewById(R.id.rating);
        // rate.setRating(Float.parseFloat(rating));
        findIds(view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
               /* Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);*/
                //progressBar.setVisibility(View.GONE);
                // close this activity
                //finish();
            }
        }, 2000);
        //  ScrollView scrollView = (ScrollView) view.findViewById(R.id.scroll);
        // scrollView.setFocusableInTouchMode(true);
        //  scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        init();
        //  progressBar.setVisibility(View.GONE);
        //  public static String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
//method to get the right URL to use in the intent
        final String uri = ("https://www.proprofs.com/quiz-school/story.php?title=" + title);

        whart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri imageUri = Uri.parse("https://www.proprofs.com/quiz-school/story.php?title=" + title);
                Intent Intent = new Intent();
                Intent.setAction(Intent.ACTION_SEND);
                Intent.setPackage("com.whatsapp");
              //  Intent.putExtra(Intent.EXTRA_TEXT, picture_text);
                Intent.putExtra(Intent.EXTRA_TEXT, uri);
                Intent.setType("text/plain");
                Intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                try {
                    startActivity(Intent);
                } catch (android.content.ActivityNotFoundException ex) {
                   // ToastHelper.MakeShortText("Whatsapp not installed.");
                }

               /* Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");

                //  sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);*/
                //startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, uri);
                sharingIntent.setPackage("com.facebook.katana");
                startActivity(sharingIntent);
               /* Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, uri);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));*/
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT,uri);
        tweetIntent.setType("text/plain");
        PackageManager packManager = getActivity().getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent,  PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for(ResolveInfo resolveInfo: resolvedInfoList){
            if(resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")){
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name );
                resolved = true;
                break;
            }
        }
        if(resolved){
            startActivity(tweetIntent);
        }else{
            //Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }
    }
});
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, uri);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            }
        });
        button = (Button) view.findViewById(R.id.button);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), QuizActivity.class);
                in.putExtra("title",title);
                startActivity(in);
            }
        });*/
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return view;
    }

    private void FaceBookSDKIntialize() {
        FacebookSdk.sdkInitialize(getActivity());
        callbackmanager = CallbackManager.Factory.create();
    }
    private void findIds(View view) {
       // responseImage = (ImageView) view.findViewById(R.id.responseImage);
        responseText = (TextView) view.findViewById(R.id.resposeText);
    }
    private void init() {
        //responseText.setText(bundle.getString("desc"));
//        responseText.setText(responsetext);
        // responseImage.setImageUrl(imageurl,);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
//    public String getFacebookPageURL(Context context) {
//        PackageManager packageManager = context.getPackageManager();
//        try {
//            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
//            if (versionCode >= 3002850) { //newer versions of fb app
//                return "http://www.facebook.com/" + titlesss;
//            } else { //older versions of fb app
//                return "fb://page/" + FACEBOOK_PAGE_ID;
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            return uri; //normal web url
//        }
  //  }
        }
