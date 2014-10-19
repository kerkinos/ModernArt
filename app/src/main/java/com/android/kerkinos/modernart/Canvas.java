package com.android.kerkinos.modernart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;


public class Canvas extends ActionBarActivity {

    SeekBar mSeekBar;
    LinearLayout box1,box2,box3,box4,box5,box6,box7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        box1 = (LinearLayout) findViewById(R.id.box1);
        box2 = (LinearLayout) findViewById(R.id.box2);
        box3 = (LinearLayout) findViewById(R.id.box3);
        box4 = (LinearLayout) findViewById(R.id.box4);
        box5 = (LinearLayout) findViewById(R.id.box5);
        box6 = (LinearLayout) findViewById(R.id.box6);
        box7 = (LinearLayout) findViewById(R.id.box7);

        //Set some initial colors
        box1.setBackgroundColor(-65536);
        box2.setBackgroundColor(-115712);
        box3.setBackgroundColor(-15384576);
        box4.setBackgroundColor(-16816415);
        box5.setBackgroundColor(-14417665);
        box6.setBackgroundColor(-4390657);
        box7.setBackgroundColor(-65505);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //Change the colors according to the progress of the seekBar
                float[] hsvColor = {0, 1, 1};
                hsvColor[0] = 360f * progress / 1000;
                box1.setBackgroundColor(Color.HSVToColor(hsvColor)-65536);
                box2.setBackgroundColor(Color.HSVToColor(hsvColor)-115712);
                box3.setBackgroundColor(Color.HSVToColor(hsvColor)-15384576);
                box4.setBackgroundColor(Color.HSVToColor(hsvColor)-16816415);
                box5.setBackgroundColor(Color.HSVToColor(hsvColor)-14417665);
                box6.setBackgroundColor(Color.HSVToColor(hsvColor)-4390657);
                box7.setBackgroundColor(Color.HSVToColor(hsvColor)-65505);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.canvas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (id == R.id.more_info) {
            //Create custom dialog
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_Base_AppCompat_Dialog_FixedSize));
            alertDialogBuilder.setMessage(R.string.greeting);
            alertDialogBuilder.setPositiveButton(R.string.not_now,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            //Do nothing
                        }
                    });
            alertDialogBuilder.setNegativeButton(R.string.visit_moma,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent browser = new Intent(Intent.ACTION_VIEW);
                            browser.setData(Uri.parse("http://www.moma.org"));
                            startActivity(browser);
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
