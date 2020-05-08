package com.duyi.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloWorld {
    static int index = 0;
    public void print() {
        System.out.println(index++);
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, objects, methodProxy) -> {
            System.out.println("before method run...");
            Object result = methodProxy.invokeSuper(obj, args);
            System.out.println("after method run...");
            return result;
        });
        HelloWorld obj = (HelloWorld) enhancer.create();
        obj.print();
    }
}
