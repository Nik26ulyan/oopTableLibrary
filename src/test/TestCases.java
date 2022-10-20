package test;

import ru.vsu.cs.uliyanov.Table;
import ru.vsu.cs.uliyanov.TableRow;

public class TestCases {

    public TableRow<Integer> getRow() {
        TableRow<Integer> row = new TableRow<>();
        for (int i = 0; i < 5; i++) {
            row.addLast(i);
        }
        return row;
    }

    public Table<Integer> getTable() {
        Table<Integer> table = new Table<>();
        for (int i = 0; i < 5; i++) {
            table.addColumn(getRow());
        }
        return table;
    }
}
