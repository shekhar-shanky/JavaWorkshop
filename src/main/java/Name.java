import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by sshek8 on 9/21/2016.
 */
public class Name {
    private final String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) {
        Set<Name> s = new HashSet<Name>();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(
                s.contains(new Name("Mickey", "Mouse")));
        System.out.println(
                Long.toHexString(0x100000000L + 0xcafebabe));
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
