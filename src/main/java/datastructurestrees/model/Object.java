package datastructurestrees.model;

import java.util.Objects;

public class Object extends TreeObject <Object> {

    Integer myValue;

    public Object(Integer myValue) {
        this.myValue = myValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Object object = o;
        return Objects.equals(myValue, object.myValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myValue);
    }

    @Override
    public int compareTo(Object another) {
        int i = 0;
        if (this.myValue > another.myValue){
            i = 1;
        } else if (this.myValue < another.myValue){
            i = -1;
        }
        return i;
    }

    @Override
    public String toString() {
        return myValue.toString();
    }
}
