package com.dgg.java.funprogdemos.resources;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
@FunctionalInterface
public interface IResourceInstance<T, X extends Throwable> {
    void apply(T type) throws X;
}
