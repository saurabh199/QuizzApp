package com.proprofs.proprofsquizzes;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.proprofs.proprofsquizzes.Adapter.CustomAdapter;
import com.proprofs.proprofsquizzes.Adapter.QuestionsAdapter;
import com.proprofs.proprofsquizzes.Fragment.Fragment_option4;
import com.proprofs.proprofsquizzes.Fragment.ResponseFragment;
import com.proprofs.proprofsquizzes.Interfaces.OnRadioButtonClicked;
import com.proprofs.proprofsquizzes.Model.DataQuestionAnswer;
import com.proprofs.proprofsquizzes.Model.Keys;
import com.proprofs.proprofsquizzes.Model.Quiz;
import com.proprofs.proprofsquizzes.Model.QuizItem;
import com.proprofs.proprofsquizzes.Model.QuizResult;
import com.proprofs.proprofsquizzes.volley.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Shubham Jain on 27-09-2016.
 */

public class QuizMAin extends AppCompatActivity implements OnRadioButtonClicked {
    ParseResponse responseObj;
    private QuizResult quizResult;
    com.google.gson.Gson gson;
    AsyncHttpClient client;
    private static final String TAG = MainActivity.class.getSimpleName();
    String url = null;
    private ProgressDialog pDialog;
    ListView listView;
    int MY_SOCKET_TIMEOUT_MS = 30000;
    private QuestionsAdapter adapter;
    ArrayList<Quiz> datalol = new ArrayList<>();
    ArrayList<Keys> datakey = new ArrayList<>();
    private Fragment currentFragment;
    private Fragment responseFragment;
    private int questionCounter = 0;
    String titles = null;
    String quizTitle = null;
    ProgressBar progressBar;
    CustomAdapter customAdapter1;
    String image= "";
    FeatureAdapter customAdapter2;
    private ArrayList<ListItem> rechargeReports1 = new ArrayList<ListItem>();
    private ArrayList<ListItem> rechargeReports2 = new ArrayList<ListItem>();
    ParseResponse.QuizBean quizBean;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;
    Toolbar toolbar;
    ListItem listItem;
    //  private UiLifecycleHelper uiHelper;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizmain_layout);

        //  overridePendingTransition(R.animator.right_to_left, R.animator.left_to_right);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));
        Intent intent = getIntent();
        titles = intent.getStringExtra("title");
        System.out.println("titles------------------------------------------" + titles);

        quizTitle = intent.getStringExtra("quizTitle");
        System.out.println("quizTitle------------------------------------------" + quizTitle);
       /* uiHelper = new UiLifecycleHelper(this, null);
        uiHelper.onCreate(savedInstanceState);*/

//        setSupportActionBar(toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);

        ab.setTitle(quizTitle);

