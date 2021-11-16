package com.example.xogns.teamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class mPos{
    float X;
    float Y;

}
public class Build_Up extends AppCompatActivity {

    String filename2 = "touch_p.pos";
    TextView ts1, ts2, tb1, tb2, tp1, tp2, tv1, tm1;
    ImageView iv, ti1, ti2;
    String str, name;
    mPos pos = new mPos();
    LinearLayout layout;
    boolean td1 = false;
    int a, b, c, a2, b2, bui, bui2, money, sell, sell2 = 0;
    float tmp;
    Intent i = new Intent();


    public void BuildUp(View v){

        money -= 30000;
        tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");

        if(money <= 0){
            a = 0;
            b = 0;
            c += 1;
            tm1.setText("외상 :" + Integer.toString(money));
        }

        if(c == 3){
            tm1.setText(" 두번 더 외상시 창이 꺼집니다. ");
        }

        if(c == 5){
            a = 0;
            b = 0;
            c = 0;
            finish();
        }

        if(bui == 0){ tp1.setText(Integer.toString(sell));}
        else if(1 <=bui || bui <= 7){ sell += 30000;  tp1.setText(Integer.toString(sell));}
        else if(8 <=bui || bui <= 13){ sell += 40000; tp1.setText(Integer.toString(sell)); }
        else if(bui == 14){  sell += 50000; tp1.setText(Integer.toString(sell));}
        else if(bui == 15){  sell += 100000; tp1.setText(Integer.toString(sell));}
        else if(bui == 16){  sell += 300000; tp1.setText(Integer.toString(sell));}
        else{tp1.setText("오류");}

        if(a == 4 && b <= 1){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 7 && b <= 2){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 8 && b <= 3){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 11 && b <= 4){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 12 && b <= 5){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 13 && b <= 6){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 14 && b <= 7){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a == 15 && b <= 8){
            str = "펑! 강화 실패!";
            a = 0;
            b += 1;
            bui = 0;
            sell = 0;
            tp1.setText(Integer.toString(sell));
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }
        else if(a >= 16){
            str = "강화 최대 단계입니다! 어서 판매하세요!";
            ts1.setText(str);
            a += 1;
            tb1.setText("+" + Integer.toString(bui));
            if(a>=18){
                str = "더이상 강화가 되지 않아 팔아버립니다.";
                a = 0;
                b = 0;
                bui = 0;
                ts1.setText(str);
                tb1.setText("+" + Integer.toString(bui2));
                money = money + sell;
                tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");
                sell = 0;
                tp1.setText(Integer.toString(sell));
            }

        }
        else{
            str = "번쩍! 강화 성공!";
            a += 1;
            bui += 1;
            ts1.setText(str);
            tb1.setText("+" + Integer.toString(bui));
        }

    }

    public void BuildUp2(View v) {

        money -= 50000;
        tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");

        if (money <= 0) {
            a2 = 0;
            b2 = 0;
            c += 1;
            tm1.setText("외상 :" + Integer.toString(money));
        }

        if (c == 3) {
            tm1.setText(" 두번 더 외상시 창이 꺼집니다. ");
        }

        if (c == 5) {
            a2 = 0;
            b2 = 0;
            c = 0;
            finish();
        }

        if (bui2 == 0) {
            tp2.setText(Integer.toString(sell2));
        } else if (1 <= bui2 || bui2 <= 4) {
            sell2 += 50000;
            tp2.setText(Integer.toString(sell2));
        } else if (5 <= bui2 || bui2 <= 8) {
            sell2 += 80000;
            tp2.setText(Integer.toString(sell2));
        } else if (9 <= bui2 || bui2 <= 12) {
            sell2 += 100000;
            tp2.setText(Integer.toString(sell2));
        } else if (bui2 == 13) {
            sell2 += 150000;
            tp2.setText(Integer.toString(sell2));
        } else if (bui2 == 14) {
            sell2 += 300000;
            tp2.setText(Integer.toString(sell2));
        } else if (bui2 == 15) {
            sell2 += 500000;
            tp2.setText(Integer.toString(sell2));
        } else if (bui2 == 16) {
            sell2 += 1000000;
            tp2.setText(Integer.toString(sell2));
        } else {
            tp2.setText("오류");
        }


        if (a2 == 1 && b2 <= 1) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 2 && b2 <= 2) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 3 && b2 <= 3) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 4 && b2 <= 4) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 6 && b2 <= 5) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 8 && b2 <= 6) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 10 && b2 <= 7) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 11 && b2 <= 8) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 13 && b2 <= 9) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 14 && b2 <= 10) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 == 15 && b2 <= 11) {
            str = "펑! 강화 실패!";
            a2 = 0;
            b2 += 1;
            bui2 = 0;
            sell2 = 0;
            tp2.setText(Integer.toString(sell2));
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        } else if (a2 >= 16) {
            str = "강화 최대 단계입니다! 어서 판매하세요!";
            ts2.setText(str);
            a2 += 1;
            tb2.setText("+" + Integer.toString(bui2));
            if (a2 >= 18) {
                str = "더이상 강화가 되지 않아 팔아버립니다.";
                a2 = 0;
                b2 = 0;
                bui2 = 0;
                ts2.setText(str);
                tb2.setText("+" + Integer.toString(bui2));
                money = money + sell2;
                tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");
                sell2 = 0;
                tp2.setText(Integer.toString(sell2));
            }

        } else {
            str = "번쩍! 강화 성공!";
            a2 += 1;
            bui2 += 1;
            ts2.setText(str);
            tb2.setText("+" + Integer.toString(bui2));
        }
    }

    public void SellUp1(View v){
        str = "판매 완료!";
        a = 0;
        bui = 0;
        ts1.setText(str);
        tb1.setText("+" + Integer.toString(bui2));
        money = money + sell;
        tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");
        sell = 0;
        tp1.setText(Integer.toString(sell));
    }

    public void SellUp2(View v){
        str = "판매 완료!";
        a2 = 0;
        bui2 = 0;
        ts2.setText(str);
        tb2.setText("+" + Integer.toString(bui2));
        money = money + sell2;
        tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");
        sell2 = 0;
        tp2.setText(Integer.toString(sell2));

    }

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
        setContentView(R.layout.buildup);

        ts1 = (TextView) findViewById(R.id.TvShow1);
        ts2 = (TextView) findViewById(R.id.TvShow2);
        tb1 = (TextView) findViewById(R.id.TvBuild1);
        tb2 = (TextView) findViewById(R.id.TvBuild2);
        tp1 = (TextView) findViewById(R.id.TvPrice1);
        tp2 = (TextView) findViewById(R.id.TvPrice2);
        tv1 = (TextView) findViewById(R.id.TvName);
        tm1 = (TextView) findViewById(R.id.TvMoney);
        iv = (ImageView) findViewById(R.id.ImageView1);
        ti1 = (ImageView) findViewById(R.id.ToolImage1);
        ti2 = (ImageView) findViewById(R.id.ToolImage2);


        i = getIntent();

        name = i.getExtras().getString("name");

        tv1.setText(name);

        loadPosition(pos);

        iv.setX(pos.X);
        iv.setY(pos.Y);

        money += 5000000;
        tm1.setText("남은 금액 :" + Integer.toString(money) + "골드");

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
    public void ReturnMain(View v){
        finish();

    }

    public void OpenShop(View v){
        i = new Intent(getApplicationContext(), Shop.class);

        name = tv1.getText().toString();
        i.putExtra("name", name);

        startActivity(i);
    }

}