package Services;

import java.sql.SQLException;
import java.util.List;

import model.Identity;

public interface ICrudServices<T extends Identity, U> {

    void Insert(T obj) throws SQLException;

    void Edit(T obj) throws SQLException;

    void Delete(int id) throws SQLException;

    U Find(int id) throws SQLException;

    List<U> GetAll() throws SQLException;

}
