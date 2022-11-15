package com.example.kt1_congan_hongkhanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CongAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CongAn> congAns;

    public CongAnAdapter(Context context, int layout, List<CongAn> congAns1) {
        this.context = context;
        this.layout = layout;
        this.congAns = congAns1;
    }

    @Override
    public int getCount() {
        return congAns.size();//tra ve so luong item
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgPicture;
        TextView txtTen,txtCapBac, txtNCTac, txtSao ;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout ,null);
            holder = new ViewHolder();
            // ánh xạ view
            //anh xa
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.textviewName);
            holder.txtCapBac = (TextView) view.findViewById(R.id.textviewCapBac);
            holder.txtNCTac = (TextView) view.findViewById(R.id.textviewNCTac);
            holder.txtSao = (TextView) view.findViewById(R.id.textviewSao);
            holder.imgPicture = (ImageView) view.findViewById(R.id.imageViewPicture);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
//gan gia tri
        CongAn congAn = congAns.get(i);
        holder.txtTen.setText(congAn.getTen());
        holder.txtCapBac.setText(congAn.getCapBac());
        holder.txtNCTac.setText(congAn.getNoCongTac());
        holder.txtSao.setText(congAn.getQuocGiaSoSaoTinhNhiem());
        holder.imgPicture.setImageResource(congAn.getAnh());

        return view;
    }

}
