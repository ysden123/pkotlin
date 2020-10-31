/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.java;

import com.stulsoft.pkotlin.kotlin.SomeKotlinClass1;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yuriy Stul
 */
public class DerivedClass1 extends SomeKotlinClass1 {
    public DerivedClass1(@NotNull String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        var dc = new DerivedClass1("test 2",32);
        System.out.printf("%s%n", dc.nameAndAge());
        System.out.printf("%d%n",dc.getAge());
    }
}
