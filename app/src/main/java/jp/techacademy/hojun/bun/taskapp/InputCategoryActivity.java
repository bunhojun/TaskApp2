package jp.techacademy.hojun.bun.taskapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import io.realm.Realm;
import io.realm.RealmResults;

public class InputCategoryActivity extends AppCompatActivity {

    private EditText mCategoryEdit;
    private Category mCategory;


    private View.OnClickListener mOnCategoryInputClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addNewCategory();
            finish();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_category);

        // ActionBarを設定する
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // UI部品の設定

        findViewById(R.id.categoryInputButton).setOnClickListener(mOnCategoryInputClickListener);
        mCategoryEdit =  findViewById(R.id.category_edit_text);

    }


    private void addNewCategory() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

            // 新規作成
            mCategory = new Category();
        RealmResults<Category> categoryRealmResults = realm.where(Category.class).findAll();
            int identifier;
            if (categoryRealmResults.max("id") != null) {
                identifier = categoryRealmResults.max("id").intValue() + 1;
            } else {
                identifier = 0;
            }
            mCategory.setId(identifier);
        String category = mCategoryEdit.getText().toString();
        mCategory.setCategory(category);
        realm.copyToRealmOrUpdate(mCategory);
        realm.commitTransaction();



        realm.close();
    }

}
