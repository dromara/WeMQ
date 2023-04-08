package cn.mmanager.common.core.page;

import cn.mmanager.common.constant.PageConstants;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 * @author NicholasLD
 * @createTime 2023/4/4 05:47
 */
public class TableData implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 当前页码 */
    private int pageNum;

    /** 每页显示记录数 */
    private int pageSize;

    /** 总页数 */
    private int pages;

    /**
     * 表格数据对象
     */
    public TableData()
    {
    }

    /**
     * 分页
     * @param list 列表数据
     * @param pageNum 当前页码
     */
    public TableData(List<?> list, int pageNum, int pages)
    {
        this.rows = list;
        this.total = list.size();
        this.pageNum = pageNum;
        this.pageSize = PageConstants.DEFAULT_PAGE_SIZE;
        this.pages = pages;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
