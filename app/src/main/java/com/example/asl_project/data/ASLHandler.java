
package com.example.asl_project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.asl_project.Model.AslModel;
import com.example.asl_project.parameters.ASLPara;

import java.util.ArrayList;
import java.util.List;

public class ASLHandler extends SQLiteOpenHelper {
    public ASLHandler(@Nullable Context context) {
        super(context,ASLPara.DB_NAME,null,ASLPara.DB_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create = "CREATE TABLE "+ASLPara.TABLE_NAME+"("+ASLPara.KEY_ID+" INTEGER PRIMARY KEY, "
                +ASLPara.KEY_IMG_ID+" INTEGER, "+ASLPara.KEY_TEXT+" TEXT"+")";
        sqLiteDatabase.execSQL(Create);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addASL(AslModel aslModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ASLPara.KEY_ID, aslModel.getId());
        values.put(ASLPara.KEY_IMG_ID, aslModel.getAslImage());
        values.put(ASLPara.KEY_TEXT, aslModel.getAslAlphabet());
        db.insert(ASLPara.TABLE_NAME, (String)null, values);
        db.close();
    }

    public List<AslModel> getAllAslMap() {
        List<AslModel> aslModelList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        String Select = "SELECT * FROM "+ASLPara.TABLE_NAME;
        Cursor cursor = db.rawQuery(Select, (String[])null);
        if (cursor.moveToFirst()) {
            do {
                AslModel aslModel = new AslModel();
                aslModel.setId(Integer.parseInt(cursor.getString(0)));
                aslModel.setAslImage(Integer.parseInt(cursor.getString(1)));
                aslModel.setAslAlphabet(cursor.getString(2));
                aslModelList.add(aslModel);
            } while(cursor.moveToNext());
        }

        return aslModelList;
    }

    public void updateASLList(AslModel aslModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ASLPara.KEY_ID, aslModel.getId());
        values.put(ASLPara.KEY_IMG_ID, aslModel.getAslImage());
        values.put(ASLPara.KEY_TEXT, aslModel.getAslAlphabet());
        db.update(ASLPara.TABLE_NAME, values, ASLPara.KEY_ID+"id=?", new String[]{String.valueOf(aslModel.getId())});
        db.close();
    }

    public void deleteTABLE() {
        SQLiteDatabase db = this.getWritableDatabase();
        String Delete = "DELETE FROM "+ASLPara.TABLE_NAME;
        Cursor cursor = db.rawQuery(Delete, (String[])null);
        if (cursor.moveToFirst()) {
            while(cursor.moveToNext()) {
            }
        }

        db.close();
    }

    public void deleteASLRecord(AslModel aslModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(""+ASLPara.TABLE_NAME, "id=?", new String[]{String.valueOf(aslModel.getId())});
        db.close();
    }
}
