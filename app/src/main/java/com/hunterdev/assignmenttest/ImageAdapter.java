package com.hunterdev.assignmenttest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.content.Context.BATTERY_SERVICE;

public class ImageAdapter extends BaseAdapter {

    private List<String> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    ViewHolder holder;

    ImageAdapter(Context aContext, List<String> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return  listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_imge, null);
            holder = new ViewHolder();
            holder.flagView = convertView.findViewById(R.id.imageView);
            holder.txtv_progress = convertView.findViewById(R.id.txtv_progress);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String URL = listData.get(i);

        holder.flagView.setTag(URL);
        new DownloadImagesTask().execute(holder.flagView);

        return convertView;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView txtv_progress;
    }

    @SuppressLint("StaticFieldLeak")
    public class DownloadImagesTask extends AsyncTask<ImageView, Integer, Bitmap> {
        @SuppressLint("StaticFieldLeak")
        private
        ImageView imageView = null;

        @Override
        protected Bitmap doInBackground(ImageView... imageViews) {
            this.imageView = imageViews[0];
            try {
                java.net.URL url = new java.net.URL((String) imageView.getTag());
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();

                int lenghtOfFile = connection.getContentLength();

                InputStream input = connection.getInputStream();
               /* byte data[] = new byte[1024];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress((int)((total*100)/lenghtOfFile));
                }*/
                return BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /*@SuppressLint("SetTextI18n")
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtv_progress.setText(String.valueOf(values[0]) + "%");
        }*/

        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
            holder.txtv_progress.setVisibility(View.GONE);
        }
    }
}