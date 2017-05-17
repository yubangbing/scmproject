<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>
<style type="text/css">
.searchbox {
	margin: -3
}
</style>

<script type="text/javascript">
	$(function(){
	
			$('#dg').datagrid({    
			    //url:'${proPath}/datagrid_data1.json', 
			    //url:'${proPath}/supplier/selectPage.action', 
			    
			    url:'${proPath}/goods/selectPage.action', 
			    fitColumns:true,
			    nowrapL:true,
			    //idField:
			    rownumbers:true,
			    pagination:true,
			    
			    pageSize:5,
			    pageList:[2,5,10,20],
			    
			    rowStyler : function(index, row) {
		             if (index % 2 == 0) {
		                return 'background-color:#6293BB;color:#fff;';
		             }
		          },
		          //分页查询的关键字，默认没有,这里用单条件查询
		          queryParams: {
						keyWord: '%%',
					}, 
						    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
						alert('新增按钮');
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						alert('修改按钮');
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						alert('删除按钮');
					}
				},'-',{
					text:"名称：<input type='text' id='goodsName' name='goodsName'>",					
				}],		
			       
			    
				columns : [ [{
					checkbox:true,
				}, {
				field : 'goodsId',
				title : '商品编号',
				width : 100
			}, {
				field : 'goodsName',
				title : '商品名称',
				width : 100
			}, {
				field : 'goodsColor',
				title : '颜色',
				width : 100,
				formatter: function(value,row,index){
					var str = "${applicationScope.sysParam.goodsColor}";
					return valueToText(str,value);				
				}
			}, {
				field : 'goodsSelPrice',
				title : '售价',
				width : 100
			},	{
				field : 'goodsRemark',
				title : '商品备注',
				width : 100,
				align : 'right'
			} ] ]
		});
			
			$('#goodsName').searchbox({ 
				searcher:function(value,name){ 
					
					//执行load函数时，参数将取代'queryParams'属性中的参数
					$('#dg').datagrid('load',{
						keyWord: '%'+value+'%'
					});					
				}, 
				prompt:'请输入商品名称' 
			});

	});
</script>
</head>

<body>
	<table id="dg"></table>
</body>
</html>