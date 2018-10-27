package com.eosinfotech.onboarding;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Toast;

import com.eosinfotech.onboarder.OnboarderActivity;
import com.eosinfotech.onboarder.OnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class SolidBackgroundExampleActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboarderCard OnboarderCard1 = new OnboarderCard("Scan Barcode", "Label your packages with a barcode before we collect it from you.", R.drawable.barcode);
        OnboarderCard OnboarderCard2 = new OnboarderCard("Shipping", "Our huge network of shipping partners ensures that your packages are always on schedule.", R.drawable.truck);
        OnboarderCard OnboarderCard3 = new OnboarderCard("Payment", "Receive payments immediately after the package is delivered.", R.drawable.wallet);

        OnboarderCard1.setBackgroundColor(R.color.white);
        OnboarderCard2.setBackgroundColor(R.color.white);
        OnboarderCard3.setBackgroundColor(R.color.white);

        List<OnboarderCard> pages = new ArrayList<>();

        pages.add(OnboarderCard1);
        pages.add(OnboarderCard2);
        pages.add(OnboarderCard3);

        for (OnboarderCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.grey_600);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(false);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.solid_one);
        colorList.add(R.color.solid_two);
        colorList.add(R.color.solid_three);

        setColorBackground(colorList);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    }
}
