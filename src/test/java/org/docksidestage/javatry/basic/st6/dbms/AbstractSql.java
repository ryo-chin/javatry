package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author hakiba
 */
public abstract class AbstractSql {
    public abstract String buildPagingQuery(int pageSize, int pageNumber);
}
