package com.khieuthichien.viewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.question.Question;

import java.util.ArrayList;
import java.util.List;

public class CheckAnswerAdapter extends BaseAdapter {

    ArrayList listData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question question = (Question) getItem(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_girdview_list_answer, parent, false);
            holder.tvNumAns = convertView.findViewById(R.id.tvNumAns);
            holder.tvAnswer = convertView.findViewById(R.id.tvAnswer);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position + 1;
        holder.tvNumAns.setText("Câu " + i + ": ");
        holder.tvAnswer.setText(question.getTraloi());

        return convertView;
    }

    private static class ViewHolder{

        TextView tvNumAns;
        TextView tvAnswer;

    }

}
