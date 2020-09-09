<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>商品添加</title>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/product_add.js"></script>

<div style="padding: 10px 10px 10px 10px;">
    <form id="productAddForm" method="post">
        <input type="hidden" name="image">
        <input type="hidden" name="description">


        <table cellpadding="10px">
            <tr>
                <td>商品名称</td>
                <td>
                    <input class="easyui-textbox" id="name" name="name" style="width:800px">
                </td>
            </tr>

            <tr>
                <td>商品分类</td>
                <td>
                    <select class="easyui-combotree" id="categoryId" name="categoryId" style="width:200px;"
                            data-options="url:'/product_category/list',panelHeight:150"></select>
                </td>
            </tr>
            <tr>
                <td>市场价格</td>
                <td>
                    <input class="easyui-numberbox" data-options="min:1,max:9999999,precision:2"
                           style="width:800px" id="marketPricePreview" name="marketPricePreview">
                    <input type="hidden" name="marketPrice">
                </td>
            </tr>

            <tr>
                <td>商品价格</td>
                <td>
                    <input class="easyui-numberbox" data-options="min:1,max:9999999,precision:2"
                           style="width:800px" id="pricePreview" name="pricePreview">
                    <input type="hidden" name="price">
                </td>
            </tr>

            <tr>
                <td>商品编号</td>
                <td>
                    <input class="easyui-textbox" style="width:800px" id="productNumber" name="productNumber">
                </td>
            </tr>

            <tr>
                <td>商品主图</td>
                <td>
                    <input id="fileId" name="uploadfile" type="file" onchange="fileChange(this);"/>
                </td>
            </tr>
            <tr>
                <td>主图预览</td>
                <td>
                    <a id="imgA" target="_blank">
                        <img id="img" width="376" height="190">
                    </a>
                </td>
            </tr>

            <tr>
                <td>商品描述</td>
                <td>
                    <script id="editor" type="text/plain" style="width:800px;height:200px;"></script>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <div align="center">
                        <a id="btn" href="javascript:void(0);" class="easyui-linkbutton" onclick="submitForm()">提交</a>
                        <a  href="javascript:void(0);" class="easyui-linkbutton">重置</a>
                    </div>
                </td>
            </tr>

        </table>
    </form>


</div>
<script>
    function fileChange(file){
        let objUrl = getObjectURL(file.files[0]) ;//获取文件信息

        if (objUrl) {
            document.getElementById("img").src = objUrl;
            document.getElementById("imgA").href=objUrl;
        }
    }

    function getObjectURL(file) {
        let url = null;
        if (window.createObjectURL!=undefined) {
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }

    $(function () {
        MANONG.init();
    })

    function submitForm() {

        if($("#name").val() === ""){
            $.messager.alert('提示', '请输入商品名称');
            $("#name").textbox('textbox').focus();
            return;
        }
        if($("#productAddForm").find("input[name='categoryId']").val() === ""){
            $.messager.alert('提示', '请选择商品类别');
            $("#categoryId").combotree('textbox').focus();
            return;
        }
        if($("#marketPricePreview").val() === ""){
            $.messager.alert('提示', '请输入市场价格');
            $("#marketPricePreview").textbox('textbox').focus();
            return;
        }
        if($("#pricePreview").val() === ""){
            $.messager.alert('提示', '请输入商品价格');
            $("#pricePreview").textbox('textbox').focus();
            return;
        }
        if($("#productNumber").val() === ""){
            $.messager.alert('提示', '请输入商品编号');
            $("#productNumber").textbox('textbox').focus();
            return;
        }
        if($("#productAddForm").find("input[name='uploadfile']").val() === ""){
            $.messager.alert('提示', '请选择商品主图');
            $("#productAddForm").find("input[name='uploadfile']").focus();
            return;
        }


        $.ajaxFileUpload({
            url:"/uploadfile",
            fileElementId:'fileId',
            type:'post',
            dataType: 'text',
            success:function (data){
                console.log(data);
                let imageUrl = "http://47.100.212.6:8888/" + data;
                $("#img").attr("src",imageUrl);
                $("#productAddForm").find("input[name='image']").val(data);


                let description = UE.getEditor('editor').getContent();
                $("#productAddForm").find("input[name='description']").val(description);


                //单位：分
                let price = eval($("#productAddForm").find("input[name='pricePreview']").val()) * 100;
                let marketPrice = eval($("#productAddForm").find("input[name='marketPricePreview']").val()) * 100;

                $("#productAddForm").find("input[name='price']").val(price);
                $("#productAddForm").find("input[name='marketPrice']").val(marketPrice);


                $.post("/product_save", $("#productAddForm").serialize(),  function (data) {
                    if (data.status == 200) {
                        $.messager.alert('提示', '成功添加商品');
                    }
                });
            },
            error:function (){
                $.messager.alert('提示', '主图上传失败，无法提交');
                return;
            }
        });


    }


</script>