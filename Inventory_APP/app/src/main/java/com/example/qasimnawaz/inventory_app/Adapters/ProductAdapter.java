package com.example.qasimnawaz.inventory_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qasimnawaz.inventory_app.Models.Products;
import com.example.qasimnawaz.inventory_app.R;

import java.util.ArrayList;

/**
 * Created by Qasim Nawaz on 10/26/2016.
 */

public class ProductAdapter extends BaseAdapter{
    private ArrayList<Products> mProductsArrayList;
    private Context mContext;

    public ProductAdapter(ArrayList<Products> mProductsArrayList, Context mContext) {
        this.mProductsArrayList = mProductsArrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mProductsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductsArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.product_layout,null);

        Products product = mProductsArrayList.get(position);

        TextView nameView = (TextView) view.findViewById(R.id.product_nameView);
        TextView quantityView = (TextView) view.findViewById(R.id.product_QuantityView);
        TextView priceView = (TextView) view.findViewById(R.id.product_priceView);


        nameView.setText(product.getProdutName());
        quantityView.setText("Quantity :" + String.valueOf(product.getpQuantity()));
        priceView.setText("PKR " + String.valueOf(product.getpPrice()) + "/");


        return view;
    }
}
