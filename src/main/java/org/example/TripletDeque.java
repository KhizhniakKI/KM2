package org.example;

import java.util.*;
public class TripletDeque <T> implements Deque<T> , Cloneable, Containerable{


    public void Print(){
        boolean flg = true;
        while (flg){
            if (first != null){
                System.out.println(first.toString());
                first = first.next;
            }
            else {
                System.out.println("Количество элементов " + counter);
                System.out.println("Количество контейнеров " + containers);
                flg = false;
            }
        }
    }

    public ArrayWrap<T> last;
    public ArrayWrap<T> first;
    public int counter = 0;
    public int cloneCounter;
    public int containers = 1;
    public ArrayWrap<T> Iterator = new ArrayWrap<T>(null, null);
    public TripletDeque() {
        ArrayWrap<T> array = new ArrayWrap<T>(null, null);
        this.last = array;
        this.first = array;


    }

    @Override
    protected ArrayWrap<T> clone() throws CloneNotSupportedException {
        return (ArrayWrap<T>) super.clone();
    }


    @Override
    public void addFirst(T value) {
        if (value == null) {
            throw new NullPointerException();
        } else if (counter > 999){
            throw new IllegalStateException();
        }else {
        int t = 0;
        for ( int i = first.array.length - 1; i >= 0 ; i--) {
            if (first.array[i] == null) {
                first.array[i] = value;
                counter ++;
                cloneCounter = counter;
                break;
            }
            else {
                t += 1;
            }
        }

            if (t == 5){
                ArrayWrap<T> val2 = new ArrayWrap<>(first, null);
                containers ++;
                first.prev = val2;
                first = val2;
                val2.array[4] = value;
                counter ++;
                cloneCounter = counter;
            }
        }
    }




    @Override
    public void addLast(T value) {
        if (value == null) {
            throw new NullPointerException();
        } else if (counter > 999){
            throw new IllegalStateException();
        }else {
        int t = 0;
        for ( int i = 0; i < last.array.length ; i++) {
            if (last.array[i] == null) {
                last.array[i] = value;
                counter ++;
                cloneCounter = counter;
                break;
            }
            else {
                t += 1;
            }
        }
        if (t == 5){
            ArrayWrap<T> val2 = new ArrayWrap<>(null, last);
            containers ++;
            last.next = val2;
            last = val2;
            val2.array[0] = value;
            counter ++;
            cloneCounter = counter;
        }
    }
    }

    @Override
    public boolean offerFirst(T value) {
        int d = counter;
        try {
            addFirst(value);
            if (d != counter){
                return true;
            }
            else {
                return false;
            }
        }
        catch (IllegalStateException e){
            return false;
        }
    }

    @Override
    public boolean offerLast(T value) {
        int d = counter;
        try {
            addLast(value);
        if (d != counter){
            return true;
        }
        else {
            return false;
        }
        }catch (IllegalStateException e){
            return false;
        }
    }

