package com.moinonemoi.kode.app.presentation.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.presentation.main.CategoryAdapter;
import com.moinonemoi.kode.app.presentation.main.FragmentAdapter;
@Deprecated
public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerViewCategory;
    CategoryAdapter categoryAdapter;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        /*tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("Hi"));
        tabLayout.addTab(tabLayout.newTab().setText("Hello"));
        tabLayout.addTab(tabLayout.newTab().setText("Privet"));

        FragmentManager fragmentManager = getSupportFragmentManager();

        adapter = new FragmentAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapter);*/

       /* tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

       /* viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
*/


/*
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"android"));
        categories.add(new Category(2,"ios"));
        categories.add(new Category(3,"design"));
        categories.add(new Category(4,"management"));
        categories.add(new Category(5,"qa"));
        categories.add(new Category(6,"back_office"));
        categories.add(new Category(7,"frontend"));
        categories.add(new Category(9,"hr"));
        categories.add(new Category(10,"pr"));
        categories.add(new Category(11,"backend"));
        categories.add(new Category(12,"support"));
        categories.add(new Category(13,"analytics"));

        setRecyclerViewCategory(categories);*/
    }

    private void initView() {
    }
   /* private void setRecyclerViewCategory (List<Category> categories) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        recyclerViewCategory.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categories);
        recyclerViewCategory.setAdapter(categoryAdapter);

    }*/


}