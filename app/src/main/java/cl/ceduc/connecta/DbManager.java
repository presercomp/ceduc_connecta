package cl.ceduc.connecta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {
    private DbHelper dbHelper;
    private SQLiteDatabase database;

    DbManager(Context context){
        dbHelper = new DbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Cursor getUsers() {
        String[] columns = {"nickname", "secret"};
        return database.query("users", columns, null, null, null, null, null);
    }
}