    @Override
    public T removeFirst() {
        if (first != null){
            int t = 0;
            for(int i = 0 ; i < first.array.length; i ++){
                if (first.array[i] != null ){
                    T f = (T) first.array[i];
                    first.array[i] = null;
                    counter --;
                    cloneCounter = counter;
                    if (i == 4 && first.next != null){
                        first = first.next;
                    }
                    return f;
                }
                else {
                    t +=1;
                }
            }
            if (t == 5){
                if (first == null){
                    throw new NoSuchElementException();
                }
                else{
                    ArrayWrap<T> val2 = first;
                    val2.prev = null;
                    containers --;
                    first = val2;
                    T f = (T) first.array[0];
                    first.array[0] = null;
                    counter --;
                    cloneCounter = counter;
                    return f;
                }

            }
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (last != null){
            int t = 0;
            for(int i = last.array.length - 1 ; i >=0 ; i --){
                if (last.array[i] != null ){
                    T f = (T) last.array[i];
                    last.array[i] = null;
                    counter --;
                    cloneCounter = counter;
                    return (T) f;
                }
                else {
                    t +=1;
                }
            }
            if (t == 5){
                if (last.prev == null){
                    throw new NoSuchElementException();
                }
                else {
                    ArrayWrap<T> val2 = last.prev;
                    val2.next = null;
                    containers --;
                    last = val2;
                    T f = (T) last.array[4];
                    last.array[4] = null;
                    counter --;
                    cloneCounter = counter;
                    return f;
                }

            }
        }
        return null;
    }

    @Override
    public T pollFirst() {
        try {
            return removeFirst();
        }catch (NoSuchElementException e){
            return  null;
        }
    }

    @Override
    public T pollLast() {
        try {
            return removeLast();
        }catch (NoSuchElementException e){
            return  null;
        }
    }

    @Override
    public T getFirst() {
        if (first != null){
            int t = 0;
            for(int i = 0 ; i < first.array.length; i ++){
                if (first.array[i] != null ){
                    return (T) first.array[i];
                }
                else {
                    t +=1;
                }
            }
            if (t == 5){
                if (first.next == null){
                    throw new NoSuchElementException();
                }
                else{
                    ArrayWrap<T> val2 = first.next;
                    val2.prev = null;
                    first = val2;
                    Iterator = first;
                    return (T) first.array[0];
                }
            }
        }
        return null;
    }

    @Override
    public T getLast() {
        if (last != null){
            int t = 0;
            for(int i = last.array.length - 1 ; i >=0 ; i --){
                if (last.array[i] != null ){
                    return (T) last.array[i];
                }
                else {
                    t +=1;
                }
            }
            if (t == 5){
                if (last.prev == null){
                    throw new NoSuchElementException();
                }
                else{
                    ArrayWrap<T> val2 = last.prev;
                    val2.next = null;
                    last = val2;
                    return (T) last.array[4];
                }
            }
        }
        return null;
    }

    @Override
    public T peekFirst() {
        try {
            return getFirst();
        }catch (NoSuchElementException e){
            return  null;
        }
    }

    @Override
    public T peekLast() {
        try {
            return getLast();
        }catch (NoSuchElementException e){
            return  null;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        ArrayWrap<T> val2 = first;
        if(getFirst().equals(o)){
            removeFirst();
            return true;
        }
        else {
        while (val2 != null ){
            for (int i = 0; i < val2.array.length; i ++){
                if (val2.array[i] != null) {
                    if (val2.array[i].equals(o)) {
                        val2.array[i] = removeFirst();
                        return true;
                    }
                }
            }
            val2 = val2.next;
        }
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        ArrayWrap<T> val2 = last;
        if(getLast().equals(o)){
            removeLast();
            return true;
        }
        else {
            while (val2 != null ){
                for (int i = val2.array.length-1; i >= 0; i --){
                    int d = i;
                    if (val2.array[i] != null) {
                        if (val2.array[i].equals(o)) {
                            val2.array[i] = removeLast();
                            return true;
                        }
                    }
                }
                val2 = val2.prev;
            }
        }
        return false;
    }


    @Override
    public boolean add(T t) {
        int d = counter;
        addLast(t);
        if (d != counter){
            return true;
        }else {
        return false;
    }
    }

    @Override
    public boolean offer(T t) {
        try {
            int d = counter;
            addLast(t);
            return true;
        }catch (IllegalStateException e){
            return false;
        }
    }

    @Override
    public T remove() {
       return removeFirst();
    }

    @Override
    public T poll() {
        try {
            return removeFirst();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        try {
            return getFirst();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int d = counter;
        for (T element : c ){
            addLast(element);
        }
        if(counter - d == c.size()){
            return  true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        ArrayWrap<T> val2 = first;
        while (val2 != null ){
            for (int i = 0; i < val2.array.length; i ++){
                int d = i;
                if (val2.array[i] != null){
                    if (val2.array[i].equals(o)) {
                        return true;
                    }
                }
            }
            val2 = val2.next;
        }
        return false;
    }


    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (counter == 0){
            return true;
        }
        return false;
    }

    public ArrayList<T> It(){
        ArrayList<T> I = new ArrayList<>();
        ArrayWrap<T> val = first;
        while (val != null){
            for (int i = 0 ; i < val.array.length ; i ++){
                if(val.array[i] != null) {
                    I.add((T) val.array[i]);
                }
            }
            val = val.next;
        }
        return I;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new SkillIterator ();
}

    @Override
    public Object[] getContainerByIndex(int cIndex) {
        int d = 0;
        ArrayWrap <T> val2 = first;
        while (d != cIndex){
            if (val2.next != null) {
                val2 = val2.next;
            }
            else {
                return null;
            }
            d++;
        }
        return (Object[]) val2.array;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        throw new UnsupportedOperationException();
    }

    public class SkillIterator implements Iterator{
//        int c = 0;

        @Override
        public boolean hasNext() {
//            boolean fl = true;
            if (cloneCounter == 1){
                cloneCounter = counter;
                return false;
            }
            if (cloneCounter > 0) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (cloneCounter <= 0){
                throw new NoSuchElementException();
            }
            Object t;
            ArrayList<T> val2 =  It();
            for (int i = counter - cloneCounter ; i < counter; i++){
                if (val2.get(i) != null){
                    t = val2.get(i);
                    cloneCounter--;

//                    if (cloneCounter == 1){
//                        cloneCounter = counter;
//                    }
//                    val2.set(i, null);
                    return t;
                }
            }
            return null;
        }
    }


}





class ArrayWrap<T> {
    @Override
    public String toString() {
        return "ArrayWrap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
    public ArrayWrap(ArrayWrap<T> next, ArrayWrap<T> prev) {
        this.array = new Object[5];
        this.next = next;
        this.prev = prev;
    }
    Object[] array;
    T value;
    ArrayWrap<T> next;
    ArrayWrap<T> prev;
}
