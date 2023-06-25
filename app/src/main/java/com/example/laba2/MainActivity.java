package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private Context context;
    private int maxTextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        final TextView helloWorld = (TextView)findViewById(R.id.hello_world);
        helloWorld.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/PenguinAttackCyrillic.otf"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout myLayout = (LinearLayout)findViewById(R.id.root);
        final int itemId = item.getItemId();

        if (itemId == R.id.red){
            myLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            return true;
        }

        if (itemId == R.id.green){
            myLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
            return true;
        }

        if (itemId == R.id.blue){
            myLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
            return true;
        }

        if (itemId == R.id.lightBlue){
            myLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightBlue));
            return true;
        }

        if (itemId == R.id.rotate){
            int orientation = getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
            return true;
        }

        if (itemId == R.id.addText){

            if (maxTextCount > 5)
                return true;

            AddText(myLayout);
            maxTextCount++;
            return true;
        }

        if (itemId == R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void AddText(LinearLayout myLayout) {
        TextView textView = new TextView(context);
        textView.setText("New Text");
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(5,5,5,5);
        TextViewCompat.setTextAppearance(textView, R.style.SpecialText);
        textView.setBackgroundColor(Color.parseColor("#b7e4fb"));
        myLayout.addView(textView);
    }
}