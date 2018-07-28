package com.beannote.beannote.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.beannote.beannote.R;

import java.lang.reflect.Field;

public class BaseAty extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(_getLayout());

    }

    private int _getLayout(){
        int id = getLayout();
        if (id == 0){
            id = getIdByClassName();
        }
        return id;
    }

    private int getIdByClassName(){
        Class<? extends Activity> activityClass = this.getClass();
        String className = activityClass.getSimpleName();
        className = className.replace("Aty","").toLowerCase();
        Class<R.layout> layoutClass = R.layout.class;
        try {
            Field field = layoutClass.getField("aty_" + className);
            int id = field.getInt(field);
            return id;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected int getLayout(){
        return 0;
    }
}
