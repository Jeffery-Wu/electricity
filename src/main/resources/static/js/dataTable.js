dataTable = {
		
		URL : {
			getData : function() {
				return "/student/list";
			}
		},


		fillData : function() {
			$.ajax( {    
    		    url : dataTable.URL.getData(),   
    		    traditional : false,
    		    type : 'get',    
    		    cache : false,    
    		    dataType : 'json',   
    		    contentType : 'application/json; charset=UTF-8',
    		    success : function(data) {    
    		        //请求数据成功,把数据渲染到页面。
    		    	if (data.success == true) {
    		    		dataTable.fill(data);
    		    		
//    		    		var fg = document.createDocumentFragment()
//    		    		var js1 = document.createElement('script')
//    		    		js1.src = 'js/lib/dataTables.bootstrap.js'
//    		    		var js = document.createElement('script')
//    		    		js.src = 'js/lib/jquery.dataTables.min.js'
////    		    		document.body.appendChild(js)
//    		    		
////    		    			document.body.appendChild(js1)
//    		    		
//    		    		var js2 = document.createElement('script')
//    		    		js2.src = 'js/lib/test.js'
//    		    		document.body.appendChild(js2)
//    		    		fg.appendChild(js)
//    		    		fg.appendChild(js1)
//    		    		document.body.appendChild(fg)
    		    		$(document).ready(function() {
	    		    		console.log("cccc");
	    		    		$('#example').dataTable();
    		    		});
    		    		
    		    		$('#example').removeClass('display').addClass(
    		    				'table table-striped table-bordered');
    		    	} else {
    		    		alert(data.message);
    		    	}
    		    },    
    		    error : function(data) {      
    		         alert(data.message);    
    		    }    
    		});  
		},
		
		fill : function(data) {
			//遍历数据
			var html = "";
			for (var i = 0; i < data.data.length; i++) {
				html += "<tr>"
					+"<td>"+data.data[i].studentId+"</td>"
					+"<td>"+data.data[i].studentName+"</td>"
					+"<td>"+data.data[i].studentPhone+"</td>"
					+"<td>"+data.data[i].studentSex+"</td>"
					+"<td><a href='#'><img src='img/delete.png' height='20' width='20' /></a><a href='#'><img src='img/edit.png' height='20' width='20' /></a></td>"
					+"</tr>";
			}
			$("tbody").empty();
			$("tbody").html(html);
		}
		
}



