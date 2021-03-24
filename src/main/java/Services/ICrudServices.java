package services;

import java.sql.SQLException;
import java.util.List;

import model.Identity;

public interface ICrudServices<T extends Identity> {

    void Insert(T obj) throws SQLException;

    void Edit(T obj) throws SQLException;

    void Delete(int id) throws SQLException;

    T Find(int id) throws SQLException;

    List<T> GetAll(int id) throws SQLException;

}
