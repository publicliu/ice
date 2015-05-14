<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.lw.ice.web.util.UserSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网软数据采样平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="shortcut icon" type="image/ico" href="resources/images/logo.ico" />

  <link rel="stylesheet" type="text/css" href="extjs/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" media="all" />
  <link rel="stylesheet" type="text/css" href="resources/css/fish-base.css" media="all" />
  <script type="text/javascript" src="extjs/ext-all-debug.js"></script>
  <script type="text/javascript" src="extjs/locale/ext-lang-zh_CN.js"></script>

  <script type="text/javascript">

  var EwayUserObject = function(id,code,name,orgId,orgName,orgCode){
		var me = this;
		this.id = id;
		this.code = code;
		this.name = name;
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgCode = orgCode;
		return {
			getId : function(){
				return me.id;
			},
			getCode : function(){
				return me.code;
			},
			getName : function(){
				return me.name;
			},
			getOrgId : function(){
				return me.orgId;
			},
			getOrgName : function(){
				return me.orgName;
			},
			getOrgCode : function(){
				return me.orgCode;
			}
		}
	}
  <% if(session.getAttribute("SESSION_USER")==null){%>
	window.location.href="login.html";
<%}else{
	UserSession userSession = (UserSession)session.getAttribute("SESSION_USER");%>
	var ewayUser = new EwayUserObject(
	'<%=userSession.getUserId()%>',
	'<%=userSession.getUserCode()%>',
	'<%=userSession.getUserName()%>',
	'<%=userSession.getOrgId()%>',
	'<%=userSession.getOrgName()%>',
	'<%=userSession.getOrgCode()%>');
<%}%>


  	Ext.BLANK_IMAGE_URL = 'resources/images/s.gif';
  	Ext.Loader.setConfig({
  		/* disableCaching: false,*/
  		enabled:true,
        paths: {
             'Ext.ux': 'extjs/ux'
        }
      });
  	Ext.cxtPath = '<%=request.getContextPath()%>';
  </script>
  <script type="text/javascript" src="app.js"></script>
  </head>

<bodys>
<div id="loading"><span class="title">正在加载中...</span><span class="logo"></span></div>
<iframe id="downloadFileFromWeb" style="display:none"></iframe>
</body>
</html>