package cn.itcast.scm.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 6621708557409749822L;
	private Integer page = 1;// ��ʾ��ǰ�ڼ�ҳ����datagrid����Ĳ�����(pageNumber)һ�£����ڲ�ѯʱ��ֵ��Ĭ�ϵ�һҳ
	private Integer rows = 5;// ��ʾҳ�ļ�¼��������datagrid����Ĳ�������pageSize��һ�£����ڲ�ѯʱ��ֵ��Ĭ��10��
	//������ҳ���������easyUI�Լ�����
	private Integer start;// �ӵڼ�����ʼ����¼���±��0��ʼ����

	private T paramEntity;// ���ѯ����ʱʹ��

	private String keyWord;// �����ؼ��ֲ�ѯ
	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	private Integer total;// ������
	private List<T> lists;// ҳ�����ݼ�

	//map�����total��lists
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

	//��total��lists����pageMap�з���
/*	public Integer getTotal() {
		return total;
	}*/

	//�ο�datagrid_data1.json�е�����
	public void setTotal(Integer total) {
		pageMap.put("total", total);
		this.total = total;
	}

/*	public List<T> getLists() {
		return lists;
	}
*/
	//�ο�datagrid_data1.json�е�����
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
