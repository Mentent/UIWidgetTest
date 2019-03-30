package com.mentent.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        Button button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_1:
                        String inputText = editText.getText().toString();
                        if(inputText.trim().equals(""))//验证输入是否为空
                        {
                            Toast.makeText(MainActivity.this, "请输入文字。", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        final ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
        Button button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_2:
                        if (pb.getVisibility() == View.GONE) {
                            pb.setVisibility(View.VISIBLE);
                        } else {
                            pb.setVisibility(View.GONE);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        Button button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_3:
                        int progress = pb.getProgress();
                        progress = progress + 5;
                        pb.setProgress(progress);
                        if (progress >= 100) {
                            Toast.makeText(MainActivity.this, "进度条已达最大值。", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        Button button_4 = (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_4:
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("来自弱小的AlertDialog");
                        dialog.setMessage("很抱歉，那个那个...");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("阅毕", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
        });
        Button button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_5:
                        final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "等一下。",
                                "稍等片刻，一会儿就好。", true, true);
                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(5000);//让他显示10秒后，取消ProgressDialog
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                dialog.dismiss();
                            }
                        });
                        t.start();
                }
            }
        });
    }
}
