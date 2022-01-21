package ch8.list;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Arrays;

public interface List<E> extends Collection<E> {
    boolean addAll(int index, Collection<? extends E> c);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    List<E> subList(int fromIndex, int toIndex);

    // @SafeVarargs
    // @SuppressWarnings("varargs")
    // static <E> List<E> of(E... elements) {
    // switch (elements.length) { // implicit null check of elements
    // case 0:
    // @SuppressWarnings("unchecked")
    // var list = (List<E>) ImmutableCollections.EMPTY_LIST;
    // return list;
    // case 1:
    // return new ImmutableCollections.List12<>(elements[0]);
    // case 2:
    // return new ImmutableCollections.List12<>(elements[0], elements[1]);
    // default:
    // return ImmutableCollections.listFromArray(elements);
    // }
    // }

    // static <E> List<E> copyOf(Collection<? extends E> coll) {
    // return ImmutableCollections.listCopy(coll);
    // }
}