        //ab.setIcon(R.drawable.logo);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3EAAF5")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        listView = (ListView) findViewById(R.id.list);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //  new MobileOperator().execute();
        progressBar = new ProgressBar(this);
        //  listView = (ListView)findViewById(R.id.listView);
       // url = "http://www.proprofs.com/quiz-school/mobileData/request.php?request=QuizStart&module=handShake&title=" + titles;
        url = "http://www.proprofs.com/quiz-school/mobileData/request.php?request=QuizStart&module=handShake&title=pq-which-little-mermaid-character-are-you_3SY";
        client = new AsyncHttpClient();
        client.get(QuizMAin.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String resposestr = new String(responseBody);
                    System.out.println("resposestr==========" + resposestr);

                    gson = new Gson();
                    responseObj = gson.fromJson(resposestr, ParseResponse.class);
                    Log.d(TAG, "key  " + responseObj.getQuiz());
                    Log.d(TAG, resposestr.toString());
                    ParseResponse.QuizBean quizBean = responseObj.getQuiz().get(questionCounter);

                    ParseResponse.RelatedBean relatedBean = responseObj.getRelated().get(questionCounter);
                    QuizItem quizItem1 = new QuizItem(relatedBean.getRelatedName(), relatedBean.getRelatedImage(), relatedBean.getRelatedTitle());
                    //ParseResponse.RelatedBean relatedBean = (ParseResponse.RelatedBean) responseObj.getRelated();
//                ParseResponse.FeaturedBean featuredBean = (ParseResponse.FeaturedBean) responseObj.getFeatured();
                    quizResult = new QuizResult();
                    quizResult.setQuizStartTime(System.currentTimeMillis());
                    quizResult.setQuizId(String.valueOf(quizBean.getQuizId()));
                    currentFragment = new Fragment_option4();
                    Bundle info = new Bundle();

                    info.putString("questio", "" + (questionCounter + 1) + "/" + responseObj.getQuiz().size());
                    info.putInt("questio", (questionCounter + 1));
                    info.putInt("total_question_number", responseObj.getQuiz().size());
                    info.putString("question_number", "" + (questionCounter + 1) + "/" + responseObj.getQuiz().size());
                    QuizItem quizItem = new QuizItem(quizBean.getQuestion(), quizBean.getQuesImage(), quizBean.getQuestionId(), (ArrayList<ParseResponse.QuizBean.KeysBean>) quizBean.getKeys(),
                            quizBean.getType(), quizBean.getIndex());
                    //    listItem = new ListItem(listItem.getRelatedName(),listItem.getRelatedImage(),listItem.getRelatedTitle());

                    //     QuizItem quizItem1 = new QuizItem(relatedBean.getRelatedName(),relatedBean.getRelatedImage(),relatedBean.getRelatedTitle());
                    // FeatureItems featureItems = new FeatureItems(featuredBean.getFeaturedName(),featuredBean.getFeaturedImage(),featuredBean.getFeaturedTitle());
                    // RelateItems relateItems = new RelateItems(relatedBean.getRelatedName(), relatedBean.getRelatedImage(), relatedBean.getRelatedTitle());
                    info.putParcelable("Data", quizItem);
                    info.putParcelable("quizItem1", quizItem1);
                    //      info.putParcelable("list", (Parcelable) listItem);
                    // info.putParcelable("Data",quizItem1);
                    //    info.putParcelable("featureItems",featureItems);
                    //  info.putParcelable("feature",featureItems);
                    //info.putParcelable("relate", relateItems);
                    info.putString("title", titles);
                    int localCounter = 1;
                    if (savedInstanceState == null) {
                        currentFragment.setArguments(info);
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            fragmentTransaction.add(R.id.container_layout, currentFragment, "CurrentFragment" + questionCounter).commitAllowingStateLoss();
                        }
                    } else {
                        Log.d(TAG, "savedInstanceState not null");
                    }
                }catch (NullPointerException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
        try {
            File httpCacheDir = new File(getApplicationContext().getCacheDir(), "http");
            long httpCacheSize = 10 * 1024 * 1024; // 10 MiB
            HttpResponseCache.install(httpCacheDir, httpCacheSize);

        } catch (IOException e) {
            Log.i(TAG, "HTTP response cache installation failed:" + e);

        }
        //  new MobileOperator().execute();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
        //   uiHelper.onDestroy();
    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    @Override
    public void onClicked(DataQuestionAnswer dataQuestionAnswer) {
        Log.d(TAG, "questionId :" + dataQuestionAnswer.questionId);
        Log.d(TAG, "answerIds :" + dataQuestionAnswer.answerIds[0]);
        quizResult.insertDataInList(dataQuestionAnswer);
        quizResult.setQuizEndTime(System.currentTimeMillis());
        questionCounter++;
        JSONObject responsetoPost = quizResult.getResultInJsonFormat();
        System.out.println("responsetoPost=============" + responsetoPost);
        if (questionCounter == responseObj.getQuiz().size()) {
            Log.d(TAG, "questionCounter:" + questionCounter);
            Log.d(TAG, "responsetoPost " + responsetoPost);
            String urlPost = "http://www.proprofs.com/quiz-school/mobileData/request.php?request=QuizTotal&module=PQ";
          final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPost, responsetoPost,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG, "response " + response);

                            System.out.println("response=========================="+response);
                            try {

                               /* JSONObject jobj = new JSONObject(line);
                                if (jobj.getJSONArray("edges").length() == 0) {

                                    System.out.println("JSONArray is null");
                                }
                                else{
                                    System.out.println("JSONArray is not null");
                                    //parse your string here
                                }
                                                                                                                                                                                                                                                                                                                                                                                             */
                                // Parsing json object response
                                // response will be a json object
                                JSONObject jsonObject = new JSONObject(String.valueOf(response));
                                System.out.println("jsonObject========================" + jsonObject);

                                JSONObject ja = response.getJSONObject("personality");
                                   //System.out.println("ja========================"+ja);
                                    String desc = ja.getString("desc");
                                    System.out.println("desc=============" + desc);
                                    String title = ja.getString("title");
                                    System.out.println("title=============" + title);
                                    image = ja.getString("image");
                                    System.out.println("image=============" + image);
                                    String rating = jsonObject.getString("rating");
                                    System.out.println("rating=============" + rating);
                                    Log.d(TAG, "desc:" + desc);
                                    // String rating = ja.getString("rating");
                                    // System.out.println("rating========================"+rating);
                                    // String image = response.getString("image");

                                    responseFragment = new ResponseFragment();

                                    Bundle info = new Bundle();
                                    info.putString("title", title);
                                    info.putString("desc", desc);
                                    info.putString("image", image);
                                    info.putString("rating", rating);
                                    info.putString("titles", titles);
                                    responseFragment.setArguments(info);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().
                                            setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                                    fragmentTransaction.replace(R.id.container_layout, responseFragment, "responseFragment").commit();

                            } catch(JSONException e){
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(),
                                        "Error: " + e.getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
            progressBar.setVisibility(View.GONE);
            return;
        }
        if (responseObj.getQuiz().size() > questionCounter) {
            ParseResponse.QuizBean quizBean = responseObj.getQuiz().get(questionCounter);
//        ParseResponse.FeaturedBean featuredBean = (ParseResponse.FeaturedBean) responseObj.getFeatured();
            //  ParseResponse.RelatedBean relatedBean = (ParseResponse.RelatedBean) responseObj.getRelated();
            currentFragment = new Fragment_option4();

            Bundle info = new Bundle();
            info.putString("question_number", "" + (questionCounter + 1) + "/" + responseObj.getQuiz().size());

            info.putString("questio", "" + (questionCounter + 1) + "/" + responseObj.getQuiz().size());
           info.putInt("questio", questionCounter +1);
            info.putInt("total_question_number", responseObj.getQuiz().size());
            QuizItem quizItem = new QuizItem(quizBean.getQuestion(), quizBean.getQuesImage(), quizBean.getQuestionId(), (ArrayList<ParseResponse.QuizBean.KeysBean>) quizBean.getKeys(),
                    quizBean.getType(), quizBean.getIndex());
            //   FeatureItems featureItems = new FeatureItems(featuredBean.getFeaturedName(),featuredBean.getFeaturedImage(),featuredBean.getFeaturedTitle());

            // String name = featuredBean.getFeaturedName();
            // String image = featuredBean.getFeaturedImage();
            //   String title = featuredBean.getFeaturedTitle();
            //   ArrayList<String> fe = new ArrayList<>();
            //   fe.add(name);
            //   fe.add(image);
            //  fe.add(title);
          //  listItem = new ListItem(listItem.getRelatedName(),listItem.getRelatedImage(),listItem.getRelatedTitle());

            //RelateItems relateItems = new RelateItems(relatedBean.getRelatedName(),relatedBean.getRelatedImage(),relatedBean.getRelatedTitle());
            info.putParcelable("Data", quizItem);
         //   info.putParcelable("list", (Parcelable) listItem);
            //  info.putParcelable("featureItems",featureItems);
            //  info.putString("name",name);
            // info.putParcelable("fe",featureItems);

            //    info.putString("relateItems","relateItems");
            currentFragment.setArguments(info);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            //   overridePendingTransition(R.animator.right_to_left, R.animator.left_to_right);
            fragmentTransaction.replace(R.id.container_layout, currentFragment, "CurrentFragment" + questionCounter).commit();

        }

    }
    @Override
    public void onClicked(boolean b) {

    }
}
