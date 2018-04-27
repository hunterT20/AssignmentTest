package com.hunterdev.assignmenttest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hunterdev.assignmenttest.data.model.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MAX_THREAD = 4;
    private static final int MIN_THREAD = 2;

    @BindView(R.id.toolbar)     Toolbar toolbar;
    @BindView(R.id.tabs)        TabLayout tabLayout;
    @BindView(R.id.viewpager)   ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        testPalindrome();
        testFindIndex();

        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Image1Fragment(), "IMAGES0");
        adapter.addFragment(new Image1Fragment(), "IMAGES1");
        adapter.addFragment(new Image1Fragment(), "IMAGES2");
        viewPager.setAdapter(adapter);
    }

    private void testPalindrome(){
        int listData[] = { 1, 2, 3, 2, 1};

        LinkedList linkedList = new LinkedList();

        for (int i : listData) {
            linkedList.insertAtEnd(i);
        }

        CheckPalindrome checkPalindrome = new CheckPalindrome();
        Log.e(TAG, "Check Palindrome: " + checkPalindrome.check(linkedList.getStart()));
    }

    private void testFindIndex(){
        int arr[] = {3, 4, 5, 4, 5, 6, 7, 8, 9, 10, 9, 10, 11};
        FindIndex findIndex = new FindIndex();
        Log.e(TAG, "onCreate: " + findIndex.find(arr,11));
    }
}
