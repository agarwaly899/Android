/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.yashagarwal.coffee;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity=1;
    String cream="false";
    String choco="false";
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void increament(View view) {
        if(!(quantity>=100)) {
            quantity++;
            display(quantity);
        }
    }
    public void decreament(View view) {
        if(!(quantity<=1)) {
            quantity--;
            display(quantity);
        }
        else if (quantity==1){
            Toast.makeText(getApplicationContext(),"Quantity can't be less than 1",Toast.LENGTH_SHORT).show();
        }
    }
    public void submitOrder(View view) {
        EditText nameview=(EditText) findViewById(R.id.name_view);
        name=nameview.getText().toString();
        if (!(name.isEmpty())) {
            CheckBox whipcream = (CheckBox) findViewById(R.id.check_box);
            CheckBox chocolate = (CheckBox) findViewById(R.id.check_box_choco);
            if (whipcream.isChecked() == true) {
                cream = "true";

            }
            if (whipcream.isChecked() == false) {
                cream = "false";
            }
            if (chocolate.isChecked() == true) {
                choco = "true";

            }
            if (chocolate.isChecked() == false) {
                choco = "false";
            }
            int price = calculatePrice();
            String Mess = createOrderSummary(price);
            Intent intu=new Intent(this,Main2Activity.class);
            intu.putExtra("SearchQueryTerm",Mess);
            intu.putExtra("Name",name);
            startActivity(intu);

        }
        else if(name.isEmpty()){
            Toast.makeText(getApplicationContext(),"Name can't be left blank!",Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private int calculatePrice(){
        int pric=5;
        CheckBox whipcream=(CheckBox) findViewById(R.id.check_box);
        CheckBox chocolate=(CheckBox) findViewById(R.id.check_box_choco);
        if (whipcream.isChecked()==true){
            pric+=1;
            }
        if (chocolate.isChecked()==true){
            pric+=2;
        }
        return quantity*pric;
    }
    private String createOrderSummary(int price){
        String mess="Name : "+name+"\nAdd Whipped Cream ? "+cream+"\nAdd Chocolate ? "+choco+"\nQuantity : "+quantity+"\nPrice : $ "+price+"\nThank You!";
        return mess;
    }
}