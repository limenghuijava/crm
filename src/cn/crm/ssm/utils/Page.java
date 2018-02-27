package cn.crm.ssm.utils;

import java.util.List;

/*
	分页查询的结果最终封装在Page对象中，传入到前端页面中
 */
public class Page<T> {
    
	private int total;//总记录条数
	private int page;//当前的页面数目
	private int size;//每一页显示的条数
    private List<T> rows;//当前页面的所有数据的集合

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
