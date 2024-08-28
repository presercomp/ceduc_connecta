package cl.ceduc.connecta;
//Importamos las librerias de conexion
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    //Definimos las constantes de operación de nuestro Ayudante
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ceduc_coneccta.db";
    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    //Este método se dispara cuando se crea la base de datos por primera vez
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_USER = "CREATE TABLE users (" +
                "users_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nickname TEXT, "+
                "secret TEXT, " +
                "active INTEGER )";
        db.execSQL(CREATE_TABLE_USER);
        //Creamos un nuevo usuario para hacer las pruebas
        String NEW_USER = "INSERT INTO users " +
                "(users_id, nickname, secret, active) VALUES "+
                "(1, 'admin', '123456', 1);";
        db.execSQL(NEW_USER);
    }
    //Este método se dispara cuando encuentra una diferencia de version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String CREATE_TABLE_USER = "DROP TABLE IF EXISTS users";
        db.execSQL(CREATE_TABLE_USER);
    }
}
