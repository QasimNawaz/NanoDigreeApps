package com.example.qasimnawaz.inventoryapp.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qasimnawaz.inventoryapp.Adapters.SalesAdapter;
import com.example.qasimnawaz.inventoryapp.DataBase.ProductDataBase;
import com.example.qasimnawaz.inventoryapp.DataBase.SalesDataBase;
import com.example.qasimnawaz.inventoryapp.Models.Products;
import com.example.qasimnawaz.inventoryapp.Models.Sales_Details;
import com.example.qasimnawaz.inventoryapp.R;

import java.util.ArrayList;

/**
 * Created by Qasim Nawaz on 10/26/2016.
 */

public class DetailLayout extends android.support.v4.app.Fragment{

    private ListView salesListView;
    private ArrayList<Sales_Details> mSalesArrayList ;
    private ArrayList<Products> mProductArray;
    //  private FloatingActionButton fabButton;
    private SalesDataBase salesDatabase;
    private ProductDataBase mProductDatabase;
    private SalesAdapter saleAdapter;
    public DetailLayout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail_layout, container, false);

        mSalesArrayList = new ArrayList<>();
        mProductArray = new ArrayList<>();
        salesListView = (ListView) view.findViewById(R.id.sales_list);
        // fabButton = (FloatingActionButton) view.findViewById(R.id.fab_salesbutton);

        getSale();
        addSale();

        return view;
    }

    private void addSale() {


    }

    private void getSale() {
        salesDatabase = new SalesDataBase(getActivity().getApplicationContext());
        mProductDatabase = new ProductDataBase(getActivity().getApplicationContext());
        mSalesArrayList = salesDatabase.getSale();
        mProductArray = mProductDatabase.getProduct();
        saleAdapter = new SalesAdapter(mSalesArrayList,getActivity());
        salesListView.setAdapter(saleAdapter);
        saleAdapter.notifyDataSetChanged();

        salesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    View vieww = LayoutInflater.from(getActivity()).inflate(R.layout.sale_alertview, null);
                    final EditText edt = (EditText) vieww.findViewById(R.id.edit_saleOrder);
                    builder.setTitle("Order");
                    builder.setMessage("Write the Quantity to order from the Supplier...?");
                    builder.setPositiveButton("Order", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            int id = mSalesArrayList.get(position).getSid();
                            Log.d("hh", String.valueOf(mProductArray.get(position).getpQuantity()));
                            Log.d("hhh", String.valueOf(id));
//
                            int orderNo = Integer.valueOf(edt.getText().toString()) + mSalesArrayList.get(position).getsQuantityLeft();
////                       // mProductArray.add()
                            mProductDatabase.updateOrder(id, orderNo);
                            saleAdapter.notifyDataSetChanged();

                        }
                    });
                    builder.setNegativeButton("Delete Details", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            int id = mSalesArrayList.get(position).getSid();
                            salesDatabase.deleteProduct(id);
                            mSalesArrayList.remove(position);
                            saleAdapter.notifyDataSetChanged();
                        }
                    });
                    builder.setView(vieww);
                    builder.create().show();
                }catch (Exception es){
                    es.printStackTrace();
                }
            }
        });
    }

    public void refresh(){
        getSale();
    }
}
