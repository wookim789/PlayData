<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="member.MemberDBBean" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import ="member.*" %>

<%!
MemberDBBean mdbb;
ArrayList<MemberDataBean> arr;

int i=0;

%>

<%
	String info_id = (String)request.getParameter("id");
	try {
		
		mdbb = MemberDBBean.getInstance();
		arr = mdbb.getDBListdata();
		for(i = 0 ; i < arr.size(); i++){
			if(arr.get(i).getId().equals(info_id)){
				break;
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<html>
<head>
<title>ȸ������ �ý��� �����ڸ��(ȸ�� ���� ����)</title>
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
</style>
</head>
<body>
<table>
	<tr>
		<td>���̵� : </td>
		<td><%=arr.get(i).getId() %></td> 
	</tr>
	<tr>
		<td>��й�ȣ : </td>
		<td><%=arr.get(i).getPassword() %></td>
	</tr>
	<tr>
		<td>�̸� : </td>
		<td><%=arr.get(i).getName() %></td>
	</tr>
	<tr>
		<td>���� : </td><td><%=arr.get(i).getAge() %></td>
	</tr>
	<tr>
		<td>���� : </td><td><%=arr.get(i).getGender() %></td>
	</tr>
	<tr>
		<td>�̸��� �ּ� : </td>
		<td><%=arr.get(i).getEmail() %></td>
	</tr>
	<tr>
		<td colspan=2><a href="member_list.jsp">����Ʈ�� ���ư���</a></td>
	</tr>
</table>
</body>
</html>