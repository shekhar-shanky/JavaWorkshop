package day4;

/**
 * Created by sshek8 on 8/15/2016.
 */


enum MyEnum {
    NEWDELHI(011, "NORTH"), MUMBAI(022, "WEST"), KOLKATTA(033, "EAST"), CHENNAI(044, "SOUTH");

    private int code;
    private String direction;

    MyEnum(int code, String direction) {
        this.code = code;
        this.direction = direction;
    }


}

public class EnumTest {

    public static void main(String[] args) {


        System.out.println();
        System.out.println(System.identityHashCode(MyEnum.class));
        System.out.println(System.identityHashCode(MyEnum.CHENNAI));
        System.out.println(System.identityHashCode(MyEnum.NEWDELHI));

        MyEnum newDelhi = MyEnum.NEWDELHI;
        System.out.println(newDelhi.ordinal());
        System.out.println(newDelhi.name());
        System.out.println(newDelhi.hashCode());
        System.out.println(newDelhi.getClass());
        System.out.println(MyEnum.valueOf("NEWDELHI"));
        System.out.println(MyEnum.NEWDELHI.name());
        System.out.println(MyEnum.NEWDELHI.toString());

        MyEnum chennai = MyEnum.CHENNAI;
        System.out.println(chennai.ordinal());
        System.out.println(chennai.name());
        System.out.println(chennai.hashCode());
        System.out.println(chennai.getClass());

    }
}
