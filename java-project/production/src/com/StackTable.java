package com;

/**
 * Created on 2019-12-26.
 *
 * @author 迹_Jason
 */
public class StackTable<T> {

    private Object[] stack;
    private int lenth;
    private int index = -1;

    public StackTable(int size) {
        stack = new Object[size];
        lenth = size;
    }

    public boolean push(T value) {
        if (index == lenth-1) {
            return false;
        }
        index++;
        stack[index] = value;
        return true;
    }
    public T pop(){
        if(stack[index]==null){
            return null;
        }
        T v=(T)stack[index];
        stack[index]=null;
       return v;
    }

    public T get(int i) {
        if (i >= lenth) {
            return null;
        } else {
            return (T) stack[i];
        }
    }

    public static void main(String[] args) {
        StackTable<String> st=new StackTable<>(3);
        System.out.println(st.get(1));
        System.out.println(st.push("one"));
        System.out.println(st.push("two"));
        System.out.println(st.push("three"));
        System.out.println(st.push("four"));
        System.out.println(st.pop());
        System.out.println(st.get(2));
    }
}
