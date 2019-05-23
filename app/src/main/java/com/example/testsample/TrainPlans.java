package com.example.testsample;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.codecrafters.tableview.TableView;

public class TrainPlans extends AppCompatActivity {

    static de.codecrafters.tableview.TableView tableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_plans);
        tableView= (de.codecrafters.tableview.TableView) findViewById(R.id.tableView);
    }
}
