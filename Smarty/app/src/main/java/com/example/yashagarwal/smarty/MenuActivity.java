package com.example.yashagarwal.smarty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        private int flag = 0;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.homy:
                    hometitle();
                    homevis();
                    return true;
                case R.id.mode:
                    modetitle();
                    modevis();
                    return true;
                case R.id.sensor:
                    if (flag == 0) {
                        callToast("ON");
                        flag = 1;

                    } else {
                        callToast("OFF");
                        flag = 0;

                    }
                    return false;
                case R.id.reminder:
                    Intent intent = new Intent(Intent.ACTION_INSERT)
                            .setData(CalendarContract.Events.CONTENT_URI)
                            .putExtra(CalendarContract.Events.TITLE, "Smarty Reminder");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    return false;
                case R.id.alarm:
                    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                    i.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
                    startActivity(i);
                    return false;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        final ArrayList<Sweet> Sweets = new ArrayList<Sweet>();
        Sweets.add(new Sweet("Air Conditioner", R.drawable.ac));
        Sweets.add(new Sweet("Water Cooler", R.drawable.aircooler));
        Sweets.add(new Sweet("Table Lamp", R.drawable.lamp));
        Sweets.add(new Sweet("Tubelight", R.drawable.tubelight));
        Sweets.add(new Sweet("Light Bulb", R.drawable.bulb));
        Sweets.add(new Sweet("Television", R.drawable.tv));
        Sweets.add(new Sweet("Ceiling Fan", R.drawable.fan));
        Sweets.add(new Sweet("3 Pin Socket", R.drawable.socket3));
        Sweets.add(new Sweet("2 Pin Socket", R.drawable.socket2));

        SweetAdapter sweetAdapter =
                new SweetAdapter(this, Sweets);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(sweetAdapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Sweet sweet = Sweets.get(position);
//
//            }
//        });
        final ArrayList<Sweet> Sweets2 = new ArrayList<Sweet>();
        Sweets2.add(new Sweet("Bedroom", R.drawable.bed1));
        Sweets2.add(new Sweet("Dinning room", R.drawable.din1));
        Sweets2.add(new Sweet("Drawing room", R.drawable.draw1));
        Sweets2.add(new Sweet("Study room", R.drawable.study1));
        Sweets2.add(new Sweet("Kitchen", R.drawable.kit1));
        Sweets2.add(new Sweet("Game room", R.drawable.game1));
        Sweets2.add(new Sweet("Living room", R.drawable.liv1));
        Sweets2.add(new Sweet("Guest room", R.drawable.guest1));
        Sweets2.add(new Sweet("Store room", R.drawable.store1));

        SweetAdapter sweetAdapter2 =
                new SweetAdapter(this, Sweets2);

        GridView gridView2 = (GridView) findViewById(R.id.gridviewroom);

        gridView2.setAdapter(sweetAdapter2);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sweet sweet2 = Sweets2.get(position);
                Intent i = new Intent(MenuActivity.this, FunctionActivity.class);
                i.putExtra("namo",sweet2.getSweet());
                startActivity(i);
                finish();
            }
        });

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Chill Mode"));
        words.add(new Word("Sleep Mode"));
        words.add(new Word("Party Mode"));
        words.add(new Word("Study Mode"));
        words.add(new Word("Workout Mode"));
        words.add(new Word("Occasion Mode"));
        words.add(new Word("Add Custom Mode"));

        WordAdapter wordAdapter =
                new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.modelist);

        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                callToastMode(word.getMiwokTranslation());
            }
        });

        ImageView image1=(ImageView) findViewById(R.id.clap);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToastGesture("Clap");
            }
        });

        ImageView image2=(ImageView) findViewById(R.id.snap);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToastGesture("Snap");
            }
        });

        ImageView image3=(ImageView) findViewById(R.id.voice);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToastGesture("voice");
            }
        });

        ImageView image4=(ImageView) findViewById(R.id.sound);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToastGesture("custom");
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView call = (TextView) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8078653944"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        TextView email = (TextView) findViewById(R.id.supportemail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:yagarwal687@gmail.com")); // only email apps should handle this
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Help !");
//                intent.putExtra(Intent.EXTRA_TEXT, "Your problem here :\n\n");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (checkvisiprofile()) {
                mainhomevisi();
                hometitle();
                homevis();
                navigation.setSelectedItemId(R.id.homy);
                navigationView.getMenu().getItem(0).setChecked(false);
            } else if (checkvisigesture()) {
                mainhomevisi();
                hometitle();
                homevis();
                navigation.setSelectedItemId(R.id.homy);
                navigationView.getMenu().getItem(2).setChecked(false);
            }
            else if (checkvisiroom()) {
                mainhomevisi();
                hometitle();
                homevis();
                navigation.setSelectedItemId(R.id.room);
                navigationView.getMenu().getItem(1).setChecked(false);
            }
            else if (checkvisisupport()) {
                mainhomevisi();
                hometitle();
                homevis();
                navigation.setSelectedItemId(R.id.homy);
            }
            else if (checkvisiabout()) {
                mainhomevisi();
                hometitle();
                homevis();
                navigation.setSelectedItemId(R.id.homy);
            }

            else {
                if (checkvisimode()) {
                    homevis();
                    navigation.setSelectedItemId(R.id.homy);
                } else {
                    Intent i = new Intent(MenuActivity.this, FunctionActivity.class);
                    startActivity(i);
                    super.onBackPressed();
                }
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_out) {
            AlertDialog alertDialog;

            new AlertDialog.Builder(this)
                    .setTitle("Exit :")
                    .setMessage("Are you sure you want to logout ?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new Dialog.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent i = new Intent(MenuActivity.this, MainActivity.class);
                            startActivity(i);
                            MenuActivity.super.onBackPressed();
                        }
                    }).create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (id == R.id.account) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.gesturelayout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.userprofile);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.supportlayout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.room);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.about);
            ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
            cLayout1.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.VISIBLE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.GONE);
            linearLayout6.setVisibility(LinearLayout.GONE);
            this.getSupportActionBar().setTitle("Profile");
            navigationView.getMenu().getItem(0).setChecked(true);
        } else if (id == R.id.room) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.gesturelayout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.userprofile);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.supportlayout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.room);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.about);
            ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
            cLayout1.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            linearLayout6.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.VISIBLE);
            this.getSupportActionBar().setTitle("Rooms");
            navigationView.getMenu().getItem(1).setChecked(true);

        } else if (id == R.id.gestures) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.gesturelayout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.userprofile);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.supportlayout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.room);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.about);
            ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
            cLayout1.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            linearLayout6.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.VISIBLE);
            this.getSupportActionBar().setTitle("Gestures");
            navigationView.getMenu().getItem(2).setChecked(true);

        } else if (id == R.id.support) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.gesturelayout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.userprofile);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.supportlayout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.room);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.about);
            ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
            cLayout1.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.GONE);
            linearLayout6.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.VISIBLE);
            this.getSupportActionBar().setTitle("Help");
            navigationView.getMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(0).setChecked(false);

        } else if (id == R.id.about) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.gesturelayout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.userprofile);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.supportlayout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.room);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.about);
            ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
            cLayout1.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            linearLayout6.setVisibility(LinearLayout.VISIBLE);
            this.getSupportActionBar().setTitle("About Smarty");
            navigationView.getMenu().getItem(2).setChecked(false);
            navigationView.getMenu().getItem(1).setChecked(false);
            navigationView.getMenu().getItem(0).setChecked(false);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void callToast(String s) {
        Toast.makeText(this, "Sensor switched " + s + " !", Toast.LENGTH_SHORT).show();
    }

    public void callToastMode(String s) {
        if (s.equals("Add Custom Mode"))
        Toast.makeText(this, "Custom Mode will be Added !", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, s+" ON !", Toast.LENGTH_SHORT).show();
    }

    public void callToastGesture(String s) {
        if (s.equals("custom"))
            Toast.makeText(this, "Custom Sound will be Added !", Toast.LENGTH_SHORT).show();
        else if (s.equals("voice"))
            Toast.makeText(this, "Your Voice will be recorded !", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,s+" Gesture ON !",Toast.LENGTH_SHORT).show();
    }

    public void homevis() {
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.menu);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.modes);
        linearLayout1.setVisibility(LinearLayout.GONE);
        linearLayout2.setVisibility(LinearLayout.VISIBLE);
    }

    public void modevis() {
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.menu);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.modes);
        linearLayout2.setVisibility(LinearLayout.GONE);
        linearLayout1.setVisibility(LinearLayout.VISIBLE);
    }

    private void modetitle() {
        this.getSupportActionBar().setTitle("Modes");
    }

    private void hometitle() {
        this.getSupportActionBar().setTitle("Home");
    }

    private boolean checkvisimode() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.modes);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private boolean checkvisiprofile() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.userprofile);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private boolean checkvisiroom() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.room);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private boolean checkvisigesture() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.gesturelayout);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private boolean checkvisisupport() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.supportlayout);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private boolean checkvisiabout() {
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.about);
        return linearLayout1.getVisibility() == LinearLayout.VISIBLE;
    }

    private void mainhomevisi() {
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.userprofile);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.supportlayout);
        ConstraintLayout cLayout1 = (ConstraintLayout) findViewById(R.id.mainhome);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.gesturelayout);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.room);
        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.about);
        cLayout1.setVisibility(LinearLayout.VISIBLE);
        linearLayout2.setVisibility(LinearLayout.GONE);
        linearLayout1.setVisibility(LinearLayout.GONE);
        linearLayout3.setVisibility(LinearLayout.GONE);
        linearLayout4.setVisibility(LinearLayout.GONE);
        linearLayout5.setVisibility(LinearLayout.GONE);
    }
}
