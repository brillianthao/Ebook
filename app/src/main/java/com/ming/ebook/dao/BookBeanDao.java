package com.ming.ebook.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.ming.ebook.dao.entity.BookBean;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BOOK_BEAN".
*/
public class BookBeanDao extends AbstractDao<BookBean, Long> {

    public static final String TABLENAME = "BOOK_BEAN";

    /**
     * Properties of entity BookBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Book_id = new Property(1, String.class, "book_id", false, "BOOK_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Readed_chapter = new Property(3, String.class, "readed_chapter", false, "READED_CHAPTER");
        public final static Property Book_cover = new Property(4, String.class, "book_cover", false, "BOOK_COVER");
    }


    public BookBeanDao(DaoConfig config) {
        super(config);
    }
    
    public BookBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BOOK_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"BOOK_ID\" TEXT," + // 1: book_id
                "\"NAME\" TEXT," + // 2: name
                "\"READED_CHAPTER\" TEXT," + // 3: readed_chapter
                "\"BOOK_COVER\" TEXT);"); // 4: book_cover
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BOOK_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BookBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String book_id = entity.getBook_id();
        if (book_id != null) {
            stmt.bindString(2, book_id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String readed_chapter = entity.getReaded_chapter();
        if (readed_chapter != null) {
            stmt.bindString(4, readed_chapter);
        }
 
        String book_cover = entity.getBook_cover();
        if (book_cover != null) {
            stmt.bindString(5, book_cover);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BookBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String book_id = entity.getBook_id();
        if (book_id != null) {
            stmt.bindString(2, book_id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String readed_chapter = entity.getReaded_chapter();
        if (readed_chapter != null) {
            stmt.bindString(4, readed_chapter);
        }
 
        String book_cover = entity.getBook_cover();
        if (book_cover != null) {
            stmt.bindString(5, book_cover);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BookBean readEntity(Cursor cursor, int offset) {
        BookBean entity = new BookBean();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BookBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBook_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setReaded_chapter(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBook_cover(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BookBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BookBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BookBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
