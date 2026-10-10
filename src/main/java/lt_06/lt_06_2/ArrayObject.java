package lt_06.lt_06_2;

import java.io.Serializable;

public class ArrayObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private int[] a = null;

    public ArrayObject() {
    }

    public void setArray(int a[]) {
        this.a = a;
    }

    public int[] getArray() {
        return a;
    }
}
