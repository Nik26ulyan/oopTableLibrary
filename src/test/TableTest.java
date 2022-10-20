package test;

import ru.vsu.cs.uliyanov.Table;
import ru.vsu.cs.uliyanov.TableRow;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    TestCases cases = new TestCases();

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Table<Integer> table = new Table<>();
        assertTrue(table.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addColumn() throws TableRow.TableRowException {
        Table<Integer> table = cases.getTable();
        TableRow<Integer> col = cases.getRow();

        int colCount = table.getColCount();
        table.addColumn(col);

        assertEquals(1, table.getColCount() - colCount);
    }

    @org.junit.jupiter.api.Test
    void addRow() throws TableRow.TableRowException {
        Table<Integer> table = cases.getTable();
        TableRow<Integer> row = cases.getRow();

        int rowCount = table.getRowCount();
        table.addRow(row);

        assertEquals(1, table.getRowCount() - rowCount);
    }

    @org.junit.jupiter.api.Test
    void add() throws TableRow.TableRowException {
        Table<Integer> table = new Table<>();

        table.add(10);

        assertEquals(10, table.get(0, 0));
    }

    @org.junit.jupiter.api.Test
    void set() throws TableRow.TableRowException {
        Table<Integer> table = cases.getTable();

        assertTrue(10 != table.get(2, 2));

        table.set(10, 2, 2);

        assertEquals(10, table.get(2, 2));
    }

    @org.junit.jupiter.api.Test
    void remove() throws TableRow.TableRowException {
        Table<Integer> table = cases.getTable();

        int num = table.get(2, 2);

        table.remove(2, 2);

        assertTrue(num != table.get(2, 2));
    }

    @org.junit.jupiter.api.Test
    void get() throws TableRow.TableRowException {
        Table<Integer> table = cases.getTable();

        table.set(10, 2, 2);

        assertEquals(10, table.get(2, 2));
    }
}