package com.wyett.thinkinjava.Annotation;

/**
 * @author chelei
 * @date 2019/5/30 18:12
 */
@DBTable(name = "MEMBER")
public class Member {
    // pk
    @SQLString(name = "ID", value = 50,
            constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME", value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION", value = 150,
            constraint = @Constraints(allowNull = true))
    private String description;
}
