package liquibase.statement.core;

import liquibase.statement.SqlStatement;

public class SelectFromDatabaseChangeLogStatement implements SqlStatement {

    private String[] columnsToSelect;
    private WhereClause whereClause;
    private String[] orderByColumns = new String[0];

    public SelectFromDatabaseChangeLogStatement(String... columnsToSelect) {
        this(null, columnsToSelect);
    }

    public SelectFromDatabaseChangeLogStatement(WhereClause whereClause, String... columnsToSelect) {
        this.columnsToSelect = columnsToSelect;
        this.whereClause = whereClause;
    }

    public String[] getColumnsToSelect() {
        return columnsToSelect;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public String[] getOrderByColumns() {
        return orderByColumns;
    }

    public SelectFromDatabaseChangeLogStatement setOrderBy(String... columns) {
        this.orderByColumns = columns;

        return this;
    }

    public static interface WhereClause {

    }

    public static class ByTag implements WhereClause {

        private String tagName;

        public ByTag(String tagName) {
            this.tagName = tagName;
        }

        public String getTagName() {
            return tagName;
        }
    }

}