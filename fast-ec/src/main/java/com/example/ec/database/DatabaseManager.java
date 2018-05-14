package com.example.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午12:44
 * - @Email whynightcode@gmail.com
 */
public class DatabaseManager {
    private DaoSession mDaoSession;
    private UserProfileDao mDao;

    private DatabaseManager() {
    }

    public DatabaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        return mDao;
    }
}
