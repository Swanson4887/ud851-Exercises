/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    // TODO (1) Create a private static final int called NUM_LIST_ITEMS and set it equal to 100
    private static final int NUM_LIST_ITEMS = 100;

    // TODO (2) Create a GreenAdapter variable called mAdapter
    // TODO (3) Create a RecyclerView variable called mNumbersList
    GreenAdapter mAdapter;

    RecyclerView mNumbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new GreenAdapter(NUM_LIST_ITEMS);
        // TODO (9) Set the GreenAdapter you created on mNumbersList
        mNumbersList.setAdapter(mAdapter);
    }
}
