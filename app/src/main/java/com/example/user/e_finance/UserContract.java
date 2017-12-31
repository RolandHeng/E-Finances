package com.example.user.e_finance;


import android.provider.BaseColumns;

public final class UserContract {
    public UserContract() {
    }

    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD ="password";
    }
}
