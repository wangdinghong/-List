package bwf.demo_scroll_message_textview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.igexin.sdk.PushManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AutoScrollMessageListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        PushManager.getInstance().initialize(this.getApplicationContext());

        mListView = (AutoScrollMessageListView) findViewById(R.id.listView);
        List<Data> datas = new ArrayList<>();
        datas.add(new Data("三石","小包碧根果"));
        datas.add(new Data("游志明","百草味 2袋组合"));
        datas.add(new Data("给老婆中车车","中国黄金 Au9999"));
        datas.add(new Data("萌萌大人","凯迪拉克 SRX"));
        mListView.setAdapter(new MyAdapter(datas, MainActivity.this));
        mListView.startTask(3000,2000,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mListView.stopTask();
    }
}
