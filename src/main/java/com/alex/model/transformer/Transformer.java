package com.alex.model.transformer;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.Table;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {

    private final Class<T> myClass;

    public Transformer(Class<T> myClass) {
        this.myClass = myClass;
    }

    public T transformToEntity(ResultSet rs) throws SQLException {
        T model = null;
        try {
            model = myClass.getConstructor().newInstance();
            if (myClass.isAnnotationPresent(Table.class)) {
                for (Field field : myClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Column.class)) {
                        field.setAccessible(true);
                        Column column = (Column) field.getAnnotation(Column.class);
                        String name = column.name();
                        @SuppressWarnings("rawtypes")
                        Class fieldType = field.getType();
                        if (fieldType == Integer.class) {
                            field.set(model, rs.getInt(name));
                        } else if (fieldType == String.class) {
                            field.set(model, rs.getString(name));
                        } else if (fieldType == Date.class) {
                            field.set(model, rs.getDate(name));
                        } else if (fieldType == Double.class) {
                            field.set(model, rs.getDouble(name));
                        }else if (fieldType == Float.class) {
                            field.set(model, rs.getFloat(name));
                        }
                    }
                }
            }
        } catch (Exception a){
            System.out.println("Can't Transform object!");
        }
        return model;
    }
}
