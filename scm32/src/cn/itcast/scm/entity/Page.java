package cn.itcast.scm.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 6621708557409749822L;
	private Integer page = 1;// 表示当前第几页，与datagrid请求的参数名(pageNumber)一致，便于查询时赋值，默认第一页
	private Integer rows = 5;// 表示页的记录条数，与datagrid请求的参数名（pageSize）一致，便于查询时赋值，默认10条
	//共多少页这个变量：easyUI自己计算
	private Integer start;// 从第几条开始，记录的下标从0开始计算

	private T paramEntity;// 多查询条件时使用

	private String keyWord;// 单个关键字查询
	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	private Integer total;// 总条数
	private List<T> lists;// 页面数据集

	//map来存放total和lists
	private Map<String, Object> pageMap = new HashMap<String, Object>() ;
	public Map<String, Object> getPageMap() {
		return pageMap;
	}


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return (page-1)*rows;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public T getParamEntity() {
		return paramEntity;
	}

	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}

/*	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}*/

	//把total和lists放在pageMap中返回
/*	public Integer getTotal() {
		return total;
	}*/

	//参考datagrid_data1.json中的命名
	public void setTotal(Integer total) {
		pageMap.put("total", total);
		this.total = total;
	}

/*	public List<T> getLists() {
		return lists;
	}
*/
	//参考datagrid_data1.json中的命名
	public void setLists(List<T> lists) {
		pageMap.put("rows", lists);
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", start=" + start
				+ ",supName="+paramEntity+",total=" + total + "]";
	}
}
