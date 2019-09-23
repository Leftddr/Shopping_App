package com.example.lg.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import static android.graphics.Color.RED;
import static android.graphics.Color.red;

public class MainActivity extends AppCompatActivity  {
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;
    ImageView imageview4;
    ImageView imageview5;
    ImageView imageview6;
    ImageView imageview7;
    ImageView imageview8;
    ImageView imageview9;
    TextView textview111;TextView textview112;TextView textview113;
    TextView textview121;TextView textview122;TextView textview123;
    TextView textview131;TextView textview132;TextView textview133;
    TextView textview211;TextView textview212;TextView textview213;
    TextView textview221;TextView textview222;TextView textview223;
    TextView textview231;TextView textview232;TextView textview233;
    TextView textview311;TextView textview312;TextView textview313;
    TextView textview321;TextView textview322;TextView textview323;
    TextView textview331;TextView textview332;TextView textview333;
    LinearLayout linear1;LinearLayout linear2;LinearLayout linear3;
    LinearLayout linear4;LinearLayout linear5;LinearLayout linear6;
    LinearLayout linear7;LinearLayout linear8;LinearLayout linear9;
    Button button1;Button button2;Button button3;Button button4;
    EditText edit;
    TextView temp1;
    private DatabaseReference databaseReference;

    int []textviews={R.id.text111,R.id.text121,R.id.text131,R.id.text211,R.id.text221,R.id.text231,R.id.text311,R.id.text321,R.id.text331};
    int MAX_NUM = 9;
    int MAX_TEXT=3;
    int IMAGE_SINGER[]= {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9};
    int IMAGE_ACTOR[]={R.drawable.actor1,R.drawable.actor2,R.drawable.actor3,R.drawable.actor4,R.drawable.actor5,R.drawable.actor6,R.drawable.actor7,R.drawable.actor8,R.drawable.actor9};
    int IMAGE_MODEL[]={R.drawable.model1,R.drawable.model2,R.drawable.model3,R.drawable.model4,R.drawable.model5,R.drawable.model6,R.drawable.model7,R.drawable.model8,R.drawable.model9};
    int random[];
    String [][][]str={{{"수지","가수","자켓"},{"younha","가수","자켓"},{"나연","가수","자켓"}},{{"채영","가수","자켓"},{"쯔위","가수","자켓"},{"정연","가수","자켓"}},{{"지효","가수","자켓"},{"사나","가수","자켓"},{"모모","가수","자켓"}}};
    String [][][]str1={{{"박보영","배우","자켓"},{"고준희","배우","자켓"},{"이하나","배우","자켓"}},{{"문채영","배우","자켓"},{"이다희","배우","자켓"},{"정유미","배우","자켓"}},{{"신혜선","배우","자켓"},{"전소민","배우","자켓"},{"송지효","배우","자켓"}}};
    String [][][]str2={{{"한혜진","모델","자켓"},{"송경아","모델","자켓"},{"이솔","모델","자켓"}},{{"장윤주","모델","자켓"},{"이현이","모델","자켓"},{"강승현","모델","자켓"}},{{"혜박","모델","자켓"},{"황세온","모델","자켓"},{"김원경","모델","자켓"}}};
    final static int SINGER =1;
    final static int ACTOR=2;
    final static int MODEL=0;
    int CRITERIA=1;
    String search;
    String[] URL = {"http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com", "http://m.naver.com"};
    String []SINGER_URL=new String[MAX_NUM];
    String []ACTOR_URL=new String[MAX_NUM];
    String []MODEL_URL=new String[MAX_NUM];
    static int SINGER_CRI=0;
    static int ACTOR_CRI=0;
    static int MODEL_CRI=0;
    int SEARCH_CRI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebstyle);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        imageview1=(ImageView)findViewById(R.id.image1);
        imageview2=(ImageView)findViewById(R.id.image2);
        imageview3=(ImageView)findViewById(R.id.image3);
        imageview4=(ImageView)findViewById(R.id.image4);
        imageview5=(ImageView)findViewById(R.id.image5);
        imageview6=(ImageView)findViewById(R.id.image6);
        imageview7=(ImageView)findViewById(R.id.image7);
        imageview8=(ImageView)findViewById(R.id.image8);
        imageview9=(ImageView)findViewById(R.id.image9);
        textview111=(TextView)findViewById(R.id.text111); textview112=(TextView)findViewById(R.id.text112);textview113=(TextView)findViewById(R.id.text113);
        textview121=(TextView)findViewById(R.id.text121);textview122=(TextView)findViewById(R.id.text122);textview123=(TextView)findViewById(R.id.text123);
        textview131=(TextView)findViewById(R.id.text131);textview132=(TextView)findViewById(R.id.text132);textview133=(TextView)findViewById(R.id.text133);

        textview211=(TextView)findViewById(R.id.text211); textview212=(TextView)findViewById(R.id.text212);textview213=(TextView)findViewById(R.id.text213);
        textview221=(TextView)findViewById(R.id.text221);textview222=(TextView)findViewById(R.id.text222);textview223=(TextView)findViewById(R.id.text223);
        textview231=(TextView)findViewById(R.id.text231);textview232=(TextView)findViewById(R.id.text232);textview233=(TextView)findViewById(R.id.text233);

        textview311=(TextView)findViewById(R.id.text311); textview312=(TextView)findViewById(R.id.text312);textview313=(TextView)findViewById(R.id.text313);
        textview321=(TextView)findViewById(R.id.text321);textview322=(TextView)findViewById(R.id.text322);textview323=(TextView)findViewById(R.id.text323);
        textview331=(TextView)findViewById(R.id.text331);textview332=(TextView)findViewById(R.id.text332);textview333=(TextView)findViewById(R.id.text333);

        linear1=(LinearLayout)findViewById(R.id.linear1); linear2=(LinearLayout)findViewById(R.id.linear2); linear3=(LinearLayout)findViewById(R.id.linear3);
        linear4=(LinearLayout)findViewById(R.id.linear4); linear5=(LinearLayout)findViewById(R.id.linear5); linear6=(LinearLayout)findViewById(R.id.linear6);
        linear7=(LinearLayout)findViewById(R.id.linear7); linear8=(LinearLayout)findViewById(R.id.linear8); linear9=(LinearLayout)findViewById(R.id.linear9);
        button1=(Button)findViewById(R.id.modelButton);button2=(Button)findViewById(R.id.singerButton);button3=(Button)findViewById(R.id.actorButton);button4=(Button)findViewById(R.id.button4);
        edit=(EditText)findViewById(R.id.Edit);
        RandomLayout();
        //SettingUrl();
        Setting_Temp();
    }
    public void RandomLayout(){
        random=new int[MAX_NUM];
        Random r=new Random();
        int cri2;
        for(int cri=0;cri<MAX_NUM;cri++){
            cri2=r.nextInt(9);
            random[cri]=cri2;
            for(int i=0;i<cri;i++){
                if(random[i]==random[cri]){cri--;break;}
            }
        }
        swap();
       setImage();
       setText();
    }
    public void swap() {
        int temp;
        int i;
        String temp1;
        String temp2;
        String temp3;
        for (int cri = 0; cri < MAX_NUM; cri++) {
            i = random[cri];
            if(CRITERIA==1) {
                temp = IMAGE_SINGER[i];
                IMAGE_SINGER[i] = IMAGE_SINGER[cri];
                IMAGE_SINGER[cri] = temp;
            }
            else if(CRITERIA==2){
                temp = IMAGE_ACTOR[i];
                IMAGE_ACTOR[i] = IMAGE_ACTOR[cri];
                IMAGE_ACTOR[cri] = temp;
            }
            else if(CRITERIA==0){
                temp = IMAGE_MODEL[i];
                IMAGE_MODEL[i] = IMAGE_MODEL[cri];
                IMAGE_MODEL[cri] = temp;
            }
            if (i < 3 && cri < 3) {
                temp1 = str[i][i][0];
                temp2 = str[i][i][1];
                temp3 = str[i][i][2];
                str[i][i][0] = str[cri][cri][0];
                str[i][i][1] = str[cri][cri][1];
                str[i][i][2] = str[cri][cri][2];
                str[cri][cri][0] = temp1;
                str[cri][cri][1] = temp2;
                str[cri][cri][2] = temp3;

                temp1 = str1[i][i][0];
                temp2 = str1[i][i][1];
                temp3 = str1[i][i][2];
                str1[i][i][0] = str1[cri][cri][0];
                str1[i][i][1] = str1[cri][cri][1];
                str1[i][i][2] = str1[cri][cri][2];
                str1[cri][cri][0] = temp1;
                str1[cri][cri][1] = temp2;
                str1[cri][cri][2] = temp3;

                temp1 = str2[i][i][0];
                temp2 = str2[i][i][1];
                temp3 = str2[i][i][2];
                str2[i][i][0] = str2[cri][cri][0];
                str2[i][i][1] = str2[cri][cri][1];
                str2[i][i][2] = str2[cri][cri][2];
                str2[cri][cri][0] = temp1;
                str2[cri][cri][1] = temp2;
                str2[cri][cri][2] = temp3;
            }
        }
    }
        public void setImage(){
            if(CRITERIA==1) {
                imageview1.setImageResource(IMAGE_SINGER[0]);
                imageview2.setImageResource(IMAGE_SINGER[1]);
                imageview3.setImageResource(IMAGE_SINGER[2]);
                imageview4.setImageResource(IMAGE_SINGER[3]);
                imageview5.setImageResource(IMAGE_SINGER[4]);
                imageview6.setImageResource(IMAGE_SINGER[5]);
                imageview7.setImageResource(IMAGE_SINGER[6]);
                imageview8.setImageResource(IMAGE_SINGER[7]);
                imageview9.setImageResource(IMAGE_SINGER[8]);
            }
            else if(CRITERIA==2){
                imageview1.setImageResource(IMAGE_ACTOR[0]);
                imageview2.setImageResource(IMAGE_ACTOR[1]);
                imageview3.setImageResource(IMAGE_ACTOR[2]);
                imageview4.setImageResource(IMAGE_ACTOR[3]);
                imageview5.setImageResource(IMAGE_ACTOR[4]);
                imageview6.setImageResource(IMAGE_ACTOR[5]);
                imageview7.setImageResource(IMAGE_ACTOR[6]);
                imageview8.setImageResource(IMAGE_ACTOR[7]);
                imageview9.setImageResource(IMAGE_ACTOR[8]);
            }
            else if(CRITERIA==0){
                imageview1.setImageResource(IMAGE_MODEL[0]);
                imageview2.setImageResource(IMAGE_MODEL[1]);
                imageview3.setImageResource(IMAGE_MODEL[2]);
                imageview4.setImageResource(IMAGE_MODEL[3]);
                imageview5.setImageResource(IMAGE_MODEL[4]);
                imageview6.setImageResource(IMAGE_MODEL[5]);
                imageview7.setImageResource(IMAGE_MODEL[6]);
                imageview8.setImageResource(IMAGE_MODEL[7]);
                imageview9.setImageResource(IMAGE_MODEL[8]);
            }
        }
        public void setText(){
            if(CRITERIA==1) {
                textview111.setText(str[0][0][0]);
                textview112.setText(str[0][0][1]);
                textview113.setText(str[0][0][2]);
                textview121.setText(str[0][1][0]);
                textview122.setText(str[0][1][1]);
                textview123.setText(str[0][1][2]);
                textview131.setText(str[0][2][0]);
                textview132.setText(str[0][2][1]);
                textview133.setText(str[0][2][2]);

                textview211.setText(str[1][0][0]);
                textview212.setText(str[1][0][1]);
                textview213.setText(str[1][0][2]);
                textview221.setText(str[1][1][0]);
                textview222.setText(str[1][1][1]);
                textview223.setText(str[1][1][2]);
                textview231.setText(str[1][2][0]);
                textview232.setText(str[1][2][1]);
                textview233.setText(str[1][2][2]);

                textview311.setText(str[2][0][0]);
                textview312.setText(str[2][0][1]);
                textview313.setText(str[2][0][2]);
                textview321.setText(str[2][1][0]);
                textview322.setText(str[2][1][1]);
                textview323.setText(str[2][1][2]);
                textview331.setText(str[2][2][0]);
                textview332.setText(str[2][2][1]);
                textview333.setText(str[2][2][2]);
            }
            else if(CRITERIA==2){
                textview111.setText(str1[0][0][0]);
                textview112.setText(str1[0][0][1]);
                textview113.setText(str1[0][0][2]);
                textview121.setText(str1[0][1][0]);
                textview122.setText(str1[0][1][1]);
                textview123.setText(str1[0][1][2]);
                textview131.setText(str1[0][2][0]);
                textview132.setText(str1[0][2][1]);
                textview133.setText(str1[0][2][2]);

                textview211.setText(str1[1][0][0]);
                textview212.setText(str1[1][0][1]);
                textview213.setText(str1[1][0][2]);
                textview221.setText(str1[1][1][0]);
                textview222.setText(str1[1][1][1]);
                textview223.setText(str1[1][1][2]);
                textview231.setText(str1[1][2][0]);
                textview232.setText(str1[1][2][1]);
                textview233.setText(str1[1][2][2]);

                textview311.setText(str1[2][0][0]);
                textview312.setText(str1[2][0][1]);
                textview313.setText(str1[2][0][2]);
                textview321.setText(str1[2][1][0]);
                textview322.setText(str1[2][1][1]);
                textview323.setText(str1[2][1][2]);
                textview331.setText(str1[2][2][0]);
                textview332.setText(str1[2][2][1]);
                textview333.setText(str1[2][2][2]);
            }
            else if(CRITERIA==0){
                textview111.setText(str2[0][0][0]);
                textview112.setText(str2[0][0][1]);
                textview113.setText(str2[0][0][2]);
                textview121.setText(str2[0][1][0]);
                textview122.setText(str2[0][1][1]);
                textview123.setText(str2[0][1][2]);
                textview131.setText(str2[0][2][0]);
                textview132.setText(str2[0][2][1]);
                textview133.setText(str2[0][2][2]);

                textview211.setText(str2[1][0][0]);
                textview212.setText(str2[1][0][1]);
                textview213.setText(str2[1][0][2]);
                textview221.setText(str2[1][1][0]);
                textview222.setText(str2[1][1][1]);
                textview223.setText(str2[1][1][2]);
                textview231.setText(str2[1][2][0]);
                textview232.setText(str2[1][2][1]);
                textview233.setText(str2[1][2][2]);

                textview311.setText(str2[2][0][0]);
                textview312.setText(str2[2][0][1]);
                textview313.setText(str2[2][0][2]);
                textview321.setText(str2[2][1][0]);
                textview322.setText(str2[2][1][1]);
                textview323.setText(str2[2][1][2]);
                textview331.setText(str2[2][2][0]);
                textview332.setText(str2[2][2][1]);
                textview333.setText(str2[2][2][2]);
            }
        }
     public void search(){
        int count[]={10,10,10,10,10,10,10,10,10};
        int cri=0;
        int cri2=0;
        for(int i=0;i<MAX_TEXT;i++){
            for(int j=0;j<MAX_TEXT;j++){
                if(CRITERIA==SINGER && search.equals(str[i][j][0])){
                    count[cri]=cri;
                }
                else if(CRITERIA==ACTOR && search.equals(str1[i][j][0])){
                    count[cri]=cri;
                }
                else if(CRITERIA==MODEL && search.equals(str2[i][j][0])){
                    count[cri]=cri;
                }
                cri++;
            }
        }
        cri=0;
        for(int i=0;i<MAX_NUM;i++){
            if(count[i]<10){
                temp1=(TextView)findViewById(textviews[cri]);
                temp1.setTextColor(Color.RED);
                SEARCH_CRI=1;
                cri2++;
            }
            cri++;
        }
        if(cri2==0){Toast.makeText(getApplicationContext(),"찾으시는 검색이 없습니다",Toast.LENGTH_SHORT).show();}
     }
    public void OnClickButton1(View v){
        CRITERIA = 0;
        if(SEARCH_CRI==1) temp1.setTextColor(Color.BLACK);
        SEARCH_CRI=0;
        setImage();
        setText();
    }
    public void OnClickButton2(View v) {
        CRITERIA = 1;
        if(SEARCH_CRI==1) temp1.setTextColor(Color.BLACK);
        SEARCH_CRI=0;
        setImage();
        setText();
    }
    public void OnClickButton3(View v){
        CRITERIA = 2;
        if(SEARCH_CRI==1) temp1.setTextColor(Color.BLACK);

        setImage();
        setText();
    }
    public void OnClickButton4(View v){
        search=edit.getText().toString();
        edit.setText("");
        search();
    }
    public void OnClickLinear1(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[0]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[0]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[0]));
            startActivity(intent);
        }
    }
    public void OnClickLinear2(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[1]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[1]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[1]));
            startActivity(intent);
        }
    }
    public void OnClickLinear3(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[2]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[2]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[2]));
            startActivity(intent);
        }
    }
    public void OnClickLinear4(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[3]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[3]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[3]));
            startActivity(intent);
        }
    }
    public void OnClickLinear5(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[4]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[4]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[4]));
            startActivity(intent);
        }
    }
    public void OnClickLinear6(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[5]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[5]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[5]));
            startActivity(intent);
        }
    }
    public void OnClickLinear7(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[6]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[6]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[6]));
            startActivity(intent);
        }
    }
    public void OnClickLinear8(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[7]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[7]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[7]));
            startActivity(intent);
        }
    }
    public void OnClickLinear9(View v){
        if(CRITERIA==SINGER) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SINGER_URL[8]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ACTOR_URL[8]));
            startActivity(intent);
        }
        else if(CRITERIA==ACTOR){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MODEL_URL[8]));
            startActivity(intent);
        }
    }

    public void SettingUrl() {
        for (int i = 0; i < 9; i++) {
            if (CRITERIA == SINGER) {
                databaseReference.child("SINGERUrlSERVER").push().setValue(URL[i]);
            } else if (CRITERIA == ACTOR) {
                databaseReference.child("ACTORUrlSERVER").push().setValue(URL[i]);
            } else if (CRITERIA == MODEL) {
                databaseReference.child("MODELUrlSERVER").push().setValue(URL[i]);
            }
        }
    }

    public void Setting_Temp(){
        for(int i=0;i<MAX_NUM;i++){
            SINGER_URL[i]="http://m.naver.com";
            ACTOR_URL[i]="http://m.naver.com";
            MODEL_URL[i]="http://m.naver.com";
        }
    }
    public void getUrl() {
        if (CRITERIA == SINGER) {
            databaseReference.child("SINGERUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    SINGER_URL[SINGER_CRI] = dataSnapshot.getValue(String.class);
                    SINGER_CRI++;
                    if(SINGER_CRI>MAX_NUM){SINGER_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    SINGER_URL[SINGER_CRI] = dataSnapshot.getValue(String.class);
                    SINGER_CRI++;
                    if(SINGER_CRI>MAX_NUM){SINGER_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    SINGER_URL[SINGER_CRI] = dataSnapshot.getValue(String.class);
                    SINGER_CRI++;
                    if(SINGER_CRI>MAX_NUM){SINGER_CRI=0;}
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    SINGER_URL[SINGER_CRI] = dataSnapshot.getValue(String.class);
                    SINGER_CRI++;
                    if(SINGER_CRI>MAX_NUM){SINGER_CRI=0;} }

                @Override
                public void onCancelled(DatabaseError databaseError) {Toast.makeText(getApplicationContext(),"수신에 실패했습니다",Toast.LENGTH_LONG).show(); }
            });
        }
        else if (CRITERIA==ACTOR) {
            databaseReference.child("ACTORUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    ACTOR_URL[ACTOR_CRI] = dataSnapshot.getValue(String.class);
                   ACTOR_CRI++;
                    if(ACTOR_CRI>MAX_NUM){ACTOR_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    ACTOR_URL[ACTOR_CRI] = dataSnapshot.getValue(String.class);
                    ACTOR_CRI++;
                    if(ACTOR_CRI>MAX_NUM){ACTOR_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    ACTOR_URL[ACTOR_CRI] = dataSnapshot.getValue(String.class);
                    ACTOR_CRI++;
                    if(ACTOR_CRI>MAX_NUM){ACTOR_CRI=0;}
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    ACTOR_URL[ACTOR_CRI] = dataSnapshot.getValue(String.class);
                    ACTOR_CRI++;
                    if(ACTOR_CRI>MAX_NUM){ACTOR_CRI=0;}
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {Toast.makeText(getApplicationContext(),"수신에 실패했습니다",Toast.LENGTH_LONG).show(); }
            });
        }
        else if (CRITERIA == MODEL) {
            databaseReference.child("MODELUrlSERVER").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    MODEL_URL[MODEL_CRI] = dataSnapshot.getValue(String.class);
                    MODEL_CRI++;
                   if(MODEL_CRI>MAX_NUM){MODEL_CRI=0;}
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    MODEL_URL[MODEL_CRI] = dataSnapshot.getValue(String.class);
                    MODEL_CRI++;
                    if(MODEL_CRI>MAX_NUM){MODEL_CRI=0;}
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    MODEL_URL[MODEL_CRI] = dataSnapshot.getValue(String.class);
                    MODEL_CRI++;
                    if(MODEL_CRI>MAX_NUM){MODEL_CRI=0;}
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    MODEL_URL[MODEL_CRI] = dataSnapshot.getValue(String.class);
                    MODEL_CRI++;
                    if(MODEL_CRI>MAX_NUM){MODEL_CRI=0;}
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {Toast.makeText(getApplicationContext(),"수신에 실패했습니다",Toast.LENGTH_LONG).show();}
            });
        }
    }
}


