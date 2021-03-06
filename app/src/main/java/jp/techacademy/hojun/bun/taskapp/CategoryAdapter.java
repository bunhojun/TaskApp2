package jp.techacademy.hojun.bun.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater = null;
    private List<Category> mCategoryList;

    public CategoryAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setCategoryList(List<Category> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public int getCount() {
        return mCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCategoryList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
        }

        TextView textView1 = convertView.findViewById(android.R.id.text1);
        textView1.setText(mCategoryList.get(position).getCategory());


        return convertView;
    }
}