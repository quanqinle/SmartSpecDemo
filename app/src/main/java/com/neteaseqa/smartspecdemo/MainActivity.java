package com.neteaseqa.smartspecdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int iLikeNum = 0;
    TextView textViewLikeNum;
    Button btnLike;
    ViewGroup layoutLike;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLikeNum = (TextView) this.findViewById(R.id.txtLikeNum);
        layoutLike = (ViewGroup)this.findViewById(R.id.LayoutLikeInfo);
        layoutLike.setVisibility(View.INVISIBLE);

        btnLike = (Button) this.findViewById(R.id.buttonLike);
        OnClickLikeButtonListener likeButtonListener = new OnClickLikeButtonListener();
        btnLike.setOnClickListener(likeButtonListener);

        btnNewActivity = (Button) this.findViewById(R.id.buttonStartActivity);
        OnClickNewActivityButtonListener newActivityButtonListener = new OnClickNewActivityButtonListener();
        btnNewActivity.setOnClickListener(newActivityButtonListener);
    }

    public class OnClickLikeButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            iLikeNum++;
            if (0 < iLikeNum) {
                textViewLikeNum.setText(String.valueOf(iLikeNum));
                layoutLike.setVisibility(View.VISIBLE);
            }
        }
    }

    public class OnClickNewActivityButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

    }

}
