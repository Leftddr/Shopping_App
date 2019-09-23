package com.example.lg.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button ShoppingButton1; Button ShoppingButton2; Button ShoppingButton3; Button ShoppingButton4; Button ShoppingButton5; Button ShoppingButton6;
    ImageView Shoppingimage1; ImageView Shoppingimage2; ImageView Shoppingimage3;ImageView Shoppingimage4; ImageView Shoppingimage5; ImageView Shoppingimage6;
    ImageView Shoppingimage7; ImageView Shoppingimage8; ImageView Shoppingimage9;
    FrameLayout container; FrameLayout Topcontainer;
    private DatabaseReference databaseReference;

    TextView Shopping_textview111;TextView Shopping_textview112;TextView Shopping_textview113;
    TextView Shopping_textview121;TextView Shopping_textview122;TextView Shopping_textview123;
    TextView Shopping_textview131;TextView Shopping_textview132;TextView Shopping_textview133;
    TextView Shopping_textview211;TextView Shopping_textview212;TextView Shopping_textview213;
    TextView Shopping_textview221;TextView Shopping_textview222;TextView Shopping_textview223;
    TextView Shopping_textview231;TextView Shopping_textview232;TextView Shopping_textview233;
    TextView Shopping_textview311;TextView Shopping_textview312;TextView Shopping_textview313;
    TextView Shopping_textview321;TextView Shopping_textview322;TextView Shopping_textview323;
    TextView Shopping_textview331;TextView Shopping_textview332;TextView Shopping_textview333;
    TextView Shopping_textview;

    int SHOPPING_IMAGE[]={R.drawable.actor1,R.drawable.actor2,R.drawable.actor3,R.drawable.actor4,R.drawable.actor5,R.drawable.actor6,R.drawable.actor7,R.drawable.actor8,R.drawable.actor9};
    String [][][]Shopping_str1={{{"한혜진","모델","자켓"},{"송경아","모델","자켓"},{"이솔","모델","자켓"}},{{"장윤주","모델","자켓"},{"이현이","모델","자켓"},{"강승현","모델","자켓"}},{{"혜박","모델","자켓"},{"황세온","모델","자켓"},{"김원경","모델","자켓"}}};
    int CRITERIA_SHOPPING;
    LayoutInflater inflater;
    final static int DAY=1;
    final static int WEEK=2;
    final static int MONTH=3;
    final static int THREE_MONTH=4;
    final static int SIX_MONTH=5;
    final static int PAST=1;
    final static int NO=0;
    static int PURCHASE_CRI=0;
    int DataNum=1;
    static int Check=0;
    String []DAYPURCHASE_URL=new String[9];
    String []WEEKPURCHASE_URL=new String[9];
    String []MONTHPURCHASE_URL=new String[9];
    String []THREEMONTHPURCHASE_URL=new String[9];
    String []SIXMONTHPURCHASE_URL=new String[9];
    String []YEARPURCHASE_URL=new String[9];
    static int DAYPURCHASE_CRI=0;
    static int WEEKPURCHASE_CRI=0;
    static int MONTHPURCHASE_CRI=0;
    static int THREEMONTHPURCHASE_CRI=0;
    static int SIXMONTHPURCHASE_CRI=0;
    static int YEARPURCHASE_CRI=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshopping);

        container=(FrameLayout)findViewById(R.id.container);
        Topcontainer=(FrameLayout)findViewById(R.id.Topcontainer);
        //databaseReference = FirebaseDatabase.getInstance().getReference();
        inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ShoppingButton1=(Button)findViewById(R.id.Shopping_button1);
        ShoppingButton2=(Button)findViewById(R.id.Shopping_button2);
        ShoppingButton3=(Button)findViewById(R.id.Shopping_button3);
        ShoppingButton4=(Button)findViewById(R.id.Shopping_button4);
        ShoppingButton5=(Button)findViewById(R.id.Shopping_button5);
        ShoppingButton6=(Button)findViewById(R.id.Shopping_button6);

        Shoppingimage1=(ImageView)container.findViewById(R.id.Shopping_image1);Shoppingimage2=(ImageView)container.findViewById(R.id.Shopping_image2);
        Shoppingimage3=(ImageView)container.findViewById(R.id.Shopping_image3);Shoppingimage4=(ImageView)container.findViewById(R.id.Shopping_image4);
        Shoppingimage5=(ImageView)container.findViewById(R.id.Shopping_image5);Shoppingimage6=(ImageView)container.findViewById(R.id.Shopping_image6);
        Shoppingimage7=(ImageView)container.findViewById(R.id.Shopping_image7);Shoppingimage8=(ImageView)container.findViewById(R.id.Shopping_image8);
        Shoppingimage9=(ImageView)container.findViewById(R.id.Shopping_image9);

        Shopping_textview111=(TextView)container.findViewById(R.id.Shopping_text111); Shopping_textview112=(TextView)container.findViewById(R.id.Shopping_text112);Shopping_textview113=(TextView)container.findViewById(R.id.Shopping_text113);
        Shopping_textview121=(TextView)container.findViewById(R.id.Shopping_text121);Shopping_textview122=(TextView)container.findViewById(R.id.Shopping_text122);Shopping_textview123=(TextView)container.findViewById(R.id.Shopping_text123);
        Shopping_textview131=(TextView)container.findViewById(R.id.Shopping_text131);Shopping_textview132=(TextView)container.findViewById(R.id.Shopping_text132);Shopping_textview133=(TextView)container.findViewById(R.id.Shopping_text133);

        Shopping_textview211=(TextView)container.findViewById(R.id.Shopping_text211); Shopping_textview212=(TextView)container.findViewById(R.id.Shopping_text212);Shopping_textview213=(TextView)container.findViewById(R.id.Shopping_text213);
        Shopping_textview221=(TextView)container.findViewById(R.id.Shopping_text221);Shopping_textview222=(TextView)container.findViewById(R.id.Shopping_text222);Shopping_textview223=(TextView)container.findViewById(R.id.Shopping_text223);
        Shopping_textview231=(TextView)container.findViewById(R.id.Shopping_text231);Shopping_textview232=(TextView)container.findViewById(R.id.Shopping_text232);Shopping_textview233=(TextView)container.findViewById(R.id.Shopping_text233);

        Shopping_textview311=(TextView)container.findViewById(R.id.Shopping_text311); Shopping_textview312=(TextView)container.findViewById(R.id.Shopping_text312);Shopping_textview313=(TextView)container.findViewById(R.id.Shopping_text313);
        Shopping_textview321=(TextView)container.findViewById(R.id.Shopping_text321);Shopping_textview322=(TextView)container.findViewById(R.id.Shopping_text322);Shopping_textview323=(TextView)container.findViewById(R.id.Shopping_text323);
        Shopping_textview331=(TextView)container.findViewById(R.id.Shopping_text331);Shopping_textview332=(TextView)container.findViewById(R.id.Shopping_text332);Shopping_textview333=(TextView)container.findViewById(R.id.Shopping_text333);
        Shopping_textview=(TextView)findViewById(R.id.Shopping_text);
        Setting_Temp();
    }

    public void Check() {
        if (CRITERIA_SHOPPING != NO && DataNum>0) {
            container.setVisibility(View.VISIBLE);
            Shopping_textview.setVisibility(View.INVISIBLE);
            if(Check==0) inflater.inflate(R.layout.activity_shopping_sub, container);
            Shoppingimage1 = (ImageView) container.findViewById(R.id.Shopping_image1);
            Shoppingimage2 = (ImageView) container.findViewById(R.id.Shopping_image2);
            Shoppingimage3 = (ImageView) container.findViewById(R.id.Shopping_image3);
            Shoppingimage4 = (ImageView) container.findViewById(R.id.Shopping_image4);
            Shoppingimage5 = (ImageView) container.findViewById(R.id.Shopping_image5);
            Shoppingimage6 = (ImageView) container.findViewById(R.id.Shopping_image6);
            Shoppingimage7 = (ImageView) container.findViewById(R.id.Shopping_image7);
            Shoppingimage8 = (ImageView) container.findViewById(R.id.Shopping_image8);
            Shoppingimage9 = (ImageView) container.findViewById(R.id.Shopping_image9);

            Shopping_textview111 = (TextView) container.findViewById(R.id.Shopping_text111);
            Shopping_textview112 = (TextView) container.findViewById(R.id.Shopping_text112);
            Shopping_textview113 = (TextView) container.findViewById(R.id.Shopping_text113);
            Shopping_textview121 = (TextView) container.findViewById(R.id.Shopping_text121);
            Shopping_textview122 = (TextView) container.findViewById(R.id.Shopping_text122);
            Shopping_textview123 = (TextView) container.findViewById(R.id.Shopping_text123);
            Shopping_textview131 = (TextView) container.findViewById(R.id.Shopping_text131);
            Shopping_textview132 = (TextView) container.findViewById(R.id.Shopping_text132);
            Shopping_textview133 = (TextView) container.findViewById(R.id.Shopping_text133);

            Shopping_textview211 = (TextView) container.findViewById(R.id.Shopping_text211);
            Shopping_textview212 = (TextView) container.findViewById(R.id.Shopping_text212);
            Shopping_textview213 = (TextView) container.findViewById(R.id.Shopping_text213);
            Shopping_textview221 = (TextView) container.findViewById(R.id.Shopping_text221);
            Shopping_textview222 = (TextView) container.findViewById(R.id.Shopping_text222);
            Shopping_textview223 = (TextView) container.findViewById(R.id.Shopping_text223);
            Shopping_textview231 = (TextView) container.findViewById(R.id.Shopping_text231);
            Shopping_textview232 = (TextView) container.findViewById(R.id.Shopping_text232);
            Shopping_textview233 = (TextView) container.findViewById(R.id.Shopping_text233);

            Shopping_textview311 = (TextView) container.findViewById(R.id.Shopping_text311);
            Shopping_textview312 = (TextView) container.findViewById(R.id.Shopping_text312);
            Shopping_textview313 = (TextView) container.findViewById(R.id.Shopping_text313);
            Shopping_textview321 = (TextView) container.findViewById(R.id.Shopping_text321);
            Shopping_textview322 = (TextView) container.findViewById(R.id.Shopping_text322);
            Shopping_textview323 = (TextView) container.findViewById(R.id.Shopping_text323);
            Shopping_textview331 = (TextView) container.findViewById(R.id.Shopping_text331);
            Shopping_textview332 = (TextView) container.findViewById(R.id.Shopping_text332);
            Shopping_textview333 = (TextView) container.findViewById(R.id.Shopping_text333);
            Check =1;
        }
        else if(DataNum==0){
            container.setVisibility(View.INVISIBLE);
            Shopping_textview.setVisibility(View.VISIBLE);
        }
    }

    public void Shopping_setImage(){
        Shoppingimage1.setImageResource(SHOPPING_IMAGE[0]);
        Shoppingimage2.setImageResource(SHOPPING_IMAGE[1]);
        Shoppingimage3.setImageResource(SHOPPING_IMAGE[2]);
        Shoppingimage4.setImageResource(SHOPPING_IMAGE[3]);
        Shoppingimage5.setImageResource(SHOPPING_IMAGE[4]);
        Shoppingimage6.setImageResource(SHOPPING_IMAGE[5]);
        Shoppingimage7.setImageResource(SHOPPING_IMAGE[6]);
        Shoppingimage8.setImageResource(SHOPPING_IMAGE[7]);
        Shoppingimage9.setImageResource(SHOPPING_IMAGE[8]);
    }
    public void Shopping_setText(){
        Shopping_textview111.setText(Shopping_str1[0][0][0]);
        Shopping_textview112.setText(Shopping_str1[0][0][1]);
        Shopping_textview113.setText(Shopping_str1[0][0][2]);
        Shopping_textview121.setText(Shopping_str1[0][1][0]);
        Shopping_textview122.setText(Shopping_str1[0][1][1]);
        Shopping_textview123.setText(Shopping_str1[0][1][2]);
        Shopping_textview131.setText(Shopping_str1[0][2][0]);
        Shopping_textview132.setText(Shopping_str1[0][2][1]);
        Shopping_textview133.setText(Shopping_str1[0][2][2]);

        Shopping_textview211.setText(Shopping_str1[1][0][0]);
        Shopping_textview212.setText(Shopping_str1[1][0][1]);
        Shopping_textview213.setText(Shopping_str1[1][0][2]);
        Shopping_textview221.setText(Shopping_str1[1][1][0]);
        Shopping_textview222.setText(Shopping_str1[1][1][1]);
        Shopping_textview223.setText(Shopping_str1[1][1][2]);
        Shopping_textview231.setText(Shopping_str1[1][2][0]);
        Shopping_textview232.setText(Shopping_str1[1][2][1]);
        Shopping_textview233.setText(Shopping_str1[1][2][2]);

        Shopping_textview311.setText(Shopping_str1[2][0][0]);
        Shopping_textview312.setText(Shopping_str1[2][0][1]);
        Shopping_textview313.setText(Shopping_str1[2][0][2]);
        Shopping_textview321.setText(Shopping_str1[2][1][0]);
        Shopping_textview322.setText(Shopping_str1[2][1][1]);
        Shopping_textview323.setText(Shopping_str1[2][1][2]);
        Shopping_textview331.setText(Shopping_str1[2][2][0]);
        Shopping_textview332.setText(Shopping_str1[2][2][1]);
        Shopping_textview333.setText(Shopping_str1[2][2][2]);
    }
    public void Shopping_Button1(View v){
        CRITERIA_SHOPPING=1;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_Button2(View v){
        CRITERIA_SHOPPING=2;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_Button3(View v){
        CRITERIA_SHOPPING=3;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_Button4(View v){
        CRITERIA_SHOPPING=4;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_Button5(View v){
        CRITERIA_SHOPPING=5;
        DataNum=0;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_Button6(View v){
        CRITERIA_SHOPPING=6;
        DataNum=1;
        Check();
        Shopping_setImage();
        Shopping_setText();
    }
    public void Shopping_OnClickLinear1(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[0]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[0]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[0]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[0]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[0]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[0]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear2(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[1]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[1]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[1]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[1]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[1]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[1]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear3(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[2]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[2]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[2]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[2]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[2]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[2]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear4(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[3]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[3]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[3]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[3]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[3]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[3]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear5(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[4]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[4]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[4]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[4]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[4]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[4]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear6(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[5]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[5]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[5]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[5]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[5]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[5]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear7(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[6]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[6]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[6]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[6]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[6]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[6]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear8(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[7]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[7]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[7]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[7]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[7]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[7]));
            startActivity(intent);
        }
    }
    public void Shopping_OnClickLinear9(View v){
        if(PURCHASE_CRI==DAY) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(DAYPURCHASE_URL[8]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==WEEK){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEEKPURCHASE_URL[8]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MONTHPURCHASE_URL[8]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==THREE_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(THREEMONTHPURCHASE_URL[8]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==SIX_MONTH){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SIXMONTHPURCHASE_URL[8]));
            startActivity(intent);
        }
        else if(PURCHASE_CRI==PAST){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YEARPURCHASE_URL[8]));
            startActivity(intent);
        }
    }
    public void Setting_Temp(){
        for(int i=0;i<9;i++){
            DAYPURCHASE_URL[i]="http://m.naver.com";
            WEEKPURCHASE_URL[i]="http://m.naver.com";
            MONTHPURCHASE_URL[i]="http://m.naver.com";
            THREEMONTHPURCHASE_URL[i]="http://m.naver.com";
            SIXMONTHPURCHASE_URL[i]="http://m.naver.com";
            YEARPURCHASE_URL[i]="http://m.naver.com";
        }
    }
    public void Myinform_GettingURL(){
        databaseReference.child("DAYPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DAYPURCHASE_URL[PURCHASE_CRI] = dataSnapshot.getValue(String.class);
                DAYPURCHASE_CRI++;
                if(DAYPURCHASE_CRI>9){DAYPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DAYPURCHASE_URL[PURCHASE_CRI] = dataSnapshot.getValue(String.class);
                DAYPURCHASE_CRI++;
                if(DAYPURCHASE_CRI>9){DAYPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                DAYPURCHASE_URL[PURCHASE_CRI] = dataSnapshot.getValue(String.class);
                DAYPURCHASE_CRI++;
                if(DAYPURCHASE_CRI>9){DAYPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DAYPURCHASE_URL[DAYPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                DAYPURCHASE_CRI++;
                if(DAYPURCHASE_CRI>9){DAYPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference.child("WEEKPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WEEKPURCHASE_URL[WEEKPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                WEEKPURCHASE_CRI++;
                if(WEEKPURCHASE_CRI>9){WEEKPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WEEKPURCHASE_URL[PURCHASE_CRI] = dataSnapshot.getValue(String.class);
                WEEKPURCHASE_CRI++;
                if(WEEKPURCHASE_CRI>9){WEEKPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                WEEKPURCHASE_URL[WEEKPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                WEEKPURCHASE_CRI++;
                if(WEEKPURCHASE_CRI>9){WEEKPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WEEKPURCHASE_URL[WEEKPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                WEEKPURCHASE_CRI++;
                if(WEEKPURCHASE_CRI>9){WEEKPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference.child("MONTHPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MONTHPURCHASE_URL[MONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                MONTHPURCHASE_CRI++;
                if(MONTHPURCHASE_CRI>9){MONTHPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MONTHPURCHASE_URL[MONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                MONTHPURCHASE_CRI++;
                if(MONTHPURCHASE_CRI>9){MONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                MONTHPURCHASE_URL[MONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                MONTHPURCHASE_CRI++;
                if(MONTHPURCHASE_CRI>9){MONTHPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MONTHPURCHASE_URL[MONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                MONTHPURCHASE_CRI++;
                if(MONTHPURCHASE_CRI>9){MONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference.child("THREEMONTHPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                THREEMONTHPURCHASE_URL[THREEMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                THREEMONTHPURCHASE_CRI++;
                if(THREEMONTHPURCHASE_CRI>9){THREEMONTHPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                THREEMONTHPURCHASE_URL[THREEMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                THREEMONTHPURCHASE_CRI++;
                if(THREEMONTHPURCHASE_CRI>9){THREEMONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                THREEMONTHPURCHASE_URL[THREEMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                THREEMONTHPURCHASE_CRI++;
                if(THREEMONTHPURCHASE_CRI>9){THREEMONTHPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                THREEMONTHPURCHASE_URL[THREEMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                THREEMONTHPURCHASE_CRI++;
                if(THREEMONTHPURCHASE_CRI>9){THREEMONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference.child("SIXMONTHPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SIXMONTHPURCHASE_URL[SIXMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                SIXMONTHPURCHASE_CRI++;
                if(SIXMONTHPURCHASE_CRI>9){SIXMONTHPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SIXMONTHPURCHASE_URL[SIXMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                SIXMONTHPURCHASE_CRI++;
                if(SIXMONTHPURCHASE_CRI>9){SIXMONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                SIXMONTHPURCHASE_URL[SIXMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                SIXMONTHPURCHASE_CRI++;
                if(SIXMONTHPURCHASE_CRI>9){SIXMONTHPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SIXMONTHPURCHASE_URL[SIXMONTHPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                SIXMONTHPURCHASE_CRI++;
                if(SIXMONTHPURCHASE_CRI>9){SIXMONTHPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference.child("YEARPURCHASE_URL").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                YEARPURCHASE_URL[YEARPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                YEARPURCHASE_CRI++;
                if(YEARPURCHASE_CRI>9){YEARPURCHASE_CRI=0;}
                DataNum++;
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                YEARPURCHASE_URL[YEARPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                YEARPURCHASE_CRI++;
                if(YEARPURCHASE_CRI>9){YEARPURCHASE_CRI=0;}
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                YEARPURCHASE_URL[YEARPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                YEARPURCHASE_CRI++;
                if(YEARPURCHASE_CRI>9){YEARPURCHASE_CRI=0;}
                DataNum--;
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                YEARPURCHASE_URL[YEARPURCHASE_CRI] = dataSnapshot.getValue(String.class);
                YEARPURCHASE_CRI++;
                if(YEARPURCHASE_CRI>9){YEARPURCHASE_CRI=0;}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"수신되지 않았습니다",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
