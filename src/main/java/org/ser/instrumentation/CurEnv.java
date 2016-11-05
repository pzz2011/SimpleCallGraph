package org.ser.instrumentation;

public class CurEnv { 
    private static int depth = 0;
    private static boolean enabled = false;

    public static boolean isEnable() { 
        return enabled == true;
    }

    public static void SetUnable() {
        enabled = false;
    }

    public static void SetEnable() { 
        enabled = true;
    }

    public static void incdepth() { 
        depth++;
    }

    public static void decdepth() { 
        depth--;
    }


    public static int getdepth() { 
        return depth;
    }
}
