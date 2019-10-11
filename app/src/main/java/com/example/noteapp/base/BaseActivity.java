package com.example.noteapp.base;

import android.app.Activity;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    protected Activity activity;
    public BaseActivity(){
        activity=this;
    }

    public AlertDialog showMessage(String message, String posActionName, DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder builder=new AlertDialog.Builder(this );
        builder.setMessage(message);
        builder.setPositiveButton(posActionName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.show();
    }

    public AlertDialog showMessage (int message,int posActionName){
        AlertDialog.Builder builder=new AlertDialog.Builder(this );
        builder.setMessage(message);
        builder.setPositiveButton(posActionName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.show();
    }
    public AlertDialog showMessage (String message,String posActionName, DialogInterface.OnClickListener onClickListener,boolean setCancel){
        AlertDialog.Builder builder=new AlertDialog.Builder(this );
        builder.setMessage(message);
        builder.setPositiveButton(posActionName, onClickListener);
        builder.setCancelable(setCancel);
        return builder.show();
    }
    public AlertDialog showMessage (int message,int posActionName, DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder builder=new AlertDialog.Builder(this );
        builder.setMessage(message);
        builder.setPositiveButton(posActionName, onClickListener);
        return builder.show();
    }

}
