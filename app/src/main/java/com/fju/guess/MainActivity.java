package com.fju.guess;
//程式設計
//一開始先產生一個介於1-100的亂數，存放在名稱為secret的屬性中，以下例子secret值為55，產生後將該數字顯示於右上方TextView上(開發中測試用)。
//當使用者按下SEND按鈕後，取得EditText中的文字並轉換為整數，與secret比較，如果該數比secret大，如88，則以對話框顯示 “1 to 88″，
// 若小於55，例如33，則顯示”33 to 100″。重覆以上步驟縮小範圍，一直到猜中數字secret為止，猜中時對話框訊息「Yes, the number is 55」。
//
//加分題:
//設計另一個畫面 ExcellentActivity，若使用者如果在三次(包括)內猜對，則以這個Activity顯示” Excellent “的文字方塊。
//加分題也需要在錄影中測試成功。
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int serect = 55;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
        int n = Integer.parseInt(number.getText().toString());
//        sercet = findViewById(R.id.sercet);

    }

    public void send(View view) {
        EditText number = findViewById(R.id.number);
        int n = Integer.parseInt(number.getText().toString());
        while (n!=serect) {
            if (n > serect) {
                new AlertDialog.Builder(this).setTitle("Guess")
                        .setMessage("1 to" + n).setPositiveButton("OK", null).show();
            }
            if (n < serect) {
                new AlertDialog.Builder(this).setTitle("Guess")
                        .setMessage(n + "to 100")
                        .setPositiveButton("Ok", null).show();

            }
        }

            if (n == serect) {
                new AlertDialog.Builder(this).setTitle("Guess")
                        .setMessage("Yes, the number is" + serect)
                        .setPositiveButton("Ok", null).show();
          }
    }
}

