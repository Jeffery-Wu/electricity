home = {
		
		showContent : function() {
			
			var Home = $("#home");
			var userHome = $("#userHome");
			var add = $("#add");
			var list = $("#list");
			
			var homeDiv = $("#homeDiv");
			var userHomeIframe = $("#userHomeIframe");
			var addStudentIframe = $("#addStudentIframe");
			var dataTableIframe = $("#dataTableIframe");
			
			Home.click(function() {
				homeDiv.show();
				userHomeIframe.hide();
				addStudentIframe.hide();
				dataTableIframe.hide();
				return false;
			});
			
			userHome.click(function() {
				userHomeIframe.show();
				homeDiv.hide();
				addStudentIframe.hide();
				dataTableIframe.hide();
				return false;
			});
			
			add.click(function() {
				addStudentIframe.show();
				userHomeIframe.hide();
				homeDiv.hide();
				dataTableIframe.hide();
				return false;
			});
			
			list.click(function() {
				dataTableIframe.show();
				userHomeIframe.hide();
				addStudentIframe.hide();
				homeDiv.hide();
				return false;
			});
		},
		
		init : function() {
			
			var homeDiv = $("#homeDiv");
			var userHomeIframe = $("#userHomeIframe");
			var addStudentIframe = $("#addStudentIframe");
			var dataTableIframe = $("#dataTableIframe");
			
			homeDiv.show();
			userHomeIframe.hide();
			addStudentIframe.hide();
			dataTableIframe.hide();
		}
		
		
}