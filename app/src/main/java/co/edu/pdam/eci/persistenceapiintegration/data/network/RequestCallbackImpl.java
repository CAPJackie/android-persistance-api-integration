package co.edu.pdam.eci.persistenceapiintegration.data.network;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;

public class RequestCallbackImpl implements RequestCallback {
    @Override
    public void onSuccess(Object response) {
        for(Team t : (List<Team>) response){
            System.out.println(t.id + " NAME: " + t.name);
        }
        //System.out.println("Response data: " + ((List<Team>) response).size());
    }

    @Override
    public void onFailed(NetworkException e) {
        e.printStackTrace();
    }
}
