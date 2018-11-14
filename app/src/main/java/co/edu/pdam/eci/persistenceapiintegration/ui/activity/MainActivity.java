package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.AppDatabase;
import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;
import co.edu.pdam.eci.persistenceapiintegration.data.network.RequestCallback;
import co.edu.pdam.eci.persistenceapiintegration.data.network.RequestCallbackImpl;
import co.edu.pdam.eci.persistenceapiintegration.data.network.RetrofitNetwork;

public class MainActivity
    extends AppCompatActivity
{



    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "laboratorio_db").allowMainThreadQueries().build();

        Team skt = new Team(14, "SKT Telecom T1", "SKTT1", "https://las.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/banner_finalfight_skt.jpg?itok=uSete1fY");
        Team rng = new Team(15, "Royal Never Give Up", "RNG", "https://d1u5p3l4wpay3k.cloudfront.net/lolesports_gamepedia_en/e/eb/Royal_Never_Give_Uplogo_square.png?version=7318e9be7c643256053ba1f80475fd13");

        db.teamDao().insertAll(new Team[]{skt, rng});



        List<Team> teamsCreated = db.teamDao().getAll();
        System.out.println(teamsCreated.size());


        ExecutorService executorService = Executors.newFixedThreadPool( 1 );

        executorService.execute( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    //Network request code goes here
                    RetrofitNetwork retrofitObject = new RetrofitNetwork();
                    RequestCallback<List<Team>> rc = new RequestCallbackImpl();
                    retrofitObject.getTeams(new RequestCallback<List<Team>(){



                        @Override void onSuccess(List<Team> response ){

                        }

                        @Override void onFailed( NetworkException e ){


                        }
                    });
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        } );
    }
}
