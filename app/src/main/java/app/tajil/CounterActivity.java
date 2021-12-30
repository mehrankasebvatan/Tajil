package app.tajil;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.adivery.sdk.AdiveryAdListener;
import com.adivery.sdk.AdiveryBannerAdView;
import com.valdesekamdem.library.mdtoast.MDToast;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class CounterActivity extends AppCompatActivity {

    TextView toolbar, tv_arabic, tv_farsi, zekr, farsi, tv_counter, tv_subtitle;
    ImageView img1, img_reset, img_decrease;
    CardView add;
    Vibrator myVibrator;
    int count = 0;
    String APP_ID = "aebe62d0-b254-4cc8-8fd2-4271ce207864";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        showAdd();

        myVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        toolbar = findViewById(R.id.tv_title);
        img1 = findViewById(R.id.img1);
        tv_arabic = findViewById(R.id.tv_arabic);
        tv_farsi = findViewById(R.id.tv_farsi);
        zekr = findViewById(R.id.zekr);
        farsi = findViewById(R.id.farsi);
        add = findViewById(R.id.cv_add);
        img_decrease = findViewById(R.id.img_decrease);
        img_reset = findViewById(R.id.img_reset);
        tv_counter = findViewById(R.id.tv_counter);
        tv_subtitle = findViewById(R.id.tv_subtitle);

        img1.setImageResource(R.drawable.icon_back);
        img1.setOnClickListener(view -> {
            finish();
        });

        tv_subtitle.setText(R.string.day);

        add.setOnClickListener(view -> {
            count++;
            tv_counter.setText(count + "");

            if (Build.VERSION.SDK_INT >= 26) {
                myVibrator.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                myVibrator.vibrate(150);
            }


        });

        img_reset.setOnClickListener(view -> {
            count = 0;
            tv_counter.setText(count + "");

            MDToast mdToast = MDToast.makeText(CounterActivity.this, getApplicationContext().getResources().
                    getString(R.string.reset_message), MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
            mdToast.setGravity(Gravity.TOP, 0, 200);
            mdToast.show();

            if (Build.VERSION.SDK_INT >= 26) {
                myVibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                myVibrator.vibrate(500);
            }
        });

        img_decrease.setOnClickListener(view -> {

            if (count != 0) {
                count--;
                tv_counter.setText(count + "");

                if (Build.VERSION.SDK_INT >= 26) {
                    myVibrator.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    myVibrator.vibrate(300);
                }

            } else {

                MDToast mdToast = MDToast.makeText(CounterActivity.this, getApplicationContext().getResources().
                        getString(R.string.empty_error), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
                mdToast.setGravity(Gravity.TOP, 0, 200);
                mdToast.show();
            }

        });


        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("empty")) {
            toolbar.setText(R.string.empty_counter);

            tv_arabic.setVisibility(View.GONE);
            tv_farsi.setVisibility(View.GONE);
            zekr.setVisibility(View.GONE);
            farsi.setVisibility(View.GONE);
            tv_subtitle.setVisibility(View.GONE);

        }

        if (bundle.containsKey("saturday")) {
            toolbar.setText(R.string.saturday);
            tv_arabic.setText(R.string.saturday_arabic);
            tv_farsi.setText(R.string.saturday_farsi);
        }

        if (bundle.containsKey("sunday")) {
            toolbar.setText(R.string.sunday);
            tv_arabic.setText(R.string.sunday_arabic);
            tv_farsi.setText(R.string.sunday_farsi);
        }

        if (bundle.containsKey("monday")) {
            toolbar.setText(R.string.monday);
            tv_arabic.setText(R.string.monday_arabic);
            tv_farsi.setText(R.string.monday_farsi);
        }

        if (bundle.containsKey("tuesday")) {
            toolbar.setText(R.string.tuesday);
            tv_arabic.setText(R.string.tuesday_arabic);
            tv_farsi.setText(R.string.tuesday_farsi);
        }

        if (bundle.containsKey("wednesday")) {
            toolbar.setText(R.string.wednesday);
            tv_arabic.setText(R.string.wednesday_arabic);
            tv_farsi.setText(R.string.wednesday_farsi);
        }

        if (bundle.containsKey("thursday")) {
            toolbar.setText(R.string.thursday);
            tv_arabic.setText(R.string.thursday_arabic);
            tv_farsi.setText(R.string.thursday_farsi);
        }

        if (bundle.containsKey("friday")) {
            toolbar.setText(R.string.friday);
            tv_arabic.setText(R.string.friday_arabic);
            tv_farsi.setText(R.string.friday_farsi);
        }



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    public void showAdd() {
        AdiveryBannerAdView bannerAd = findViewById(R.id.banner_ad);

        bannerAd.setBannerAdListener(new AdiveryAdListener() {
            @Override
            public void onAdLoaded() {
                // تبلیغ به‌طور خودکار نمایش داده می‌شود، هر کار دیگری لازم است اینجا انجام دهید.
            }

            @Override
            public void onError(String reason) {
                // خطا را چاپ کنید تا از دلیل آن مطلع شوید
            }

            @Override
            public void onAdClicked() {
                // کاربر روی بنر کلیک کرده
            }
        });

        bannerAd.loadAd();

    }
}