package com.stewhouse.updownseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UDMainActivity extends AppCompatActivity implements View.OnClickListener, UpDownSeekBarListener {

    private UpDownSeekBar _upDownSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        _upDownSeekBar = (UpDownSeekBar) findViewById(R.id.seekBar);
        if (_upDownSeekBar != null) {
            _upDownSeekBar.setListener(this);
            _upDownSeekBar.setIndicatorViewWidth(80);
            _upDownSeekBar.setIndicatorViewHeight(80);
            _upDownSeekBar.setIndicatorDetailViewWidth(300);
            _upDownSeekBar.setIndicatorDetailViewHeight(300);
            _upDownSeekBar.setMaxIndicatorViewWidth(60);
            _upDownSeekBar.setMaxIndicatorViewHeight(60);
            _upDownSeekBar.setMinIndicatorViewWidth(60);
            _upDownSeekBar.setMinIndicatorViewHeight(60);
            _upDownSeekBar.setSeekBarViewWidth(20);
            _upDownSeekBar.setMaxProgress(50000);
            _upDownSeekBar.setMinProgress(10);
            _upDownSeekBar.setProgress((30000 + 10) / 2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            _upDownSeekBar.setProgress(0);
        } else if (v.getId() == R.id.button2) {
            _upDownSeekBar.setProgress(300);
        } else if (v.getId() == R.id.button3) {
            _upDownSeekBar.setProgress(12000);
        } else if (v.getId() == R.id.button4) {
            _upDownSeekBar.setProgress(28000);
        } else if (v.getId() == R.id.button5) {
            _upDownSeekBar.setProgress(30000);
        }
    }

    @Override
    public void progressChanged(int progress) {
        TextView textView = (TextView) _upDownSeekBar.getIndicatorDetailView().findViewById(R.id.textView);
        textView.setText("" + progress);
    }
}
