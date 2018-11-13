package co.edu.pdam.eci.persistenceapiintegration.data.network;

public interface RequestCallback<T>
{

    void onSuccess( T response );

    void onFailed( NetworkException e );

}