/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.java;

import com.stulsoft.pkotlin.kotlin.SomeKotlinClass1;
import com.stulsoft.pkotlin.kotlin.SomeKotlinDataClass;

/**
 * @author Yuriy Stul
 */
public class SomeJavaClass1 {
    private final SomeKotlinClass1 someKotlinClass1;

    public SomeJavaClass1(SomeKotlinClass1 someKotlinClass1) {
        this.someKotlinClass1 = someKotlinClass1;
    }

    public void show(){
        System.out.printf("call a Kotlin fun: %s%n", someKotlinClass1.nameAndAge());
    }

    public void show2(){
        var dc = new SomeKotlinDataClass("test 2", 15);
        System.out.printf("data class: %s%n", dc);
    }

    public static void main(String[] args) {
        var someJavaClass1=new SomeJavaClass1(new SomeKotlinClass1("test 1", 123));
        someJavaClass1.show();
        someJavaClass1.show2();
    }
}
