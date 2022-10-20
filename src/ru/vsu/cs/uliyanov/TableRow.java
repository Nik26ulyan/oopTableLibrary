package ru.vsu.cs.uliyanov;

import java.util.Iterator;

public class TableRow<T> implements Iterable<T> {

    public static class TableRowException extends Exception {
        public TableRowException(String message) {
            super(message);
        }
    }

    private class TableRowNode {
        public T value;
        public TableRowNode next;

        public TableRowNode(T value, TableRowNode next) {
            this.value = value;
            this.next = next;
        }

        public TableRowNode(T value) {
            this(value, null);
        }
    }

    private TableRowNode head = null;  // first
    private TableRowNode tail = null;  // last
    private int size = 0;

    // O(1)
    public void addFirst(T value) {
        head = new TableRowNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // O(1)
    public void addLast(T value) {
        if (size == 0) {
            head = tail = new TableRowNode(value);
        } else {
            tail.next = new TableRowNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws TableRowException {
        if (size == 0) {
            throw new TableRowException("Empty list");
        }
    }

    // O(n)
    private TableRowNode getNode(int index) {
        TableRowNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // O(1)
    public void removeFirst() throws TableRowException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    // O(n)
    public void removeLast() throws TableRowException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    // O(n)
    public void remove(int index) throws TableRowException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new TableRowException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            TableRowNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(n)
    public T get(int index) throws TableRowException {
        checkEmptyError();
        return getNode(index).value;
    }

    // O(1)
    public T getFirst() throws TableRowException {
        checkEmptyError();
        return head.value;
    }

    // O(1)
    public T getLast() throws TableRowException {
        checkEmptyError();
        return tail.value;
    }

    public void set(T element, int index) throws TableRowException {
        checkEmptyError();
        getNode(index).value = element;
    }

    @Override
    public Iterator<T> iterator() {
        class TableRowIterator implements Iterator<T> {
            TableRowNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new TableRowIterator();
    }
}
