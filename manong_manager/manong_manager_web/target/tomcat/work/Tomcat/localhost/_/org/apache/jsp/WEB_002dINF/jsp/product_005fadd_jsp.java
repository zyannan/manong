/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-09-09 14:38:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<title>商品添加</title>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/ueditor.config.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/ueditor.all.min.js\"></script>\r\n");
      out.write("<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->\r\n");
      out.write("<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"ueditor/lang/zh-cn/zh-cn.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/product_add.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"padding: 10px 10px 10px 10px;\">\r\n");
      out.write("    <form id=\"productAddForm\" method=\"post\">\r\n");
      out.write("        <input type=\"hidden\" name=\"image\">\r\n");
      out.write("        <input type=\"hidden\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <table cellpadding=\"10px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品名称</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"easyui-textbox\" id=\"name\" name=\"name\" style=\"width:800px\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品分类</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <select class=\"easyui-combotree\" id=\"categoryId\" name=\"categoryId\" style=\"width:200px;\"\r\n");
      out.write("                            data-options=\"url:'/product_category/list',panelHeight:150\"></select>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>市场价格</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"easyui-numberbox\" data-options=\"min:1,max:9999999,precision:2\"\r\n");
      out.write("                           style=\"width:800px\" id=\"marketPricePreview\" name=\"marketPricePreview\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"marketPrice\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品价格</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"easyui-numberbox\" data-options=\"min:1,max:9999999,precision:2\"\r\n");
      out.write("                           style=\"width:800px\" id=\"pricePreview\" name=\"pricePreview\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"price\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品编号</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"easyui-textbox\" style=\"width:800px\" id=\"productNumber\" name=\"productNumber\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品主图</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input id=\"fileId\" name=\"uploadfile\" type=\"file\" onchange=\"fileChange(this);\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>主图预览</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <a id=\"imgA\" target=\"_blank\">\r\n");
      out.write("                        <img id=\"img\" width=\"376\" height=\"190\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品描述</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <script id=\"editor\" type=\"text/plain\" style=\"width:800px;height:200px;\"></script>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td></td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <div align=\"center\">\r\n");
      out.write("                        <a id=\"btn\" href=\"javascript:void(0);\" class=\"easyui-linkbutton\" onclick=\"submitForm()\">提交</a>\r\n");
      out.write("                        <a  href=\"javascript:void(0);\" class=\"easyui-linkbutton\">重置</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    function fileChange(file){\r\n");
      out.write("        let objUrl = getObjectURL(file.files[0]) ;//获取文件信息\r\n");
      out.write("\r\n");
      out.write("        if (objUrl) {\r\n");
      out.write("            document.getElementById(\"img\").src = objUrl;\r\n");
      out.write("            document.getElementById(\"imgA\").href=objUrl;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function getObjectURL(file) {\r\n");
      out.write("        let url = null;\r\n");
      out.write("        if (window.createObjectURL!=undefined) {\r\n");
      out.write("            url = window.createObjectURL(file) ;\r\n");
      out.write("        } else if (window.URL!=undefined) { // mozilla(firefox)\r\n");
      out.write("            url = window.URL.createObjectURL(file) ;\r\n");
      out.write("        } else if (window.webkitURL!=undefined) { // webkit or chrome\r\n");
      out.write("            url = window.webkitURL.createObjectURL(file) ;\r\n");
      out.write("        }\r\n");
      out.write("        return url ;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    $(function () {\r\n");
      out.write("        MANONG.init();\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    function submitForm() {\r\n");
      out.write("\r\n");
      out.write("        if($(\"#name\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请输入商品名称');\r\n");
      out.write("            $(\"#name\").textbox('textbox').focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if($(\"#productAddForm\").find(\"input[name='categoryId']\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请选择商品类别');\r\n");
      out.write("            $(\"#categoryId\").combotree('textbox').focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if($(\"#marketPricePreview\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请输入市场价格');\r\n");
      out.write("            $(\"#marketPricePreview\").textbox('textbox').focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if($(\"#pricePreview\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请输入商品价格');\r\n");
      out.write("            $(\"#pricePreview\").textbox('textbox').focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if($(\"#productNumber\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请输入商品编号');\r\n");
      out.write("            $(\"#productNumber\").textbox('textbox').focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if($(\"#productAddForm\").find(\"input[name='uploadfile']\").val() === \"\"){\r\n");
      out.write("            $.messager.alert('提示', '请选择商品主图');\r\n");
      out.write("            $(\"#productAddForm\").find(\"input[name='uploadfile']\").focus();\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $.ajaxFileUpload({\r\n");
      out.write("            url:\"/uploadfile\",\r\n");
      out.write("            fileElementId:'fileId',\r\n");
      out.write("            type:'post',\r\n");
      out.write("            dataType: 'text',\r\n");
      out.write("            success:function (data){\r\n");
      out.write("                console.log(data);\r\n");
      out.write("                let imageUrl = \"http://47.100.212.6:8888/\" + data;\r\n");
      out.write("                $(\"#img\").attr(\"src\",imageUrl);\r\n");
      out.write("                $(\"#productAddForm\").find(\"input[name='image']\").val(data);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                let description = UE.getEditor('editor').getContent();\r\n");
      out.write("                $(\"#productAddForm\").find(\"input[name='description']\").val(description);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                //单位：分\r\n");
      out.write("                let price = eval($(\"#productAddForm\").find(\"input[name='pricePreview']\").val()) * 100;\r\n");
      out.write("                let marketPrice = eval($(\"#productAddForm\").find(\"input[name='marketPricePreview']\").val()) * 100;\r\n");
      out.write("\r\n");
      out.write("                $(\"#productAddForm\").find(\"input[name='price']\").val(price);\r\n");
      out.write("                $(\"#productAddForm\").find(\"input[name='marketPrice']\").val(marketPrice);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                $.post(\"/product_save\", $(\"#productAddForm\").serialize(),  function (data) {\r\n");
      out.write("                    if (data.status == 200) {\r\n");
      out.write("                        $.messager.alert('提示', '成功添加商品');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            },\r\n");
      out.write("            error:function (){\r\n");
      out.write("                $.messager.alert('提示', '主图上传失败，无法提交');\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
