package com.myinform2.lg.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    Button Myinform_button1;
    Button Myinform_button2;
    Button Myinform_button3;
    ImageView Myinformimage1;
    ImageView Myinformimage2;
    ImageView Myinformimage3;
    ImageView Myinformimage4;
    ImageView Myinformimage5;
    ImageView Myinformimage6;
    ImageView Myinformimage7;
    ImageView Myinformimage8;
    ImageView Myinformimage9;
    LayoutInflater Myinform_inflater;
    ScrollView Myinform_container;
    LinearLayout linearLayout1; LinearLayout linearLayout2; LinearLayout linearLayout3;

    TextView Myinform_textview111;
    TextView Myinform_textview112;
    TextView Myinform_textview113;
    TextView Myinform_textview121;
    TextView Myinform_textview122;
    TextView Myinform_textview123;
    TextView Myinform_textview131;
    TextView Myinform_textview132;
    TextView Myinform_textview133;
    TextView Myinform_textview211;
    TextView Myinform_textview212;
    TextView Myinform_textview213;
    TextView Myinform_textview221;
    TextView Myinform_textview222;
    TextView Myinform_textview223;
    TextView Myinform_textview231;
    TextView Myinform_textview232;
    TextView Myinform_textview233;
    TextView Myinform_textview311;
    TextView Myinform_textview312;
    TextView Myinform_textview313;
    TextView Myinform_textview321;
    TextView Myinform_textview322;
    TextView Myinform_textview323;
    TextView Myinform_textview331;
    TextView Myinform_textview332;
    TextView Myinform_textview333;
    TextView textview;
    int RECOMMEND_CODI[] = {R.drawable.actor1, R.drawable.actor2, R.drawable.actor3, R.drawable.actor4, R.drawable.actor5, R.drawable.actor6, R.drawable.actor7, R.drawable.actor8, R.drawable.actor9};
    int RECOMMEND_CELEB[] = {R.drawable.model1, R.drawable.model1, R.drawable.model3, R.drawable.model4, R.drawable.model5, R.drawable.model6, R.drawable.model7, R.drawable.model8, R.drawable.model9};
    int RECOMMEND_BRAND[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9};

    String[][][] Myinform_str = {{{"수지", "가수", "자켓"}, {"younha", "가수", "자켓"}, {"나연", "가수", "자켓"}}, {{"채영", "가수", "자켓"}, {"쯔위", "가수", "자켓"}, {"정연", "가수", "자켓"}}, {{"지효", "가수", "자켓"}, {"사나", "가수", "자켓"}, {"모모", "가수", "자켓"}}};
    String[][][] Myinform_str1 = {{{"박보영", "배우", "자켓"}, {"고준희", "배우", "자켓"}, {"이하나", "배우", "자켓"}}, {{"문채영", "배우", "자켓"}, {"이다희", "배우", "자켓"}, {"정유미", "배우", "자켓"}}, {{"신혜선", "배우", "자켓"}, {"전소민", "배우", "자켓"}, {"송지효", "배우", "자켓"}}};
    String[][][] Myinform_str2 = {{{"한혜진", "모델", "자켓"}, {"송경아", "모델", "자켓"}, {"이솔", "모델", "자켓"}}, {{"장윤주", "모델", "자켓"}, {"이현이", "모델", "자켓"}, {"강승현", "모델", "자켓"}}, {{"혜박", "모델", "자켓"}, {"황세온", "모델", "자켓"}, {"김원경", "모델", "자켓"}}};

    final static int RECOMMENDCODI = 0;
    final static int RECOMMENDCELEB = 1;
    final static int RECOMMENDBRAND = 2;
    int MYINFORM_CRI;
    int CHECKED = 0;
    int USER_DATANUM = 0;
    String[] URL = {"http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com"};
    String[] CODI_URL=new String[9];
    String[] CELEB_URL=new String[9];
    String[] BRAND_URL=new String[9];
    static int CODI_CRI=0;
    static int CELEB_CRI=0;
    static int BRAND_CRI=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinform);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Myinform_container = (ScrollView) findViewById(R.id.Myinform_container);
        Myinform_inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        textview = (TextView) findViewById(R.id.TextView);
        Myinform_button1 = (Button) findViewById(R.id.Recommend_style);
        Myinform_button2 = (Button) findViewById(R.id.Recommend_celeb);
        Myinform_button3 = (Button) findViewById(R.id.Recommend_brand);
        linearLayout1=(LinearLayout)findViewById(R.id.Myinform_Layout1);
        linearLayout2=(LinearLayout)findViewById(R.id.Myinform_Layout2);
        linearLayout3=(LinearLayout)findViewById(R.id.Myinform_Layout3);
        //SettingUrl();  //앱처리로 인한 주석 처리
        Setting_Temp();
    }

    public void Setting_Image() {
        if (MYINFORM_CRI == RECOMMENDCODI) {
            Myinformimage1.setImageResource(RECOMMEND_CODI[0]);
            Myinformimage2.setImageResource(RECOMMEND_CODI[1]);
            Myinformimage3.setImageResource(RECOMMEND_CODI[2]);
            Myinformimage4.setImageResource(RECOMMEND_CODI[3]);
            Myinformimage5.setImageResource(RECOMMEND_CODI[4]);
            Myinformimage6.setImageResource(RECOMMEND_CODI[5]);
            Myinformimage7.setImageResource(RECOMMEND_CODI[6]);
            Myinformimage8.setImageResource(RECOMMEND_CODI[7]);
            Myinformimage9.setImageResource(RECOMMEND_CODI[8]);
        } else if (MYINFORM_CRI == RECOMMENDCELEB) {
            Myinformimage1.setImageResource(RECOMMEND_CELEB[0]);
            Myinformimage2.setImageResource(RECOMMEND_CELEB[1]);
            Myinformimage3.setImageResource(RECOMMEND_CELEB[2]);
            Myinformimage4.setImageResource(RECOMMEND_CELEB[3]);
            Myinformimage5.setImageResource(RECOMMEND_CELEB[4]);
            Myinformimage6.setImageResource(RECOMMEND_CELEB[5]);
            Myinformimage7.setImageResource(RECOMMEND_CELEB[6]);
            Myinformimage8.setImageResource(RECOMMEND_CELEB[7]);
            Myinformimage9.setImageResource(RECOMMEND_CELEB[8]);
        } else if (MYINFORM_CRI == RECOMMENDBRAND) {
            Myinformimage1.setImageResource(RECOMMEND_BRAND[0]);
            Myinformimage2.setImageResource(RECOMMEND_BRAND[1]);
            Myinformimage3.setImageResource(RECOMMEND_BRAND[2]);
            Myinformimage4.setImageResource(RECOMMEND_BRAND[3]);
            Myinformimage5.setImageResource(RECOMMEND_BRAND[4]);
            Myinformimage6.setImageResource(RECOMMEND_BRAND[5]);
            Myinformimage7.setImageResource(RECOMMEND_BRAND[6]);
            Myinformimage8.setImageResource(RECOMMEND_BRAND[7]);
            Myinformimage9.setImageResource(RECOMMEND_BRAND[8]);
        }
    }

    public void Setting_Text() {
        if (MYINFORM_CRI == RECOMMENDCODI) {
            Myinform_textview111.setText(Myinform_str[0][0][0]);
            Myinform_textview112.setText(Myinform_str[0][0][1]);
            Myinform_textview113.setText(Myinform_str[0][0][2]);
            Myinform_textview121.setText(Myinform_str[0][1][0]);
            Myinform_textview122.setText(Myinform_str[0][1][1]);
            Myinform_textview123.setText(Myinform_str[0][1][2]);
            Myinform_textview131.setText(Myinform_str[0][2][0]);
            Myinform_textview132.setText(Myinform_str[0][2][1]);
            Myinform_textview133.setText(Myinform_str[0][2][2]);

            Myinform_textview211.setText(Myinform_str[1][0][0]);
            Myinform_textview212.setText(Myinform_str[1][0][1]);
            Myinform_textview213.setText(Myinform_str[1][0][2]);
            Myinform_textview221.setText(Myinform_str[1][1][0]);
            Myinform_textview222.setText(Myinform_str[1][1][1]);
            Myinform_textview223.setText(Myinform_str[1][1][2]);
            Myinform_textview231.setText(Myinform_str[1][2][0]);
            Myinform_textview232.setText(Myinform_str[1][2][1]);
            Myinform_textview233.setText(Myinform_str[1][2][2]);

            Myinform_textview311.setText(Myinform_str[2][0][0]);
            Myinform_textview312.setText(Myinform_str[2][0][1]);
            Myinform_textview313.setText(Myinform_str[2][0][2]);
            Myinform_textview321.setText(Myinform_str[2][1][0]);
            Myinform_textview322.setText(Myinform_str[2][1][1]);
            Myinform_textview323.setText(Myinform_str[2][1][2]);
            Myinform_textview331.setText(Myinform_str[2][2][0]);
            Myinform_textview332.setText(Myinform_str[2][2][1]);
            Myinform_textview333.setText(Myinform_str[2][2][2]);
        } else if (MYINFORM_CRI == RECOMMENDCELEB) {
            Myinform_textview111.setText(Myinform_str1[0][0][0]);
            Myinform_textview112.setText(Myinform_str1[0][0][1]);
            Myinform_textview113.setText(Myinform_str1[0][0][2]);
            Myinform_textview121.setText(Myinform_str1[0][1][0]);
            Myinform_textview122.setText(Myinform_str1[0][1][1]);
            Myinform_textview123.setText(Myinform_str1[0][1][2]);
            Myinform_textview131.setText(Myinform_str1[0][2][0]);
            Myinform_textview132.setText(Myinform_str1[0][2][1]);
            Myinform_textview133.setText(Myinform_str1[0][2][2]);

            Myinform_textview211.setText(Myinform_str1[1][0][0]);
            Myinform_textview212.setText(Myinform_str1[1][0][1]);
            Myinform_textview213.setText(Myinform_str1[1][0][2]);
            Myinform_textview221.setText(Myinform_str1[1][1][0]);
            Myinform_textview222.setText(Myinform_str1[1][1][1]);
            Myinform_textview223.setText(Myinform_str1[1][1][2]);
            Myinform_textview231.setText(Myinform_str1[1][2][0]);
            Myinform_textview232.setText(Myinform_str1[1][2][1]);
            Myinform_textview233.setText(Myinform_str1[1][2][2]);

            Myinform_textview311.setText(Myinform_str1[2][0][0]);
            Myinform_textview312.setText(Myinform_str1[2][0][1]);
            Myinform_textview313.setText(Myinform_str1[2][0][2]);
            Myinform_textview321.setText(Myinform_str1[2][1][0]);
            Myinform_textview322.setText(Myinform_str1[2][1][1]);
            Myinform_textview323.setText(Myinform_str1[2][1][2]);
            Myinform_textview331.setText(Myinform_str1[2][2][0]);
            Myinform_textview332.setText(Myinform_str1[2][2][1]);
            Myinform_textview333.setText(Myinform_str1[2][2][2]);
        } else if (MYINFORM_CRI == RECOMMENDBRAND) {
            Myinform_textview111.setText(Myinform_str2[0][0][0]);
            Myinform_textview112.setText(Myinform_str2[0][0][1]);
            Myinform_textview113.setText(Myinform_str2[0][0][2]);
            Myinform_textview121.setText(Myinform_str2[0][1][0]);
            Myinform_textview122.setText(Myinform_str2[0][1][1]);
            Myinform_textview123.setText(Myinform_str2[0][1][2]);
            Myinform_textview131.setText(Myinform_str2[0][2][0]);
            Myinform_textview132.setText(Myinform_str2[0][2][1]);
            Myinform_textview133.setText(Myinform_str2[0][2][2]);

            Myinform_textview211.setText(Myinform_str2[1][0][0]);
            Myinform_textview212.setText(Myinform_str2[1][0][1]);
            Myinform_textview213.setText(Myinform_str2[1][0][2]);
            Myinform_textview221.setText(Myinform_str2[1][1][0]);
            Myinform_textview222.setText(Myinform_str2[1][1][1]);
            Myinform_textview223.setText(Myinform_str2[1][1][2]);
            Myinform_textview231.setText(Myinform_str2[1][2][0]);
            Myinform_textview232.setText(Myinform_str2[1][2][1]);
            Myinform_textview233.setText(Myinform_str2[1][2][2]);

            Myinform_textview311.setText(Myinform_str2[2][0][0]);
            Myinform_textview312.setText(Myinform_str2[2][0][1]);
            Myinform_textview313.setText(Myinform_str2[2][0][2]);
            Myinform_textview321.setText(Myinform_str2[2][1][0]);
            Myinform_textview322.setText(Myinform_str2[2][1][1]);
            Myinform_textview323.setText(Myinform_str2[2][1][2]);
            Myinform_textview331.setText(Myinform_str2[2][2][0]);
            Myinform_textview332.setText(Myinform_str2[2][2][1]);
            Myinform_textview333.setText(Myinform_str2[2][2][2]);
        }
    }

    public void Setting_Id() {
        Myinformimage1 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image1);
        Myinformimage2 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image2);
        Myinformimage3 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image3);
        Myinformimage4 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image4);
        Myinformimage5 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image5);
        Myinformimage6 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image6);
        Myinformimage7 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image7);
        Myinformimage8 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image8);
        Myinformimage9 = (ImageView) Myinform_container.findViewById(R.id.Myinform_image9);

        Myinform_textview111 = (TextView) Myinform_container.findViewById(R.id.Myinform_text111);
        Myinform_textview112 = (TextView) Myinform_container.findViewById(R.id.Myinform_text112);
        Myinform_textview113 = (TextView) Myinform_container.findViewById(R.id.Myinform_text113);
        Myinform_textview121 = (TextView) Myinform_container.findViewById(R.id.Myinform_text121);
        Myinform_textview122 = (TextView) Myinform_container.findViewById(R.id.Myinform_text122);
        Myinform_textview123 = (TextView) Myinform_container.findViewById(R.id.Myinform_text123);
        Myinform_textview131 = (TextView) Myinform_container.findViewById(R.id.Myinform_text131);
        Myinform_textview132 = (TextView) Myinform_container.findViewById(R.id.Myinform_text132);
        Myinform_textview133 = (TextView) Myinform_container.findViewById(R.id.Myinform_text133);

        Myinform_textview211 = (TextView) Myinform_container.findViewById(R.id.Myinform_text211);
        Myinform_textview212 = (TextView) Myinform_container.findViewById(R.id.Myinform_text212);
        Myinform_textview213 = (TextView) Myinform_container.findViewById(R.id.Myinform_text213);
        Myinform_textview221 = (TextView) Myinform_container.findViewById(R.id.Myinform_text221);
        Myinform_textview222 = (TextView) Myinform_container.findViewById(R.id.Myinform_text222);
        Myinform_textview223 = (TextView) Myinform_container.findViewById(R.id.Myinform_text223);
        Myinform_textview231 = (TextView) Myinform_container.findViewById(R.id.Myinform_text231);
        Myinform_textview232 = (TextView) Myinform_container.findViewById(R.id.Myinform_text232);
        Myinform_textview233 = (TextView) Myinform_container.findViewById(R.id.Myinform_text233);

        Myinform_textview311 = (TextView) Myinform_container.findViewById(R.id.Myinform_text311);
        Myinform_textview312 = (TextView) Myinform_container.findViewById(R.id.Myinform_text312);
        Myinform_textview313 = (TextView) Myinform_container.findViewById(R.id.Myinform_text313);
        Myinform_textview321 = (TextView) Myinform_container.findViewById(R.id.Myinform_text321);
        Myinform_textview322 = (TextView) Myinform_container.findViewById(R.id.Myinform_text322);
        Myinform_textview323 = (TextView) Myinform_container.findViewById(R.id.Myinform_text323);
        Myinform_textview331 = (TextView) Myinform_container.findViewById(R.id.Myinform_text331);
        Myinform_textview332 = (TextView) Myinform_container.findViewById(R.id.Myinform_text332);
        Myinform_textview333 = (TextView) Myinform_container.findViewById(R.id.Myinform_text333);
    }

    public void Setting_Myinform() {
        if (CHECKED == 0) {
            Myinform_inflater.inflate(R.layout.myinformsub, Myinform_container);
            Setting_Id();
            CHECKED++;
        }
        Setting_Image();
        Setting_Text();
        if (USER_DATANUM > 0) {
            Myinform_container.setVisibility(View.VISIBLE);
            textview.setVisibility(View.INVISIBLE);
        } else {
            Myinform_container.setVisibility(View.INVISIBLE);
            textview.setVisibility(View.VISIBLE);
        }
    }

    public void MyinformCODIclicked(View v) {
        MYINFORM_CRI = 0;
        USER_DATANUM=1;
        linearLayout1.setBackgroundColor(0xffffbbaa);
        linearLayout2.setBackgroundColor(Color.WHITE);
        linearLayout3.setBackgroundColor(Color.WHITE);
        Setting_Myinform();
        SettingUrl();
    }

    public void MyinformCELEBclicked(View v) {
        MYINFORM_CRI = 1;
        USER_DATANUM = 1;
        linearLayout2.setBackgroundColor(0xffffbbaa);
        linearLayout1.setBackgroundColor(Color.WHITE);
        linearLayout3.setBackgroundColor(Color.WHITE);
        Setting_Myinform();
        SettingUrl();
    }

    public void MyinformBRANDclicked(View v) {
        MYINFORM_CRI = 2;
        USER_DATANUM = 0;
        linearLayout3.setBackgroundColor(0xffffbbaa);
        linearLayout2.setBackgroundColor(Color.WHITE);
        linearLayout1.setBackgroundColor(Color.WHITE);
        Setting_Myinform();
        SettingUrl();
    }

    public void Myinform_OnClickLinear1(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[0]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[0]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[0]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear2(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[1]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[1]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[1]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear3(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[2]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[2]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[2]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear4(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[3]));
        startActivity(intent);
    }
    else if(MYINFORM_CRI==RECOMMENDCELEB){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[3]));
        startActivity(intent);
    }
    else if(MYINFORM_CRI==RECOMMENDBRAND){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[3]));
        startActivity(intent);
    }}
    public void Myinform_OnClickLinear5(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[4]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[4]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[4]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear6(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[5]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[5]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[5]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear7(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[6]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[6]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[6]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear8(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[7]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[7]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[7]));
            startActivity(intent);
        }
    }
    public void Myinform_OnClickLinear9(View v){
        if(MYINFORM_CRI==RECOMMENDCODI) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CODI_URL[8]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDCELEB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CELEB_URL[8]));
            startActivity(intent);
        }
        else if(MYINFORM_CRI==RECOMMENDBRAND){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BRAND_URL[8]));
            startActivity(intent);
        }
    }

    public void SettingUrl() {
            for (int i = 0; i < 9; i++) {
                if (MYINFORM_CRI == RECOMMENDCODI) {
                    databaseReference.child("CODIUrlSERVER").push().setValue(URL[i]);
                } else if (MYINFORM_CRI == RECOMMENDCELEB) {
                    databaseReference.child("CELEBUrlSERVER").push().setValue(URL[i]);
                } else if (MYINFORM_CRI == RECOMMENDBRAND) {
                    databaseReference.child("BRANDUrlSERVER").push().setValue(URL[i]);
                }
                USER_DATANUM++;
            }
    }

    public void Setting_Temp(){
        for(int i=0;i<9;i++){
            CODI_URL[i]="http://m.naver.com";
            CELEB_URL[i]="http://m.naver.com";
            BRAND_URL[i]="http://m.naver.com";
        }
    }

    public void getUrl() {
        if (MYINFORM_CRI == RECOMMENDCODI) {
            databaseReference.child("CODIUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    CODI_URL[CODI_CRI] = dataSnapshot.getValue(String.class);
                    CODI_CRI++;
                    if(CODI_CRI>9){CODI_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    CODI_URL[CODI_CRI] = dataSnapshot.getValue(String.class);
                    CODI_CRI++;
                    if(CODI_CRI>9){CODI_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    CODI_URL[CODI_CRI] = dataSnapshot.getValue(String.class);
                    CODI_CRI++;
                    if(CODI_CRI>9){CODI_CRI=0;}
                    USER_DATANUM--;
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    CODI_URL[CODI_CRI] = dataSnapshot.getValue(String.class);
                    CODI_CRI++;
                    if(CODI_CRI>9){CODI_CRI=0;}
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"수신에 실패했습니다.",Toast.LENGTH_LONG).show();
                }
            });
        }
        else if (MYINFORM_CRI == RECOMMENDCELEB) {
            databaseReference.child("CELEBUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    CELEB_URL[CELEB_CRI] = dataSnapshot.getValue(String.class);
                    CELEB_CRI++;
                    if(CELEB_CRI>9){CELEB_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    CELEB_URL[CELEB_CRI] = dataSnapshot.getValue(String.class);
                    CELEB_CRI++;
                    if(CELEB_CRI>9){CELEB_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    CELEB_URL[CELEB_CRI] = dataSnapshot.getValue(String.class);
                    CELEB_CRI++;
                    if(CELEB_CRI>9){CELEB_CRI=0;}
                    USER_DATANUM--;
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    CELEB_URL[CELEB_CRI] = dataSnapshot.getValue(String.class);
                    CELEB_CRI++;
                    if(CELEB_CRI>9){CELEB_CRI=0;}
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"수신에 실패했습니다.",Toast.LENGTH_LONG).show();
                }
            });
        }
        else if (MYINFORM_CRI == RECOMMENDBRAND) {
            databaseReference.child("BRANDUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    BRAND_URL[BRAND_CRI] = dataSnapshot.getValue(String.class);
                    BRAND_CRI++;
                    if(BRAND_CRI>9){BRAND_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    BRAND_URL[BRAND_CRI] = dataSnapshot.getValue(String.class);
                    BRAND_CRI++;
                    if(BRAND_CRI>9){BRAND_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    BRAND_URL[BRAND_CRI] = dataSnapshot.getValue(String.class);
                    BRAND_CRI++;
                    if(BRAND_CRI>9){BRAND_CRI=0;}
                    USER_DATANUM--;
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    BRAND_URL[BRAND_CRI] = dataSnapshot.getValue(String.class);
                    BRAND_CRI++;
                    if(BRAND_CRI>9){BRAND_CRI=0;}
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"수신에 실패했습니다.",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

