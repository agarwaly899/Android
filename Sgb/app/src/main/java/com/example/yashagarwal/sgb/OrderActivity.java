package com.example.yashagarwal.sgb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    int quantity=0;
    int quantity2=250;
    double pric;
    String item,name,mobile,address;

    public void increament(View view) {
        if(!(quantity>=100)) {
            quantity++;
            display(quantity);
        }
    }
    public void decreament(View view) {
        if(!(quantity<=0)) {
            quantity--;
            display(quantity);
        }
        else if (quantity==0){
            Toast.makeText(getApplicationContext(),"Quantity can't be less than 0kg",Toast.LENGTH_SHORT).show();
        }
    }
    public void increa(View view) {
        if(!(quantity2>=750)) {
            quantity2=quantity2+250;
            display2(quantity2);
        }
    }
    public void decrea(View view) {
        if(!(quantity2<=0)) {
            quantity2=quantity2-250;
            display2(quantity2);
        }
        else if (quantity2==0){
            Toast.makeText(getApplicationContext(),"Quantity can't be less than 0g",Toast.LENGTH_SHORT).show();
        }
    }
    public void submitOrder(View view) {
        EditText nameview=(EditText) findViewById(R.id.name_view);
        name=nameview.getText().toString();
        EditText mobileview=(EditText) findViewById(R.id.mobile_view);
        mobile=mobileview.getText().toString();
        EditText addressview=(EditText) findViewById(R.id.address_view);
        address=addressview.getText().toString();
        if (quantity==0 && quantity2==0){
            Toast.makeText(getApplicationContext(),"you can't order 0g of sweet!",Toast.LENGTH_SHORT).show();
        }
        else {
            if (!(name.isEmpty()) && !(mobile.isEmpty()) && !(address.isEmpty())) {

                int price = calculatePrice();
                String Mess = createOrderSummary(price);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:sukhadiabhargav@gmail.com")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for " + name);
                intent.putExtra(Intent.EXTRA_TEXT, Mess);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            } else if (name.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Some field is left empty!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pric = extras.getInt("price");
            item = extras.getString("item");
        }
        TextView items=(TextView)findViewById(R.id.item);
        items.setText(item);
    }
    private int calculatePrice(){
        int total;
        total=(int)(quantity*pric+quantity2*(pric/1000));
        return total;
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.kilo_text_view);
        quantityTextView.setText("" + number);
    }
    private void display2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.gram_text_view);
        quantityTextView.setText("" + number);
    }
    private String createOrderSummary(int price){
        String mess="Name : "+name+"\nMobile : "+mobile+"\nAddress : "+address+"\nItem : "+item+"\nQuantity : "+quantity+" Kg and "+quantity2+" g"+"\nPrice : ₹ "+price+"\nThank You!";
        return mess;
    }
}
