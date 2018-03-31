package database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import model.User;

public class DatabaseImpl implements Database {
    private final String DATABASE_NAME = "Users";

    private UserDatabase database;

    /*
    * Constructor inits database instance
    * */
    public DatabaseImpl(Context context) {
        database = Room.databaseBuilder(context, UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
    }

    @Override
    public void saveUser(User user) {
        database.userDAO().insertUser(user);
    }

    @Override
    public User findUser(String login) {
        User user = database.userDAO().findUserByLogin(login);
        return user;
    }
}
