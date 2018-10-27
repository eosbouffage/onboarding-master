package com.eosinfotech.onboarding;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Toast;

import com.eosinfotech.onboarder.OnboarderActivity;
import com.eosinfotech.onboarder.OnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class ImageBackgroundExampleActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboarderCard OnboarderCard1 = new OnboarderCard("Link Cards", "Sign up for free by activating your credit cards.", R.drawable.spend);
        OnboarderCard OnboarderCard2 = new OnboarderCard("Dine Out", "Choose from 100's of restaurants with new spots added daily.", R.drawable.food);
        OnboarderCard OnboarderCard3 = new OnboarderCard("Get Cashback", "Earn upto 30% each time you dine with linked cards in network.", R.drawable.reward);

        OnboarderCard1.setBackgroundColor(R.color.black_transparent);
        OnboarderCard2.setBackgroundColor(R.color.black_transparent);
        OnboarderCard3.setBackgroundColor(R.color.black_transparent);

        List<OnboarderCard> pages = new ArrayList<>();

        pages.add(OnboarderCard1);
        pages.add(OnboarderCard2);
        pages.add(OnboarderCard3);

        for (OnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        //setGradientBackground();
        setImageBackground(R.drawable.download);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    }
}
