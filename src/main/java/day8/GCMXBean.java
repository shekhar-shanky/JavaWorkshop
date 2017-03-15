package day8;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by sshek8 on 8/21/2016.
 * <p>
 * -XX:+UseSerialGC             // Serial Generational Collector (Single Thread for YG and OG)
 * -XX:+UseParallelGC           // Parallel for YG, Serial for Old Space Generational Collector (Multiple Thread for Minor GC and Single thread for Major GC)
 * -XX:+UseParallelOldGC        // Parallel for both YG and OG  (Multiple Thread for Minor and Major GC)
 * -XX:+UseConcMarkSweepGC -XX:-UseParNewGC // Concurrent Mark and Sweep with Serial Young Space Collector and CMS for Old Space Collector
 * -XX:+UseConcMarkSweepGC -XX:+UseParNewGC // Concurrent Marl and Sweep with Parallel Young Space Collector and CMS for Old Space Collector
 * -XX:+UseG1GC                 // for region G1 GC
 */


public class GCMXBean {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean bean : list) {
            System.out.println("Name : " + bean.getName());
            System.out.println("Collection Count : " + bean.getCollectionCount());
            System.out.println("Collection Time : " + bean.getCollectionTime());
            System.out.println("Object Name : " + bean.getObjectName());
            System.out.println("Valid ?  : " + bean.isValid());
            for (String str : bean.getMemoryPoolNames()) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
