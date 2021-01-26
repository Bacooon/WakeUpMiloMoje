package com.example.wakeupmilomoje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AlarmEdit extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText time;
    EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_edit);
        Spinner spRingtone = findViewById(R.id.spRingtone);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ringtones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRingtone.setAdapter(adapter);

        spRingtone.setOnItemSelectedListener(this);
         time = findViewById(R.id.etTime);
         time.setInputType(InputType.TYPE_NULL);
         date = findViewById(R.id.etDate);
         date.setInputType(InputType.TYPE_NULL);

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePicker();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        date.setText(day_string+"/"+month_string+"/"+year_string);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePicker();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.timepicker));
    }
    public void processTimePickerResult(int hourOfDay, int minute) {
         String hour_string = Integer.toString(hourOfDay);
         String minute_string = Integer.toString(minute);
         time.setText(hour_string+":"+minute_string);

    }
}