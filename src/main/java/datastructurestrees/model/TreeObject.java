package datastructurestrees.model;

public abstract class TreeObject<T>  implements Comparable <T> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(T another);
    public abstract String toString();
}
