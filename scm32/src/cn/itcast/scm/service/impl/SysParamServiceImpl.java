package cn.itcast.scm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.scm.dao.SupplierMapper;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.entity.Supplier;
import cn.itcast.scm.entity.SysParam;
import cn.itcast.scm.service.SupplierService;
import cn.itcast.scm.service.SysParamService;

@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService {

	@Override
	public Map<String, Object> selectList() {
		// TODO Auto-generated method stub
		List<SysParam> sysParams=sysParamMapper.selectList("");
		//ϵͳ����Map,������������ֶε���ز�����Ϣ
		Map<String, Object> sysParamMap =new HashMap<String, Object>();
		
		Map<String, Object> fieldMap=null;
		
		for (SysParam sysParam : sysParams) {
			if("1".equals(sysParam.getSysParamType())){
				//��ȡ��Ҫִ��SQL��������ѯ������
				String sql = sysParam.getSysParamValue();
				System.out.println("========="+sql);
				//ִ�в�ѯ�����ѽ������List�У�Ԫ��Ϊϵͳ�������͵�ʵ��
				List<SysParam> otherList= sysParamMapper.selectOtherTable(sql);
				fieldMap = new HashMap<String, Object>();
				//�������������ݴ浽�ֶ�MAP
				for (SysParam otherSysParam : otherList) {
					fieldMap.put(otherSysParam.getSysParamValue(), otherSysParam.getSysParamText());					
				}
				//���ֶ����Map�����ϵͳ����Map,��ԭϵͳ�������ѯ��sysParam�����sysParamField��Ϊkdy
				sysParamMap.put(sysParam.getSysParamField(), fieldMap);						
				
			}else{
				//�Ӵ��ϵͳ������map��ȡ�ֶε�map
				if(sysParamMap.get(sysParam.getSysParamField())==null){
					fieldMap = new HashMap<String, Object>();
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
					sysParamMap.put(sysParam.getSysParamField(), fieldMap);				
				}else{
					fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());					
				}
			}
			
		}
		//System.out.println(sys);
		return sysParamMap;
	}
	
	
}
