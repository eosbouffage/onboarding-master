package com.eosinfotech.onboarder;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.ViewGroup;

import com.eosinfotech.onboarder.utils.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

public class OnboarderAdapter extends FragmentStatePagerAdapter implements ShadowTransformer.CardAdapter {

    private String TAG = OnboarderAdapter.class.getSimpleName();
    List<OnboarderCard> pages = new ArrayList<OnboarderCard>();
    private List<OnboarderFragment> mFragments = new ArrayList<>();
    private float mBaseElevation;
    private Typeface typeface;

    public OnboarderAdapter(List<OnboarderCard> pages, FragmentManager fm, float baseElevation, Typeface typeface) {
        super(fm);
        this.pages = pages;
        this.typeface = typeface;
        this.mBaseElevation = baseElevation;

        for (int i = 0; i < pages.size(); i++) {
            addCardFragment(pages.get(i));
        }

        //setTypeface(typeface);

    }

    @Override
    public Fragment getItem(int position) {
        //return OnboarderFragment.newInstance(pages.get(position));
        return mFragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (OnboarderFragment) fragment);
        return fragment;
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        setTypeface(typeface, position);
        return mFragments.get(position).getCardView();
    }

    public void addCardFragment(OnboarderCard page) {
        mFragments.add(OnboarderFragment.newInstance(page));
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        super.destroyItem(container, position, object);

    }

    public void setTypeface(Typeface typeface, int i) {
        if (typeface != null) {

            if (mFragments.get(i) == null) {
                Log.i(TAG, "Fragment is null");
                return;
            }

            if (mFragments.get(i).getTitleView() == null) {
                Log.i(TAG, "TitleView is null");
                return;
            }

            if (mFragments.get(i).getTitleView() == null) {
                Log.i(TAG, "DescriptionView is null");
                return;
            }

            mFragments.get(i).getTitleView().setTypeface(typeface);
            mFragments.get(i).getDescriptionView().setTypeface(typeface);

        }
    }

}
