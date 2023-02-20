package com.example.scankartu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pax.demo.R;
import com.pax.demo.base.BaseFragment;
import com.pax.demo.util.Convert;
import com.pax.demo.util.IApdu;
import com.pax.demo.util.IApdu.IApduReq;
import com.pax.demo.util.IApdu.IApduResp;
import com.pax.demo.util.Packer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        text.setText( dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        onDateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONDAY),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
    }
}