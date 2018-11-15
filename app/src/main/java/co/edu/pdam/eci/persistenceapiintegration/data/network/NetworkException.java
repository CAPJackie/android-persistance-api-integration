package co.edu.pdam.eci.persistenceapiintegration.data.network;

import java.io.IOException;

public class NetworkException extends Exception{
    public NetworkException(int i, Object o, IOException e) {
        super(e);
    }
}
