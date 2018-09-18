package id.my.fazan.learnsgmobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import id.my.fazan.learnsgmobile.model.User;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sg_android.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE "+ User.TABLE + "("
                +User.KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                +User.KEY_nama+"TEXT,"
                +User.KEY_umur+"INTEGER,"
                +User.KEY_gender+"TEXT)";

        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
    }
}
