package com.myinform2.lg.myapplication12;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ImageView Event_image1;ImageView Event_image2;ImageView Event_image3;ImageView Event_image4;ImageView Event_image5;ImageView Event_image6;

    TextView Event_text111;TextView Event_text112;TextView Event_text113;
    TextView Event_text211;TextView Event_text212;TextView Event_text213;
    TextView Event_text311;TextView Event_text312;TextView Event_text313;
    TextView Event_text411;TextView Event_text412;TextView Event_text413;
    TextView Event_text511;TextView Event_text512;TextView Event_text513;
    TextView Event_text611;TextView Event_text612;TextView Event_text613;

    private DatabaseReference databaseReference;
    int []Event_image={R.drawable.event1,R.drawable.event2,R.drawable.event3,R.drawable.event4,R.drawable.event5,R.drawable.event6};
    String[][][]Event_text={{{"1+1","더싸다구","11/22~11/25"},{"2+2","fp","11/22~12/20"},{"2+2","fp","11/22~12/20"}},{{"2+2","fp","11/22~12/20"},{"2+2","fp","11/22~12/20"},{"2+2","fp","11/22~12/20"}}};
    String []Event_Url={"http://m.naver.com","http://m.naver.com","http://m.naver.com","http://m.naver.com","http://m.naver.com","http://m.naver.com"};
    String []Event_getUrl=new String[9];
    static int Event_CRI=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //databaseReference = FirebaseDatabase.getInstance().getReference();
        Event_image1=(ImageView)findViewById(R.id.Event_image1);Event_image2=(ImageView)findViewById(R.id.Event_image2);Event_image3=(ImageView)findViewById(R.id.Event_image3);
        Event_image4=(ImageView)findViewById(R.id.Event_image4);Event_image5=(ImageView)findViewById(R.id.Event_image5);Event_image6=(ImageView)findViewById(R.id.Event_image6);

        Event_text111=(TextView)findViewById(R.id.Event_text111);Event_text112=(TextView)findViewById(R.id.Event_text112);Event_text113=(TextView)findViewById(R.id.Event_text113);
        Event_text211=(TextView)findViewById(R.id.Event_text211);Event_text212=(TextView)findViewById(R.id.Event_text212);Event_text213=(TextView)findViewById(R.id.Event_text213);
        Event_text311=(TextView)findViewById(R.id.Event_text311);Event_text312=(TextView)findViewById(R.id.Event_text312);Event_text313=(TextView)findViewById(R.id.Event_text313);
        Event_text411=(TextView)findViewById(R.id.Event_text411);Event_text412=(TextView)findViewById(R.id.Event_text412);Event_text413=(TextView)findViewById(R.id.Event_text413);
        Event_text511=(TextView)findViewById(R.id.Event_text511);Event_text512=(TextView)findViewById(R.id.Event_text512);Event_text513=(TextView)findViewById(R.id.Event_text513);
        Event_text611=(TextView)findViewById(R.id.Event_text611);Event_text612=(TextView)findViewById(R.id.Event_text612);Event_text613=(TextView)findViewById(R.id.Event_text613);
       // Event_SettingUrl();
        Setting_Temp();
        Setting_Event_image();
        Setting_Event_text();
    }

    public void Setting_Event_image(){
        Event_image1.setImageResource(Event_image[0]); Event_image2.setImageResource(Event_image[1]); Event_image3.setImageResource(Event_image[2]);
        Event_image4.setImageResource(Event_image[4]); Event_image5.setImageResource(Event_image[4]); Event_image6.setImageResource(Event_image[5]);
    }
    public void Setting_Event_text(){
        Event_text111.setText(Event_text[0][0][0]); Event_text112.setText(Event_text[0][0][1]); Event_text113.setText(Event_text[0][0][2]);
        Event_text211.setText(Event_text[0][1][0]); Event_text212.setText(Event_text[0][1][1]); Event_text213.setText(Event_text[0][1][2]);
        Event_text311.setText(Event_text[0][2][0]); Event_text312.setText(Event_text[0][2][1]); Event_text313.setText(Event_text[0][2][2]);
        Event_text411.setText(Event_text[1][0][0]); Event_text412.setText(Event_text[1][0][1]); Event_text413.setText(Event_text[1][0][2]);
        Event_text511.setText(Event_text[1][1][0]); Event_text512.setText(Event_text[1][1][1]); Event_text513.setText(Event_text[1][1][2]);
        Event_text611.setText(Event_text[1][2][0]); Event_text612.setText(Event_text[1][2][1]); Event_text613.setText(Event_text[1][2][2]);
    }
    public void Event_linear1(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[0]));
        startActivity(intent);
    }
    public void Event_linear2(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[1]));
        startActivity(intent);
    }
    public void Event_linear3(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[2]));
        startActivity(intent);
    }
    public void Event_linear4(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[3]));
        startActivity(intent);
    }
    public void Event_linear5(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[4]));
        startActivity(intent);
    }
    public void Event_linear6(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Event_getUrl[5]));
        startActivity(intent);
    }

    public void Setting_Temp(){
        for(int i=0;i<9;i++){
            Event_getUrl[i]="http://m.naver.com";
        }
    }

    public void Event_SettingUrl() {
       for(int i=0;i<6;i++){
              databaseReference.child("Event_Server").push().setValue(Event_Url[i]);
       }
    }
    public void Event_getUrl(){
        databaseReference.child("SINGERUrlSERVER").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Event_getUrl[Event_CRI] = dataSnapshot.getValue(String.class);
                Event_CRI++;
                if(Event_CRI>6){Event_CRI=0;}
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Event_getUrl[Event_CRI] = dataSnapshot.getValue(String.class);
                Event_CRI++;
                if(Event_CRI>6){Event_CRI=0;}
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Event_getUrl[Event_CRI] = dataSnapshot.getValue(String.class);
                Event_CRI++;
                if(Event_CRI>6){Event_CRI=0;}
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Event_getUrl[Event_CRI] = dataSnapshot.getValue(String.class);
                Event_CRI++;
                if(Event_CRI>6){Event_CRI=0;}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {Toast.makeText(getApplicationContext(),"수신에 실패했습니다",Toast.LENGTH_LONG).show(); }
        });
    }
}

