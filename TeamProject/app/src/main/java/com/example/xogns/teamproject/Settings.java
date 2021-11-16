package com.example.xogns.teamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.io.*;



public class Settings extends AppCompatActivity {
    Intent i = new Intent();
    Float ID, PW, cPW;
    String filename = "pw";
    user u = new user();
    mPos p = new mPos();
    EditText eid;
    EditText epw;
    EditText ecpw;
    TextView stat;
    boolean td1 = false;
    float tmp;
    String filename2 = "touch_p.pos";

    mPos pos = new mPos();

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
        setContentView(R.layout.settings);
        eid = (EditText) findViewById(R.id.eID);
        epw = (EditText) findViewById(R.id.ePW);
        ecpw = (EditText) findViewById(R.id.ePW2);
        stat = (TextView) findViewById(R.id.Status);
    }

    public void Change(View v){
        loadUser(u);
        ID = Float.parseFloat(eid.getText().toString());
        PW = Float.parseFloat(epw.getText().toString());
        cPW = Float.parseFloat(ecpw.getText().toString());
        if(u.ID == ID && u.PW == PW){
            u.PW = cPW;
            stat.setText("축하드립니다! 사용자의 패스워드가 무사히 변경되었습니다");
            saveUser(u);
        }else {
            stat.setText("이 범죄자! 아이디랑 패스워드가 다르잖아!");
        }
    }

    public void Reset(View v){

        loadPosition(p);
        p.X = 0.0f;
        p.Y = 0.0f;
        savePosition(p);
        loadUser(u);
        u.ID = 0.0f;
        u.PW = 0.0f;
        saveUser(u);
        stat.setText("사용자 정보가 무사히 제거되었습니다. 장비를 정지합니다.");
        i = new Intent(getApplicationContext(), Main.class);
        startActivity(i);
    }
    public void CloseSettings(View v){
        finish();
    }
}
