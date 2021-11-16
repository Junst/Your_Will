package com.example.xogns.teamproject;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.io.*;


public class Editor extends AppCompatActivity {

    String filename2 = "touch_p.pos";
    mPos pos = new mPos();
    Intent i = new Intent();
    float tmp;
    boolean td1 = false;

    String item1, item2, attack1, attack2, text1, text2;

    EditText eitem1;
    EditText eattack1;
    EditText etext1;
    TextView tvname;
    EditText eitem2;
    EditText eattack2;
    EditText etext2;
    String name;
    LinearLayout layout;
    ImageView iv;


    public void loadPosition(mPos p){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        File file = new File(getFilesDir(), filename2);

        if(file.exists()){
            try{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);

                if( (tmp = dis.readFloat()) != -1){
                    p.X = tmp;
                    p.Y = dis.readFloat();
                }

                dis.close();
                bis.close();
                fis.close();

            }catch(Exception e){  }
        }
    }

    public void savePosition(mPos p){
        FileOutputStream fos= null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;

        File file = new File(getFilesDir(), filename2);

        try{
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            dos.writeFloat(p.X);
            dos.writeFloat(p.Y);

            dos.close();
            bos.close();
            fos.close();

        }catch(Exception e){  }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor);
        layout = (LinearLayout) findViewById(R.id.layout1);
        eitem1 = (EditText) findViewById(R.id.etItem);
        eattack1 = (EditText) findViewById(R.id.etAttack);
        etext1 = (EditText) findViewById(R.id.etText);
        eitem2 = (EditText) findViewById(R.id.etItem2);
        eattack2 = (EditText) findViewById(R.id.etAttack2);
        etext2 = (EditText) findViewById(R.id.etText2);
        tvname = (TextView) findViewById(R.id.tvName);
        iv = (ImageView) findViewById(R.id.ImageView1);


        i = getIntent();

        item1 = i.getExtras().getString( "item1");
        item2 = i.getExtras().getString( "item2");
        attack1 = i.getExtras().getString( "attack1");
        attack2 = i.getExtras().getString( "attack2");
        text1 = i.getExtras().getString( "text1");
        text2 = i.getExtras().getString( "text2");
        name = i.getExtras().getString("name");

        eitem1.setText(item1);
        eitem2.setText(item2);
        eattack1.setText(attack1);
        eattack2.setText(attack2);
        etext1.setText(text1);
        etext2.setText(text2);
        tvname.setText(name);


        loadPosition(pos);

        iv.setX(pos.X);
        iv.setY(pos.Y);

        layout.setOnTouchListener(
                new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        int action = motionEvent.getAction();

                        pos.X = motionEvent.getX();
                        pos.Y = motionEvent.getY();

                        switch(action){
                            case MotionEvent.ACTION_DOWN:
                                if( iv.getX() <= pos.X && pos.X <= iv.getX()+150
                                        && iv.getY() <= pos.Y && pos.Y <= iv.getY()+150 ) {
                                    td1 = true;
                                }

                                break;

                            case MotionEvent.ACTION_MOVE:

                                if(td1) {
                                    iv.setX(pos.X);
                                    iv.setY(pos.Y);
                                }

                                break;
                            case MotionEvent.ACTION_UP:

                                td1 = false;

                                savePosition(pos);
                                i = new Intent(getApplicationContext(), Settings.class);
                                startActivity(i);

                                break;
                        }

                        return true;
                    }
                }
        );
    }

    public void ReturnShop(View v){
        item1 = eitem1.getText().toString();
        item2 = eitem2.getText().toString();
        attack1 = eattack1.getText().toString();
        attack2 = eattack2.getText().toString();
        text1 = etext1.getText().toString();
        text2 = etext2.getText().toString();
        name = tvname.getText().toString();

        i.putExtra("item11", item1);
        i.putExtra("item22", item2);
        i.putExtra("attack11", attack1);
        i.putExtra("attack22", attack2);
        i.putExtra("text11", text1);
        i.putExtra("text22", text2);
        i.putExtra("name", name);

        setResult(1012, i);

        finish();
    }
}