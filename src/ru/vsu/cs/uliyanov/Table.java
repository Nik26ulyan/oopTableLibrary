package ru.vsu.cs.uliyanov;

public class Table<T> {
    public Table() {
        table = new TableRow<>();
    }

    private TableRow<TableRow<T>> table;



    public boolean isEmpty() {
        return table.size() == 0;
    }

    public int getRowCount() throws TableRow.TableRowException {
        return table.get(0).size();
    }

    public int getColCount() {
        return table.size();
    }

    public void addColumn(TableRow<T> col) {
        table.addLast(col);
    }

    public void addRow(TableRow<T> row) throws TableRow.TableRowException {
        if (row.size() == table.size()) {
            for (int i = 0; i < table.size(); i++) {
                table.get(i).addLast(row.get(i));
            }
        }
    }

    public void add(T element) throws TableRow.TableRowException {
        if (table.size() == 0) {
            TableRow<T> row = new TableRow<>();
            row.addLast(element);
            table.addLast(row);
        } else {
            table.getFirst().addLast(element);
        }
    }

    public void set(T element, int i, int j) throws TableRow.TableRowException {
        if (i <= table.size()) {
            table.get(i).set(element, j);
        }
    }

    public  void remove(int i, int j) throws TableRow.TableRowException {
        table.get(i).remove(j);
    }

    public T get(int i, int j) throws TableRow.TableRowException {
        return table.get(i).get(j);
    }

}
