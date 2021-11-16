package com.example.xogns.teamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import org.w3c.dom.Text;
import java.io.*;


class user{
    float ID, PW;

}

public class Main extends AppCompatActivity {
    Intent i;
    String name;
    float ID, PW;
    String filename = "pw";
    EditText ename;
    EditText eid;
    EditText epw;
    TextView txt;
    ImageView iv;
    user u = new user();
    LinearLayout layout;
    mPos pos = new mPos();
    boolean td1 = false;
    float tmp;
    String filename2 = "touch_p.pos";

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


    public void loadUser(user u){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        File file = new File(getFilesDir(), filename);

        if(file.exists()){ //파일이 존재하는지 여부
            try{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);

                float tmp;

                if((tmp = dis.readFloat()) != -1){ //-1이 의미하는 것은 선택한 파일의 부분에 아무것도 없는 것 char = /0
                    u.ID = tmp;
                    u.PW = dis.readFloat();
                }

                dis.close();
                bis.close();
                fis.close();

            }catch(Exception e) { }
        }

    }

    public void saveUser(user u){
        //input, output의 기준은 메모리가 결정
        FileOutputStream fos = null;
        BufferedOutputStream bos = null; //중간에서 작업을 저장하는 역할, 닫히면 그 때 저장된 최종값을 보내준다
        DataOutputStream dos = null; //다양한 데이터를 사용할 수 있도록 도와주는 역할

        File file = new File(getFilesDir(), filename); //getFilesDir() : 파일을 담을 수 있는 디렉토리를 시스템이 물어보는 역할

        try{//안드로이드 및 파일 입출력 시스템에서 throws를 써버리면 작동이 불가능한 경우가 많아 try-catch문을 사용
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            dos.writeFloat(u.ID);
            dos.writeFloat(u.PW);

            dos.close();
            bos.close();
            fos.close();
        }catch(Exception e) { }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ename = (EditText) findViewById(R.id.etName);
        eid = (EditText) findViewById(R.id.etID);
        epw = (EditText) findViewById(R.id.etPW);

        txt = (TextView) findViewById(R.id.textView);
        iv = (ImageView) findViewById(R.id.ImageView1);

        loadUser(u);
        eid.setText(u.ID+"");




        loadPosition(pos);

        iv.setX(pos.X);
        iv.setY(pos.Y);



        layout = (LinearLayout) findViewById(R.id.layout1);
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







    public void SaveUserInfo(View v){
        u.ID = Float.parseFloat(eid.getText().toString());
        u.PW = Float.parseFloat(epw.getText().toString());
        saveUser(u);
        txt.setText("사용자 정보가 성공적으로 저장되었습니다!");
    }

    public void OpenBuild(View v){
        i = new Intent(getApplicationContext(), Build_Up.class);
        loadUser(u);
        name = ename.getText().toString();
        i.putExtra("name", name);
        ID = Float.parseFloat(eid.getText().toString());
        PW = Float.parseFloat(epw.getText().toString());
        if(ID == u.ID && PW == u.PW) {
            startActivity(i);
        }else{
            txt.setText("이 사기꾼! 아이디랑 비번이 다르잖아!");
        }
    }
}
