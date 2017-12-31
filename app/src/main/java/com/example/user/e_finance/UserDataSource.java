package com.example.user.e_finance;

/**
 * Created by KD on 12/31/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.e_finance.UserContract.User;

import java.util.ArrayList;
import java.util.List;



public class UserDataSource {
    private SQLiteDatabase database;
    private UserSQLHelper dbHelper;
    private String[] allColumn = {UserContract.User.COLUMN_NAME, UserContract.User.COLUMN_EMAIL};

    public UserDataSource(Context context) {
        dbHelper = new UserSQLHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertUser(UserRecord userRecord) {
        ContentValues values = new ContentValues();
        values.put(UserContract.User.COLUMN_NAME, userRecord.getName());
        values.put(UserContract.User.COLUMN_EMAIL, userRecord.getEmail());
        values.put(UserContract.User.COLUMN_USERNAME,userRecord.getUsername());
        values.put(UserContract.User.COLUMN_PASSWORD,userRecord.getPassword());
        values.put(UserContract.User.COLUMN_MOBILE,userRecord.getContactno());
        values.put(UserContract.User.COLUMN_ADDRESS,userRecord.getAddress());

        database = dbHelper.getWritableDatabase();
        database.insert(User.TABLE_NAME, null, values);
        database.close();
    }

    public String searchPass(String username){
        database = dbHelper.getWritableDatabase();
        String query = "Select username, password from "+ User.TABLE_NAME;
        Cursor cursor = database.rawQuery(query , null);
        String a,b;
        b = "Not Found!";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(username)){
                    b = cursor.getString(1);
                }
            }while(cursor.moveToNext());

        }
        return b;
    }
    public String seachEmail(String username){
        database = dbHelper.getWritableDatabase();
        String query = "select username, email from "+ User.TABLE_NAME;
        Cursor cursor = database.rawQuery(query , null);
        String a,b;
        b = "Not Found!";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(username)){
                    b = cursor.getString(1);

                }
            }while(cursor.moveToNext());

        }
        return b;
    }

    public List<UserRecord> getAllUsers() {
        List<UserRecord> records = new ArrayList<UserRecord>();
        Cursor cursor = database.query(User.TABLE_NAME, allColumn, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            UserRecord userRecord = new UserRecord();
            userRecord.setName(cursor.getString(0));
            userRecord.setEmail(cursor.getString(1));
            userRecord.setUsername(cursor.getString(2));
            userRecord.setPassword(cursor.getString(3));
            records.add(userRecord);
            cursor.moveToNext();
        }
        cursor.close();
        return records;
    }
}
