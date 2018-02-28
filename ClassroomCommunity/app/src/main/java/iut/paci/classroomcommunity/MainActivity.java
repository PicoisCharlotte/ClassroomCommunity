package iut.paci.classroomcommunity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.toggle;

/**
 * Created by picois on 15/02/2018.
 */

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, FriendFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    TextView login;
    TextView mdp;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    NavigationView nav;
    FragmentManager fm;
    Spinner spinner;
    String [] items = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    TabLayout tabLayout;

    MenuItem nav_menu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);

        nav = (NavigationView) findViewById(R.id.nav_view);
        //nav.setNavigationItemSelectedListener(this);
        nav.getMenu().performIdentifierAction(R.id.nav1, 0);
        nav.bringToFront();
        setupDrawerContent(nav);

        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nav.getMenu().performIdentifierAction(R.id.nav0, 0);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //permet d'activer le clic du bouton
        if (toggle.onOptionsItemSelected(item)){
            return true;
        } else {
            return false;
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;

        if(id == R.id.nav0){
            fragment = new MainFragment();
        } else if (id == R.id.nav1) {
            fragment = new FriendFragment();
        } else if (id == R.id.nav2) {
            fragment = new ProfilFragment();
        } else if (id == R.id.nav3) {
            fragment = new ParametreFragment();
        } else if (id == R.id.nav4) {
            fragment = new AProposFragment();
        } else if (id == R.id.nav5) {
            this.finish();
        }


        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contentFL, fragment);
            ft.commit();
        }

        //NOTE:  Closing the drawer after selecting
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer); //Ya you can also globalize this variable :P
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        for(int indice = 0; indice < items.length ; indice++){
            if(i == indice){
                Toast toast = Toast.makeText(view.getContext(), items[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            selectDrawerItem(menuItem);
                        }
                        return true;
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void selectDrawerItem(MenuItem menuItem) {
        ((FrameLayout)findViewById(R.id.contentFL)).setBackground(null);

        // Creation d'un nouveau fragment que nous mettrons à la place
        // de celle par défaut
        Fragment fragment = null;
        Class fragmentClass = null;
        switch(menuItem.getItemId()) {
            case R.id.nav0:
                fragmentClass = MainFragment.class;
                break;
            case R.id.nav1:
                fragmentClass = FriendFragment.class;
                break;
            case R.id.nav2:
                fragmentClass = ProfilFragment.class;
                break;
            case R.id.nav3:
                fragmentClass = ParametreFragment.class;
                break;
            case R.id.nav4:
                fragmentClass = AProposFragment.class;
                break;
            case R.id.nav5:
                this.finish();
                return;
            default:
                fragmentClass = null;
                return;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // On insert le fragment qui va remplacer celui de base
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentFL, fragment).commit();

        // Surbrillance dans le Navigateur View de l'item séléctionné
        menuItem.setChecked(true);
        // changement du titre de l'action bar
        setTitle(menuItem.getTitle());
        // Fermeture du Drawer qui contient le Navigateur View
        drawer.closeDrawer(GravityCompat.START);

    }
}
