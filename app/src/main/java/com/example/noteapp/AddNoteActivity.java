package com.example.noteapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.noteapp.base.BaseActivity;
import com.example.noteapp.database.MyDataBase;
import com.example.noteapp.database.model.Note;

import java.util.Calendar;

public class AddNoteActivity extends BaseActivity {
    EditText title;
    EditText content;
    TextView time;
    Button addbtn;
    String theTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
    }

    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.addbtn){
            String theTitle=title.getText().toString();
            String theContent=content.getText().toString();
            Note note=new Note(theTitle,theContent,theTime);
            MyDataBase.getInstance(this).notesDao().addNote(note);
            showMessage("your note added successfully", "ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            },false);


        }else if(id==R.id.time){
            final Calendar calendar= Calendar.getInstance();
            TimePickerDialog dialog =new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    time.setText(hourOfDay+" : "+minute);
                    theTime=hourOfDay+"-"+minute;
                }
            },calendar.get(calendar.HOUR_OF_DAY),calendar.get(calendar.MINUTE),false);
            dialog.show();
        }

    }

    private void initViews(){
        title=(EditText) findViewById(R.id.title);
        content=(EditText) findViewById(R.id.content);
        time=(TextView) findViewById(R.id.time);
        addbtn=(Button)findViewById(R.id.addbtn);
    }
}
