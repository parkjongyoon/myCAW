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
    		url:'/admin/users',
    		dataSrc:''
    	},
    	columns:[
    		{data:'id'},
    		{data:'name'}
    	]
    });
} );
</script>
<body>
	<table id="table_id" class="display">
	    <thead>
	        <tr>
	            <th>id</th>
	            <th>name</th>
	        </tr>
	    </thead>
	</table>
</body>
</html>