package day8;

import sun.misc.Unsafe;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sshek8 on 8/21/2016.
 */
public class Sawtooth {

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o) throws Exception {
        Object[] array = new Object[]{0};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size : " + addressSize);
        }

        return objectAddress;
    }

    public static void main(String... args) throws Exception {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean mxBean : garbageCollectorMXBeans) {
            System.out.println("getName \t\t\t: " + mxBean.getName());
            System.out.println("getObjectName \t\t: " + mxBean.getObjectName());
            System.out.println("getClass \t\t\t: " + mxBean.getClass());
            System.out.println("getCollectionCount \t: " + mxBean.getCollectionCount());
            System.out.println("getCollectionTime \t: " + mxBean.getCollectionTime());
            System.out.println("getMemoryPoolNames \t: " + Arrays.toString(mxBean.getMemoryPoolNames()));
            System.out.println();

        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Object mine = new GCMe();
            long address = addressOf(mine);
            System.out.println(address);
        }
    }

    static class GCMe {
        long data;
        long _;
        long __;
        long ___;
        long ____;
        long _____;
        long ______;
        long _______;
        long ________;
        long _________;
        long __________;
        long ___________;
        long ____________;
        long _____________;
        long ______________;
        long _______________;
        long _________________;
        long __________________;
    }
}
