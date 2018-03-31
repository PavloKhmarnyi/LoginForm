package database;

import android.arch.persistence.room.*;
import android.arch.persistence.room.Database;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
