<%--
  User: zyannan
  Date: 2020/8/25
  Time: 21:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
</head>
<body>
<ul id="productCategory"></ul>

<div id="mm" class="easyui-menu" style="width:120px;">
    <div onclick="append()" data-options="iconCls:'icon-add'">添加子分类</div>
    <div onclick="appendMain()" data-options="iconCls:'icon-add'">添加主分类</div>
    <div onclick="rename()" data-options="iconCls:'icon-edit'">修改</div>
    <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
</div>

<script type="text/javascript">
    let originText;
    $(function () {

        $('#productCategory').tree({
            url: "/product_category/list",
            onContextMenu: function (e, node) {
                e.preventDefault();
                $('#productCategory').tree('select', node.target);
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onAfterEdit: function (node) {

                let _tree = $('#productCategory');

                if (node.operateType == '添加') {
                    $.messager.confirm('提示','确定新增？',function (yes){
                        if(yes){
                            $.post("/product_category/add", {
                                parentId: node.parentId,
                                name: node.text
                            }, function (data) {
                                if (data.status == 200) {
                                    _tree.tree('update', {
                                        target: node.target,
                                        id: data.msg
                                    })
                                } else {
                                    $.messager.alert('提示','添加分类失败');
                                }
                            })
                        }else{
                            _tree.tree('remove', node.target);
                        }

                    })
                }

                if (node.operateType == '修改') {
                    $.messager.confirm('提示','确定修改？',function (yes){
                        if(yes){
                            $.post("/product_category/update", {
                                id: node.id,
                                name: node.text
                            }, function (data) {
                                if (data.status == 200) {
                                } else {
                                    $.messager.alert('提示','修改分类失败');
                                }
                            })
                        }else{
                            _tree.tree('update', {
                                target: node.target,
                                text:originText
                            });
                        }

                    })
                }
            }
        });
    });

    function append() {
        let tree = $('#productCategory');
        let node = tree.tree('getSelected');


        tree.tree('append', {
            parent: node.target,
            data: [{
                id: 'newId',
                parentId:node.id,
                operateType:'添加'
            }]
        });

        let _node = tree.tree('find', 'newId');
        tree.tree('select', _node.target);
        tree.tree('beginEdit', _node.target);


    }
    function appendMain() {
        let tree = $('#productCategory');
        let node = tree.tree('getSelected');


        tree.tree('append', {
            data: [{
                id: 'newId',
                parentId:0,
                operateType:'添加'
            }]
        });

        let _node = tree.tree('find', 'newId');
        tree.tree('select', _node.target);
        tree.tree('beginEdit', _node.target);


    }

    function rename() {
        let tree = $('#productCategory');
        let node = tree.tree('getSelected');
        originText = node.text;
        tree.tree('update', {
            target: node.target,
            operateType:'修改'

        });

        tree.tree('beginEdit', node.target);
    }

    function remove() {
        let tree = $('#productCategory');
        let node = tree.tree('getSelected');


        $.messager.confirm('提示','确定删除？',function (yes){
            if(yes){
                $.post("/product_category/delete", {
                    id: node.id
                }, function (data) {
                    if (data.status == 200) {
                        tree.tree('remove', node.target);
                    } else {
                        $.messager.alert('提示','删除分类失败');
                    }
                })
            }
        })
    }
</script>
</body>
</html>
