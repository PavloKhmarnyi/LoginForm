package database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    List<User> getUserList();

    @Query("SELECT * FROM User WHERE id LIKE :id")
    User findUserById(int id);

    @Query("SELECT * FROM User WHERE login LIKE :login")
    User findUserByLogin(String login);

    @Insert
    void insertUser(User user);
}
