package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class DatePickerDialog extends AppCompatActivity {
    private int myYear, myMonth, myDay; //User 選擇的日期

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);

        final TextView txtChoose = findViewById(R.id.txt_choose); //宣告顯示 User 選擇日期的 TextView
        Button btnClickMe = findViewById(R.id.btn_clickMe); //宣告選擇日期的 Button

        btnClickMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance(); //使用 Calendar 的 getInstance() 取得 Calendar 的實例
                myYear = c.get(Calendar.YEAR); //年
                myMonth = c.get(Calendar.MONTH); //月
                myDay = c.get(Calendar.DAY_OF_MONTH); //日

                /*new DatePickerDialog，並實作 OnDateSetListener 這個介面的事件
                提供使用者操控完日期介面後，所傳回的日期*/
                new android.app.DatePickerDialog(DatePickerDialog.this, new android.app.DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String format = getString(R.string.setDate) + setDateFormat(year,month,day);
                        //setDateFormat 可以設定日期顯示的格式，將此格式包裝成一個方法，回傳我們所需要的字串
                        txtChoose.setText(format);
                    }
                }, myYear,myMonth, myDay).show();
            }
        });
    }

    //利用 setDateFormat 設定日期顯示的格式
    private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
        return year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
        //Calendar的 Month 是從 0 開始，不是從 1 開始，所以要 +1
    }
}

