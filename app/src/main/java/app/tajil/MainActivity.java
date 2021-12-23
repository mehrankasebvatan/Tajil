package app.tajil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.pushpole.sdk.PushPole;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    ImageView img2;
    TextView toolbar;
    CardView cv_empty, cv_saturday, cv_sunday, cv_monday,
             cv_tuesday, cv_wednesday, cv_thursday, cv_friday,
             cv_salavat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PushPole.initialize(this,false);


        img2 = findViewById(R.id.img2);
        toolbar = findViewById(R.id.tv_title);
        cv_empty = findViewById(R.id.cv_counter);
        cv_saturday = findViewById(R.id.cv_saturday);
        cv_sunday = findViewById(R.id.cv_sunday);
        cv_monday = findViewById(R.id.cv_monday);
        cv_tuesday = findViewById(R.id.cv_tuesday);
        cv_wednesday = findViewById(R.id.cv_wednesday);
        cv_thursday = findViewById(R.id.cv_thursday);
        cv_friday = findViewById(R.id.cv_friday);
        cv_salavat = findViewById(R.id.cv_salavat);



        img2.setImageResource(R.drawable.icon_info);
        img2.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InfoActivity.class));
        });


        toolbar.setText(R.string.app_name);
        cv_empty.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("empty","empty");
            startActivity(intent);
        });

        cv_saturday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("saturday","saturday");
            startActivity(intent);
        });

        cv_sunday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("sunday","sunday");
            startActivity(intent);
        });

        cv_monday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("monday","monday");
            startActivity(intent);
        });

        cv_tuesday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("tuesday","tuesday");
            startActivity(intent);
        });

        cv_wednesday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("wednesday","wednesday");
            startActivity(intent);
        });

        cv_thursday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("thursday","thursday");
            startActivity(intent);
        });

        cv_friday.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("friday","friday");
            startActivity(intent);
        });

        cv_salavat.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("salavat","salavat");
            startActivity(intent);
        });








    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}