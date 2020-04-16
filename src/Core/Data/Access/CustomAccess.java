package Core.Data.Access;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public abstract class CustomAccess<T,R> {
    private Dao<T,R> dao;
    protected CustomAccess(ConnectionSource connectionSource, Class cl) throws SQLException {
        dao=DaoManager.createDao(connectionSource, cl);
    }
    public Dao<T,R> getDao() {
        return dao;
    }
    public T getById(R id) throws SQLException {
        return dao.queryForId(id);
    }
    public void update(T query) throws SQLException {
        dao.update(query);
    }
    public void delete(T query) throws SQLException {
        dao.delete(query);
    }
    public void save(T query) throws SQLException {
        dao.create(query);
    }
    public long count() throws SQLException {
        return dao.countOf();
    }
}
