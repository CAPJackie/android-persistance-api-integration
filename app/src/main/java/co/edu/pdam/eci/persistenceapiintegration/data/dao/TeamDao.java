package co.edu.pdam.eci.persistenceapiintegration.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;

/**
 * @author Santiago Carrillo
 */
@Dao
public interface TeamDao {
    @Query("SELECT * FROM team")
    List<Team> getAll();

    @Query("SELECT * FROM team WHERE id IN (:teamIds)")
    List<Team> loadAllByIds(int[] teamIds);

    @Query("SELECT * FROM team WHERE name LIKE :name LIMIT 1")
    Team findByName(String name);

    @Query("SELECT * FROM team WHERE shortName LIKE :shortName LIMIT 1")
    Team findByShortName(String shortName);

    @Query("SELECT * FROM team WHERE imageUrl LIKE :imageUrl LIMIT 1")
    Team findByImageUrl(String imageUrl);

    @Insert
    void insertAll(Team... teams);

    @Delete
    void delete(Team team);

}
