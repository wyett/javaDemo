package com.wyett.thinkinjava.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * @author chelei
 * @date 2019/5/30 18:55
 */
public class TableCreator {
    public static String createTableSql(String className)
    throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        //表注解判断
        if(dbTable == null) {
            System.out.println(
                    "No DBTable annotations in class "
                            + className);
            return null;
        }
        String tableName = dbTable.name();
        //if tableName is null，usage Class name;
        if(tableName.length() < 1)
            tableName = cl.getName().toUpperCase();
        List<String> columnDefs = new ArrayList<String>();
        for(Field field: cl.getDeclaredFields()){
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            //获取字段注解
            if(anns.length < 1)
                continue;

            //判断注解类型
            if(anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger)anns[0];
                //获取字段对应列名称
                if(sInt.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sInt.name();
                //构建语句
                columnDefs.add(columnName + " INT " +
                    getConstraints(sInt.constraint()));
            }

            //判断String类型
            if(anns[0] instanceof SQLString) {
                SQLString sString = (SQLString)anns[0];
                //Use field name if name not specified
                if(sString.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sString.name();
                columnDefs.add(columnName + " VARCHAR(" +
                    sString.value() + ")" +
                    getConstraints(sString.constraint()));
            }
        }
        //create database sql
        StringBuilder createCommand = new StringBuilder(
                "CREATE TABLE " + tableName + "(");
        for(String columnDef : columnDefs)
            createCommand.append("\n " + columnDef + ",");

        //Remove trailing comma
        String tableCreate = createCommand.substring(
                0, createCommand.length() - 1) + ");";
        return tableCreate;
    }

    /**
     * create by: wyettLei
     * description: TODO
     * create time: 2019/5/31 12:33
     *
     * @param * @Param: null
     * @return 
     */ 
    private static String getConstraints(Constraints con) {
        String constraints = "";
        if(!con.allowNull())
            constraints += " NOT NULL ";
        if(con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE ";
        return constraints;
    }

    public static void main(String[] args) throws Exception{
        String[] arg = {"thinkinjava.Annotation.Member"};
        for(String className : arg) {
            System.out.println("Table Creation SQL for " +
                className + " is:\n" + createTableSql(className));
        }
    }
}
