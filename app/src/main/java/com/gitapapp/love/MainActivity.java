package com.gitapapp.love;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.gitapapp.love.Adapter.ChapterAdapter;
import com.gitapapp.love.Model.Chapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private LinearLayoutManager layoutManager;
    private String part, chapter;

    private Spinner pointSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        part = getIntent().getStringExtra("part");

        Spinner chapterSpinner = findViewById(R.id.chapterSpinner);
        chapterSpinner.setOnItemSelectedListener(MainActivity.this);
        pointSpinner = findViewById(R.id.pointSpinner);
        pointSpinner.setOnItemSelectedListener(MainActivity.this);

        switch (part) {
            case "partOne": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_one,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
            case "partTwo": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_two,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
            case "partThree": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_three,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
            case "partFour": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_four,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
            case "partFive": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_five,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
            case "partSix": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_six,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }case "PartSeven": {
                ArrayAdapter<CharSequence> chapterAdapter = ArrayAdapter.createFromResource(this,
                        R.array.part_seven,
                        R.layout.layout_spinner);
                chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chapterSpinner.setAdapter(chapterAdapter);

                break;
            }
        }

    }

    private String loadJSONFromAsset(String chapterNo) {
        String json = null;
        try {
            InputStream is = getAssets().open(chapterNo + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    private void RequestData(String chapterNo) {
        RecyclerView recyclerView = findViewById(R.id.mRecycler);

        List<Chapter> data = new ArrayList<>();

        try {
            JSONObject json = new JSONObject(loadJSONFromAsset(chapterNo));
            JSONArray tablelist = json.getJSONArray("chapter");

            for (int i = 0; i < tablelist.length(); i++) {
                JSONObject AllTable = tablelist.getJSONObject(i);
                Chapter items2 = new Chapter();

                items2.setText(AllTable.getString("text"));
                data.add(items2);

            }

            ChapterAdapter mAdapter = new ChapterAdapter(MainActivity.this, data);
            layoutManager = new LinearLayoutManager(MainActivity.this,
                    LinearLayout.HORIZONTAL, false);
            SnapHelper snapHelper = new PagerSnapHelper();
            recyclerView.setOnFlingListener(null);
            snapHelper.attachToRecyclerView(recyclerView);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        parent.getItemAtPosition(position);
        switch (parent.getId()) {
            case R.id.chapterSpinner:

                String chCheck = parent.getItemAtPosition(position).toString();

                switch (chCheck) {
                    case "BOL. 1": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.seven_arrays, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 8": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.eight_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 9": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.nine_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 10": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.ten_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 11": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.eleven_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 12": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twelve_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 13": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.thirteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 14": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.fourteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 15": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.fifteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 16": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.sixteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 17": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.seventeen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 18": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.eighteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 19": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.nineteen_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 20": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_array, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 21": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_one, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 22": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_two, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 23": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_three, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 24": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_four, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 25": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_five, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 26": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_six, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 27": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_seven, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 28": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_eight, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                    case "Ch. 29": {
                        ArrayAdapter<CharSequence> pointAdapter = ArrayAdapter.createFromResource(this,
                                R.array.twenty_nine, R.layout.layout_spinner);
                        pointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        pointSpinner.setAdapter(pointAdapter);
                        break;
                    }
                }
                RequestData(parent.getItemAtPosition(position).toString());
                pointSpinner.setSelection(0);

                break;

            case R.id.pointSpinner:
                layoutManager.scrollToPosition(parent.getSelectedItemPosition());
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
