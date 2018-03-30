package jp.techacademy.hojun.bun.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


import io.realm.Realm;
import io.realm.RealmResults;

public class InputCategoryActivity extends AppCompatActivity {

    private EditText mCategoryEdit;
    private Category mCategory;

    private View.OnClickListener mOnDoneClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCategory();
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // ActionBarを設定する
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // UI部品の設定
        findViewById(R.id.done_button).setOnClickListener(mOnDoneClickListener);
        mCategoryEdit =  findViewById(R.id.category_edit_text);


    }

    private void addCategory() {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        if (mCategory == null) {
            // 新規作成の場合
            mCategory = new Category();

            RealmResults<Category> taskRealmResults = realm.where(Category.class).findAll();

        }

        String category = mCategoryEdit.getText().toString();

        mCategory.setCategory(category);

        realm.copyToRealmOrUpdate(mCategory);
        realm.commitTransaction();

        realm.close();


    }
}