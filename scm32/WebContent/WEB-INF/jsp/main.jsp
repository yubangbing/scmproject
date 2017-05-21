<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>

<script type="text/javascript">
	$(function() {
		$("a[title]").click(function() {
			var text = this.href;
			//判断是否存在
			if($('#tt').tabs("exists",this.title)){
			//存在则选中
				$('#tt').tabs("select",this.title);			
			}else{
				$('#tt').tabs('add', {
					title:this.title,
					//面板有关闭按键
				    closable:true, 
				    //href对远程页面js的支持不好 
					//href: text			
					//可以加载内容填充到选项卡，页面有Js时，也可加载
					content:"<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px' ></iframe>"
						   
				
				});
				
			}
			return false;
			
		});
	});
</script>

</head>


<body class="easyui-layout">
	<!-- 头部 -->
	<div data-options="region:'north',title:'欢迎使用进销存管理系统',split:true"
		style="height:130px;">欢迎您 ：${sessionScope.accName}</div>
	<!-- 左边导航 -->
	<div data-options="region:'west',title:'导航菜单',split:true"
		style="width:150px;">

		<div id="aa" class="easyui-accordion"
			style="width:300px;height:200px;">

			<div title="基础数据录入">


				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a href="${proPath}/base/goURL/supplier/supplierlist.action" title="供应商管理"
						style="text-decoration: none;display: block;font-weight:bold;">供应商管理</a>
					</li>
					<li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist.action" title="商品管理"
						style="text-decoration: none;display: block;font-weight:bold;">商品管理</a>
					</li>
				</ul>
			</div>


			<div title="进货管理">
			    <ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a href="${proPath}/base/goURL/buyorder/insert.action" title="商品采购"
						style="text-decoration: none;display: block;font-weight:bold;">商品采购</a>
					</li>
					<li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist.action" title="商品退货"
						style="text-decoration: none;display: block;font-weight:bold;">商品退货(未)</a>
					</li>
				</ul>
			</div>

		</div>



	</div>

	<!-- 主体内容 -->
	<div data-options="region:'center',title:'主要信息'"
		style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true"
			style="width:500px;height:250px;">
			<div title="系统介绍" style="padding:20px;">
				<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此系统实现了一个简单的进销存系统网站，包括用户模块、基础数据录入模块、进货管理模块
				，<br>在供应商管理界面中，包括对供应商数据的分页显示、联合查询、增删改，供应商类型使用系统参数<br>来显示给用户。
				商品管理界面功能与供应商界面功能相同。商品采购界面可以填写采购信息概要，选<br>择商品明细，
				点击提交采购时，将采购概要，采购明细存入MySql数据库，并且财务表获取其中的价<br>格信息。</h3>
			</div>

		</div>

	</div>
	<div id="win" ></div>

</body>

</html>