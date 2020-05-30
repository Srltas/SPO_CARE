package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class TeethBrushTimerActivity extends Activity implements View.OnClickListener{
    TextView countView, teethBrushText;
    Button btnStart;
    Boolean startCheck = false; //타이머 중복 실행 방지
    LinearLayout firstLayout, secondLayout;
    ImageView teethBrushImage;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.teeth_brush_timer);

        countView = (TextView) findViewById(R.id.countView);
        btnStart = (Button) findViewById(R.id.btnTeethBrushTimerStart);
        firstLayout = (LinearLayout) findViewById(R.id.firstLayout);
        secondLayout = (LinearLayout) findViewById(R.id.secondLayout);
        teethBrushText = (TextView) findViewById(R.id.teethBrushText);
        teethBrushImage = (ImageView) findViewById(R.id.teethBrushImage);

        firstLayout.setVisibility(View.VISIBLE);
        secondLayout.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == btnStart){
            if(startCheck == false){
                startCheck = true;
                firstLayout.setVisibility(View.INVISIBLE);
                secondLayout.setVisibility(View.VISIBLE);
                //3분30초
                String conversionTime = "000330";
                countDown(conversionTime);
            }
        }
    }

    public void countDown(String time) {
        long conversionTime = 0;

        //1000 단위가 1초
        //60000 단위가 1분
        String getMin = time.substring(2, 4);
        String getSecond = time.substring(4, 6);

        // "00"이 아니고, 첫 번째 자리가 0이면 제거
        if (getMin.substring(0, 1) == "0") {
            getMin = getMin.substring(1, 2);
        }

        if (getSecond.substring(0, 1) == "0") {
            getSecond = getSecond.substring(1, 2);
        }

        //변환시간
        conversionTime = Long.valueOf(getMin) * 60 * 1000 + Long.valueOf(getSecond) * 1000;

        //첫 번째 인자 : 원하는 시간 (예를들어 30초면 30 x 1000(주기))
        //두 번째 인자 : 주기(1000 = 1초)
        new CountDownTimer(conversionTime, 1000) {
            int count = 0, imageId;
            String time;    //분 + 초를 합치 문자열
            String[] timeList = {"329", "315", "300", "245", "230", "215", "200", "145", "130", "115", "100", "45", "30", "15"};
            int[] stringIdList = {R.string.teethBrush1, R.string.teethBrush2, R.string.teethBrush3, R.string.teethBrush4, R.string.teethBrush5, R.string.teethBrush6, R.string.teethBrush7, R.string.teethBrush8,
                    R.string.teethBrush9, R.string.teethBrush10, R.string.teethBrush11, R.string.teethBrush12, R.string.teethBrush13, R.string.teethBrush14};
            String imageName;

            //특정 시간마다 뷰 변경
            public void onTick(long millisUntilFinished) {
                //분단위
                long getMin = millisUntilFinished;
                String min = String.valueOf(getMin / (60 * 1000));

                //초단위
                String second = String.valueOf((getMin % (60 * 1000)) / 1000);

                //초가 한자라면 0을 붙인다
                if(second.length() == 1){
                    second = "0" + second;
                }

                time = min+second;

                if(time.equals(timeList[count])){
                    imageName = "teethtimer" + (count + 1);

                    //이미지 아이디 찾아오기
                    imageId = getResources().getIdentifier("com.example.spo_care:drawable/" + imageName,null,null);
                    teethBrushImage.setImageResource(imageId);

                    //문자
                    teethBrushText.setText(stringIdList[count]);
                    count++;
                }
                countView.setText(min + ":" + second);
            }

            //제한시간 종료시
            public void onFinish(){
                firstLayout.setVisibility(View.VISIBLE);
                secondLayout.setVisibility(View.INVISIBLE);
                countView.setText("3:30");
                startCheck = false;
            }
        }.start();
    }
}