package com.example.safe_earn.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.safe_earn.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference dbReference;

        TextView email=null;
    TextView uname=null;
    TextView mob1=null;
    TextView reward=null;
    TextView mob2=null;
    TextView distance=null;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
                email= root.findViewById(R.id.profile_id);
        uname= root.findViewById(R.id.profile_user);
        mob1=root.findViewById(R.id.profile_m1);
        reward=root.findViewById(R.id.profile_coin);
        mob2=root.findViewById(R.id.profile_m2);
        distance=root.findViewById(R.id.profile_dis);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        dbReference= FirebaseDatabase.getInstance().getReference("users").child(user.getUid());
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userEmail=dataSnapshot.child("email").getValue().toString();
                String m2=dataSnapshot.child("mob2").getValue().toString();
                String m1=dataSnapshot.child("mob1").getValue().toString();
                String uName=dataSnapshot.child("uname").getValue().toString();
                String dis=dataSnapshot.child("distance").getValue().toString();
                String coin=dataSnapshot.child("rewards").getValue().toString();

                distance.setText(dis);
                uname.setText(uName);
                reward.setText(coin);
                mob1.setText(m1);
                mob2.setText(m2);
                email.setText(userEmail);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}