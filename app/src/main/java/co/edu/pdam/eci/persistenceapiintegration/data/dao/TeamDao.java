package co.edu.pdam.eci.persistenceapiintegration.data.dao;

import android.arch.persistence.room.Entity;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;

/**
 * @author Santiago Carrillo
 */
@Entity
public interface TeamDao
    extends BaseDao<Team, Long>
{
}
