package com.example.xogns.teamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

import java.io.*;

class items{
    String item1 ="소드마스터 고준영의 검", item2="피에 절여진 배틀엑스", attack1="300", attack2="3350"
            ,text1="죽기 직전 소드마스터의 깨달음을 얻어 우화등선했다고 전해져 내려오는 고준영이 10대 때 용병의 신분으로 전국을 돌아다녔을 때 쓰던 검이다."
            , text2="고대 그리스 시대 크레타섬의 미노타우르스가 쓰던 배틀엑스. 항상 피에 절여져 있어 보는 것만으로 영혼까지 탈탈 털릴 것 같은 거대도끼다.";
}

public class Shop extends AppCompatActivity {

    String filename2 = "touch_p.pos";
    mPos pos = new mPos();
    LinearLayout layout;
    boolean td1 = false;
    float tmp;
    Intent i;
    items it = new items();
    TextView titem1;
    TextView tattack1;
    TextView ttext1;
    TextView tvname;
    TextView titem2;
    TextView tattack2;
    TextView ttext2;
    String name;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //Intent 자체를 가져왔으므로 data에 들어있는 값이 어떤 타입인지 지정을 해줘야 함

        if(requestCode == 1011){ //주고받으면서 새로운 결과를 도출해낼 수 있을것임!!
            if(resultCode == 1012){
                it.item1 = data.getExtras().getString("item11");
                titem1.setText(it.item1);
                it.attack1 = data.getExtras().getString("attack11");
                tattack1.setText(it.attack1);
                it.text1 = data.getExtras().getString("text11");
                ttext1.setText(it.text1);
                it.item2 = data.getExtras().getString("item22");
                titem2.setText(it.item2);
                it.attack2 = data.getExtras().getString("attack22");
                tattack2.setText(it.attack2);
                it.text2 = data.getExtras().getString("text22");
                ttext2.setText(it.text2);
                name = data.getExtras().getString("name");
                tvname.setText(name);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        titem1 = (TextView) findViewById(R.id.tItem);
        tattack1 = (TextView) findViewById(R.id.tAttack);
        ttext1 = (TextView) findViewById(R.id.tText);
        titem2 = (TextView) findViewById(R.id.tItem2);
        tattack2 = (TextView) findViewById(R.id.tAttack2);
        ttext2 = (TextView) findViewById(R.id.tText2);
        tvname = (TextView) findViewById(R.id.tvName);
        iv = (ImageView) findViewById(R.id.ImageView1);

        titem1.setText(it.item1);
        titem2.setText(it.item2);
        tattack1.setText(it.attack1);
        tattack2.setText(it.attack2);
        ttext1.setText(it.text1);
        ttext2.setText(it.text2);
        layout = (LinearLayout) findViewById(R.id.layout1);
        i = getIntent();
        name = i.getExtras().getString("name");
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

                        switch (action) {
                            case MotionEvent.ACTION_DOWN:
                                if (iv.getX() <= pos.X && pos.X <= iv.getX() + 150
                                        && iv.getY() <= pos.Y && pos.Y <= iv.getY() + 150) {
                                    td1 = true;
                                }

                                break;

                            case MotionEvent.ACTION_MOVE:

                                if (td1) {
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


    public void ReturnBuild(View v){
        finish();
    }

    public void OpenEditor(View v){
        i = new Intent(getApplicationContext(), Editor.class);

        it.item1 = titem1.getText().toString();
        i.putExtra("item1", it.item1);
        it.attack1 = tattack1.getText().toString();
        i.putExtra("attack1", it.attack1);
        it.text1 = ttext1.getText().toString();
        i.putExtra("text1", it.text1);
        it.item2 = titem2.getText().toString();
        i.putExtra("item2", it.item2);
        it.attack2 = tattack2.getText().toString();
        i.putExtra("attack2", it.attack2);
        it.text2 = ttext2.getText().toString();
        i.putExtra("text2", it.text2);
        name = tvname.getText().toString();
        i.putExtra("name", name);

        startActivityForResult(i, 1011);
    }
}
