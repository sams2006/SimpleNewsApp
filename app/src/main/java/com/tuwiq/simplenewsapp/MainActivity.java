package com.tuwiq.simplenewsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
   RecyclerView.LayoutManager mLinearLayout ;
   RecyclerView.LayoutManager mGridLayout ;
   List<NewsItem> list ;
   Menu listGridMenu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        mLinearLayout = new LinearLayoutManager(this);
        mGridLayout = new GridLayoutManager(this , 3) ;

        list = GeneratorList.generateList(30) ;
        NewsAdapter newsAdapter = new NewsAdapter(list, new OnListItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemSelected(position);
            }
        });
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(mLinearLayout);
    }



    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        this.listGridMenu = menu ;
        getMenuInflater().inflate(R.menu.menu_list_grid , menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_grid:
                recyclerView.setLayoutManager(mGridLayout);
                item.setVisible(false);
                listGridMenu.findItem(R.id.action_list).setVisible(true) ;
                return true ;
            case R.id.action_list:
                recyclerView.setLayoutManager(mLinearLayout);
                item.setVisible(false);
                listGridMenu.findItem(R.id.action_grid).setVisible(true);
                return true ;

        }
        return super.onOptionsItemSelected(item);
    }
    private void itemSelected(int position) {
        NewsItem selectedItem = list.get(position) ;
        String message = "لقد اخترت الخبر رقم" + position + "وهو يحتوي على العنوان " + selectedItem.getTitle() ;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}