<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>user list</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready( function () {
    $('#table_id').DataTable({
    	ajax:{
    		url:'/admin/user/users-json',
    		dataSrc:''
    	},
    	columns:[
    		{data:'userSeq'},
    		{data:'id',
    			render:function(data, type, row){
    				var userSeq = row.userSeq;
    				if(type == "display"){
    					data = "<a href='/admin/user/users/"+userSeq+"'>"+data+"</a>"
    				}
    				return data;
    			}},
    		{data:'name'}
    	],
    	columnDefs:[
    		{targets:[3],
    			render:function(data, type, row){
    				var html = "<button type='button' name='deleteBtn' onClick=deleteUser('"+row.userSeq+"')>delete</button>";
    				return html;
    			}}
    	]
    });
} );

//회원 삭제하기
function deleteUser(userSeq){
	if(confirm("정말로 삭제하시겠습니까?")){
		$.ajax({
			url: '/admin/user/users/' + userSeq,
			type: 'DELETE',
			success: function(response){
				location.href = "/admin/user/users";
			}
		});
	}
}

</script>
<body>
	<table id="table_id" class="display">
	    <thead>
	        <tr>
	            <th>userSeq</th>
	            <th>id</th>
	            <th>name</th>
	            <th>work</th>
	        </tr>
	    </thead>
	</table>
</body>

<form name="deleteForm" method="DELETE"></form>
</html>