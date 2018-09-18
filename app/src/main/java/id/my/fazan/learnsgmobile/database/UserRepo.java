package id.my.fazan.learnsgmobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import id.my.fazan.learnsgmobile.model.User;

public class UserRepo {
    private DBHelper dbHelper;

    public UserRepo(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public int insert(User user){
        // Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(User.KEY_nama, user.nama);
        values.put(User.KEY_umur, user.umur);
        values.put(User.KEY_gender, user.gender);

        long id = db.insert(User.TABLE, null, values);
        db.close();
        return (int)id;
    }

    public void delete(int id){
        // Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(User.TABLE, User.KEY_ID+ "= ?", new String[] { String.valueOf(id) });
        db.close();

    }

    public void update(User user){
        // Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(User.KEY_nama, user.nama);
        values.put(User.KEY_umur, user.umur);
        values.put(User.KEY_gender, user.gender);

        db.update(User.TABLE, values, User.KEY_ID+ "= ?", new String[] { String.valueOf(user.id) });
    }

    public ArrayList<User> getUserList(){
        // Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Bikin query select
        String selectQuery = "SELECT * FROM " + User.TABLE;

        // inisialisasi user list
        ArrayList<User> userList = new ArrayList<>();

        // EKsekusi query
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Jika datanya ada dan cursor ngarah ke data pertama
        if (cursor.moveToFirst()){
            //looping sampai data terakhir
            do{
                User user = new User();
                user.id = cursor.getInt(cursor.getColumnIndex(User.KEY_ID));
                user.nama = cursor.getString(cursor.getColumnIndex(User.KEY_nama));
                user.gender = cursor.getString(cursor.getColumnIndex(User.KEY_gender));
                user.umur = cursor.getInt(cursor.getColumnIndex(User.KEY_umur));
                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }
}
