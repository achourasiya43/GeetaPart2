package com.gitapapp.love;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gitapapp.TitleActivity;

public class IndexActivity extends AppCompatActivity {

    public final static String PREFS = "PrefsFile";

    private SharedPreferences pref = null;
    private SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        pref = getSharedPreferences(PREFS, MODE_PRIVATE);
        editor = pref.edit();

        if (!pref.contains("lastRunTime"))
            enableNotification();
        else
            recordRunTime();

        startService(new Intent(this, CheckRecentRun.class));
    }

    public void recordRunTime() {
        editor.putLong("lastRunTime", System.currentTimeMillis());
        editor.commit();
    }

    public void enableNotification() {
        editor.putLong("lastRunTime", System.currentTimeMillis());
        editor.putBoolean("enabled", true);
        editor.commit();
        Toast.makeText(this, "Notifications are Enabled", Toast.LENGTH_LONG).show();
    }

    public void disableNotification() {
        editor.putBoolean("enabled", false);
        editor.commit();
        Toast.makeText(this, "Notifications Has Been Disabled", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notification_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.enable:
                enableNotification();
                break;

            case R.id.disable:
                disableNotification();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void PartOne(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partOne");
        startActivity(chapter);
    }

    public void PartTwo(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partTwo");
        startActivity(chapter);
    }

    public void PartThree(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partThree");
        startActivity(chapter);
    }

    public void PartFour(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partFour");
        startActivity(chapter);
    }

    public void PartFive(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partFive");
        startActivity(chapter);
    }

    public void PartSix(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "partSix");
        startActivity(chapter);
    }

    public void PartSeven(View view) {
        Intent chapter = new Intent(IndexActivity.this, MainActivity.class);
        chapter.putExtra("part", "PartSeven");
        startActivity(chapter);
    }
}
