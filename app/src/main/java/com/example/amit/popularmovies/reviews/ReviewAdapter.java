package com.example.amit.popularmovies.reviews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.amit.popularmovies.R;

import java.util.ArrayList;


public class ReviewAdapter extends ArrayAdapter<MovieReviewModel> {
    private ArrayList<MovieReviewModel> mReviewData = new ArrayList<>();

    public static class ViewHolder{
        public TextView author;
        public TextView content;
    }

    public ReviewAdapter(Context context, int layoutResourceId, ArrayList<MovieReviewModel> reviews){
        super(context, layoutResourceId, reviews);
        this.mReviewData = reviews;
    }

    @Override
    public int getCount(){
        return this.mReviewData.size();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_review, parent, false);
            viewHolder.author = (TextView) convertView.findViewById(R.id.text_view_author);
            viewHolder.content = (TextView) convertView.findViewById(R.id.text_view_content);
            convertView.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder)convertView.getTag();

        MovieReviewModel movieReviewModel = mReviewData.get(pos);
        Log.v("ReviewAdapter",movieReviewModel.mAuthor);
        viewHolder.author.setText(getContext().getString(R.string.reviewby_text)+" "+movieReviewModel.mAuthor);
        viewHolder.content.setText(movieReviewModel.mContent);

        return convertView;
    }
}
