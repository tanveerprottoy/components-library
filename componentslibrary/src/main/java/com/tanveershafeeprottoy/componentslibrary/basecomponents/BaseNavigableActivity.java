package com.tanveershafeeprottoy.componentslibrary.basecomponents;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class BaseNavigableActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
