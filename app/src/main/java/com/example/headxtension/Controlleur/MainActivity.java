package com.example.headxtension.Controlleur;

import android.os.Bundle;

import com.example.headxtension.Modele.HeadXtensionDAO;
import com.example.headxtension.Modele.Session;
import com.example.headxtension.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activité principale","OK");
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        Session session = Session.getInstance();
        session.Initialize(getApplicationContext());

        //deleteDatabase(getString(R.string.dbName));
        // aaAA11&&
        //njiwJQA6CscGPriBsw2GkQ==

        /*
         * Entrée : l'utilisateur s'est déjà connecté auparavant
         *          => on continu les vérifs
         *
         * Sinon => on continu les vérifs
         */
        if(!session.getRegistrationState() || !session.getAuthenticationState()) {
            navController.navigate(R.id.SigninFragment);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
