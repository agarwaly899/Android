package com.example.safe_earn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VehicleActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference dbReference;
    Button enter;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        radioGroup = (RadioGroup)findViewById(R.id.vehicle_selection);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });

        enter=findViewById(R.id.proceed);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        dbReference= FirebaseDatabase.getInstance().getReference("users").child(user.getUid());
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userEmail=dataSnapshot.child("email").getValue().toString();
                showToast(userEmail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxspeed=40;
//             code here
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(VehicleActivity.this,
                            "No answer has been selected",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton
                            = (RadioButton)radioGroup
                            .findViewById(selectedId);

                    // Now display the value of selected item
                    // by the Toast message
                    if(radioButton.getText().equals("Two wheeler")){
                        maxspeed=70;
                    }
                    else if(radioButton.getText().equals("Cars")){
                        maxspeed=50;
                    }
                    else if(radioButton.getText().equals("Vans")){
                        maxspeed=40;
                    }
                    else if(radioButton.getText().equals("Tampo")){
                        maxspeed=40;
                    }
                    else if(radioButton.getText().equals("Bus")){
                        maxspeed=40;
                    }
                    else {
                        maxspeed=40;
                    }
                }
                Intent i=new Intent(VehicleActivity.this,MenuActivity.class);
                i.putExtra("maxx",maxspeed);
                finish();
                startActivity(i);
            }
        });
    }
    public void showToast(String e){
        Toast.makeText(this,"Logged in as "+e,Toast.LENGTH_SHORT).show();
    }
    @Override // this is method to create menu three dots
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }
    @Override // this is method to create menu three dots
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logout:
                AlertDialog alertDialog;

                new AlertDialog.Builder(this)
                        .setTitle("Exit :")
                        .setMessage("Are you sure you want to logout ?")
                        .setNegativeButton(android.R.string.no, null)
                        .setPositiveButton(android.R.string.yes, new Dialog.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                auth.signOut();
                                finish();
                                startActivity(new Intent(VehicleActivity.this,MainActivity.class));
                            }
                        }).create().show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(VehicleActivity.this,MainActivity.class));
    }
}
