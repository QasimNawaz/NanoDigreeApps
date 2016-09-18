package com.example.qasimnawaz.coffeebreakchalenge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int cream = 12;
    int chocolate = 15;
    int totalCreamRs;
    int totalChocolateRs;
    EditText inputEditText;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = (EditText) findViewById(R.id.inputName);

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void summaryDisplay(String summary4All) {
        TextView summaryTextView = (TextView) findViewById(R.id.SummaryTxtView);
        username = inputEditText.getText().toString();
        summaryTextView.setText("Name: "+username+"\n"+summary4All);
        summaryTextView.setMovementMethod(new ScrollingMovementMethod());
        composeEmail(username+"\n"+summary4All);
//        showMap(Uri.parse("google.streetview:cbll=46.414382,10.013988"));
    }


    public void submitOrder(View view) {
        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.CreamCheckBox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.ChocolateCheckBox);

        if ((chocolateCheckBox.isChecked()) && (creamCheckBox.isChecked())) {
            totalCreamRs = quantity * cream;
            totalChocolateRs = quantity * chocolate;
            summaryDisplay(orderSummary4Both(username));
        } else if (chocolateCheckBox.isChecked()) {
            totalChocolateRs = quantity * chocolate;
            summaryDisplay(orderSummary4Chocolate(username));
        } else if (creamCheckBox.isChecked()) {
            totalCreamRs = quantity * cream;
            summaryDisplay(orderSummary4Cream(username));
        } else {
            Toast.makeText(MainActivity.this, "Choose an item", Toast.LENGTH_SHORT).show();
            summaryDisplay("" + 0);
        }


    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view) {
        if (quantity == 100){
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity ==1){
            return;        }
        quantity = quantity - 1;
        display(quantity);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String orderSummary4Both(String n) {
        String priceMessage = "Quantity:\nWhitecream: " + quantity + "\nChocolate: " + quantity;
        priceMessage = priceMessage + "\nTotal Amount: $" + (totalChocolateRs + totalCreamRs);
        return priceMessage;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String orderSummary4Cream(String n) {
        String priceMessage = "Quantity:\nWhite Cream: " + quantity;
        priceMessage = priceMessage + "\nTotal Amount: $" + totalCreamRs;
        return priceMessage;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String orderSummary4Chocolate(String n) {
        String priceMessage = "Quantity:\nChocolate: " + quantity;
        priceMessage = priceMessage + "\nTotal Amount: $" + totalChocolateRs;
        return priceMessage;
    }






    public void composeEmail(String summary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "qasimnawaz019@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
//
//    public void showMap(Uri geoLocation) {
//        double latitude = 40.714728;
//        double longitude = -73.998672;
//        String label = "ABC Label";
//        String uriBegin = "geo:" + latitude + "," + longitude;
//        Uri uri = Uri.parse(uriBegin);
//        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//    }

}
