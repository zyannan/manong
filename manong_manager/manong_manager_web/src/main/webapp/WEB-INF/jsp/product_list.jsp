<%--
  Created by IntelliJ IDEA.
  User: zyannan
  Date: 2020/8/24
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table class="easyui-datagrid"
       data-options="
        url:'/product/list',
        fitColumns:true,
        singleSelect:true,
        toolbar:'#bar',
        pageSize:5,
        pageList:[2,5,10,15,20],
        pagination:true,
        rownumbers:true" >
    <thead>
    <tr>
        <th data-options="field:'id',width:100">id</th>
        <th data-options="field:'name',width:100">商品名称</th>
        <th data-options="field:'image',width:100,formatter:showImage">主图</th>
        <th data-options="field:'marketPrice',width:100">市场价格</th>
        <th data-options="field:'price',width:100">价格</th>
        <th data-options="field:'productNumber',width:100">商品编码</th>
    </tr>
    </thead>
</table>

<div id="bar">
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    <a   href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
</div>

<script>
    function showImage(value, row, index){
        if(row.image){
            return  "<img style='height:100px; width:auto' src='http://47.100.212.6:8888/"+row.image+"' />"
        }
    }
</script>
</body>
</html>
