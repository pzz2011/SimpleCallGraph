package org.ser.instrumentation;

import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Stack;
public class storage {
//   private static List<String> callstack = new ArrayList<String>();
//   private static Vector<Vector<Pair<Integer, Long> > >adj;   // 线程安全
   private static int capacity = 3;
   private static Vector<Integer> adj = new Vector<Integer>(capacity*capacity, 0);
   private static Vector<Long> time = new Vector<Long>(capacity*capacity, 0);
   private static HashMap<String,Integer> index = new HashMap<String,Integer>();    // 正向索引
   private static HashMap<Integer,String> revindex = new HashMap<Integer,String>(); // 反向索引
   private static Stack<Long> timestack = new Stack<Long>();
   private static int count = 0;
   private static long totaltime = 0;
//   private static int capacity = 2;

   public static void init() { 
        int c = adj.capacity();
        for (int i = 0; i < c; i++) { 
            adj.add(0);
            time.add(Long.valueOf(0));
        }
   }

   public static void updatetotaltime(long t) { 
        totaltime = totaltime + t;
   }

   public static void printtotaltime() { 
        System.out.println("total time: " + totaltime);
   }

   public static Vector<Integer> test_getadj() { 
        return adj;
   }

   public static Vector<Long> test_gettime() { 
        return time;
   }
   public static void test_setcapacity(int num) { 
        capacity = num;
   }

   public static int test_getcapacity() { 
        return capacity;
   }

   public static int test_getadjcapacity() { 
        return adj.capacity(); 
   }

   public static int test_gettimecapacity()  {
        return time.capacity();
    }

   public static Vector<Integer> getadj() { 
        return adj;
   }

   public static int getcapacity()  {
        return capacity;
   }
   public static void updateadj(int pindex, int index) { // update the adj[][] when we need to call a new function.
//        System.out.println("---->" + (pindex * capacity + index));
//        if (pindex * capacity + index >= capacity*capacity) { 
//            resize();
//        }
        if (pindex >= capacity || index >= capacity) { 
            resize();
        }
        adj.set(pindex * capacity + index, adj.get(pindex * capacity + index) + 1); // 增加一次计数
   }

   public static void updatetime(int pindex, int index, long t) { 
       
//       if (pindex * capacity + index >= capacity*capacity)  {
//            resize();
//       }
        if (pindex >= capacity || index >= capacity) { 
            resize();
        }
       time.set(pindex * capacity + index, time.get(pindex * capacity + index) + t);
   }

//   public static void push(String caller) {
//        callstack.add(caller);
//   }

//   public static void pop() {
//        callstack.remove(callstack.size() - 1);
//   }

//   public static String top() {
////        return callstack[callstack.size() - 1];
//        return callstack.get(callstack.size() - 1);
//   }

   public static void addIndex(String signature) { 
       if (index.get(signature) != null) {
           return;
       }
       index.put(signature, count++);
   }

   public static HashMap<String, Integer> getPositiveTable() { 
       return index; 
   }

   public static HashMap<Integer, String> getNegativeTable() { 
       return revindex;
   }

   public static int getindex(String func) {
       System.out.println("---->" + func);
       return index.get(func);
   }
   public static String getrevindex(Integer rindex) { 
       return revindex.get(rindex);
   }

   

   public static void addRevIndex(int index, String signature) { 
       if (revindex.get(index) != null) {
           return;
       }
       revindex.put(index, signature);
   }

   public static void showIndex() {
       Iterator it = index.values().iterator();
       while (it.hasNext()) 
           System.out.println(it.next());
   }

   public static void resize() { 
        int s = capacity * 2;
        Vector<Integer> tmp1 = new Vector<Integer>(s*s, 0);
        Vector<Long> tmp2 = new Vector<Long>(s*s, 0);
        for (int i = 0; i < s; ++i) { 
            for (int j = 0; j < s; ++j) { 
                tmp1.add(0);
                tmp2.add(Long.valueOf(0));
            }
        }


        for (int i = 0; i < capacity; ++i) { 
            for (int j =0; j < capacity; ++j) { 
                tmp1.set(i*s + j, adj.get(i*capacity + j));
                tmp2.set(i*s + j, time.get(i*capacity + j));
            }
        }
        capacity = s;
        adj = tmp1;
        time = tmp2;
   }

   public static int getcount() { 
        return count;
   } 

   public static long gettoptime() { 
        return timestack.pop();
   }

   public static void pushtime(long t) { 
        timestack.push(t);
   }


   public static int adj_ij(int i, int j) { 
        int c = getcapacity();
        if (i >= capacity || j >= capacity) {
            return -1;
        }
        return adj.get(i*capacity + j);
   }

   public static long time_ij(int i, int j) { 
        int c = getcapacity();
        if (i >= capacity || j >= capacity) { 
            return -1;
        }
        return time.get(i*capacity + j);
   }
//   public static void main(String[] args) {
//        storage.push("1");
//        storage.push("2");
//        System.out.println(storage.top());
//        storage.addIndex("a");
//        storage.addIndex("b");
//        storage.addIndex("c");
//        storage.addIndex("d");
//        storage.showIndex();
//   }

}

