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
			    
			    url:'${proPath}/supplier/selectPageUseDyc.action', 
			    fitColumns:true,
			    nowrapL:true,
			    idField:'supId',
			    rownumbers:true,
			    pagination:true,
			    //注意pageSize必须是pageList里面的值
			    pageSize:5,
			    pageList:[2,5,10,20],
			    
			    rowStyler : function(index, row) {
		             if (index % 2 == 0) {
		                return 'background-color:#6293BB;color:#fff;';
		             }
		          },
		          //分页查询的关键字，默认没有
		          queryParams: {
						supName: '%%',
						supAddress:'%%',
						//keyWord用于单条件查询,这里可不写
						//keyWord:'%%'
					}, 
						    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
						parent.$('#win').window({    
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/supplier/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						parent.$('#win').window({    
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/supplier/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
					  });
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						var array = $("#dg").datagrid("getSelections");
						
						 if (array.length > 0) {
				                //定义数组，通过下边的用来存储选中记录的Id
				                   var ids = new Array();
				                   for (i = 0; i < array.length; i++) {
				                      ids[i] = array[i].supId;
				              }
				           parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r){
			                    if (r) {
			                    	  $.ajax({
			                              url: "${proPath}/supplier/deleteByPks.action",
			                              type:"POST",
			                              //设置为传统方式传送参数，在谷歌network中看下参数,提交的是pks:1,pks:2，然后再看下去掉traditional，提交的是pks[]:1,pks[]:2
			                              traditional:true,
			                              data:{pks:ids},
			                              success: function(html){
			                              //看下源码，重新刷新页面，加个if(html>0).....
			                                $("#dg").datagrid("reload");
			                                //请除所有勾选的行，支持多页删除，与idField 配合使用，如果不加，删了1,3，再删除2,4时，1和3又在里面了
			                                $("#dg").datagrid("clearSelections");
			                              },
			                                //没成功
			                              error: function (XMLHttpRequest, textStatus, errorThrown) {
			                                    $.messager.alert('删除错误','请联系管理员！','error');
			                                },
			                              dataType:'json'
			                            });

			                    }
				           });
				                   
					   }else {
						   $.messager.show({
								title:'操作提示',
								msg:'请至少选择一个记录',
								showType:'show',
								timeout:3000,
								style:{
									right:'',
									top:document.body.scrollTop+document.documentElement.scrollTop,
									bottom:''
								}
							});

					   }
					}
				},'-',{
					text:"名称：<input type='text' id='supName' name='supName'>",					
				},'-',{
					text:"地址：<input type='text' id='supAddress' name='supAddress'/>",					
				}],		
			       
			    
				columns : [ [{
					checkbox:true,
				}, {
				field : 'supId',
				title : '供应商编号',
				width : 70
			}, {
				field : 'supName',
				title : '供应商名称',
				width : 70
			}, {
				field : 'supLinkman',
				title : '联系人',
				width : 70
			},	{
				field : 'supPhone',
				title : '联系电话',
				width : 100
			}, {
				field : 'supType',
				title : '供应商类型',
				width : 100
			}, {
				field : 'supAddress',
				title : '地址',
				width : 100,
				formatter: function(value,row,index){    
                    return '<span title='+value+'>'+value+'</span>';    
               }
			},{
				field : 'supRemark',
				title : '备注',
				width : 100,
				align : 'right'
			}] ]
		});
			
			$('#supAddress').searchbox({ 
				searcher:function(value,name){ 
					//执行load函数时，参数将取代'queryParams'属性中的参数
					$('#dg').datagrid('load',{
						supName: '%'+$('#supName').val()+'%',
						supAddress:'%'+value+'%',
						//用于单条件查询
						//keyWord:'%'+value+'%'
					});					
				}, 
				prompt:'' 
			});

	});
</script>
</head>

<body>
	<table id="dg"></table>
</body>
</html>