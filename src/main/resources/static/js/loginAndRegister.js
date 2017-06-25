loginAndRegister = {
		
	URL : {
		login : function() {
			return "/student/login";
		},
		loginSuccess : function() {
			return "/home";
		},
		register : function() {
			return "/student/register";
		},
		loginAndRegister : function() {
			return "/";
		}
	},
	
	//验证手机号
    validatePhone : function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },
    
    //登录
    login : function () {
    	$("#login").click(function() {
    		var phone = $("#phone").val();
    		if (!loginAndRegister.validatePhone(phone)) {
    			alert("您输入的手机号有误");
    		}
    		var password = $("#pass").val();
    		password = $.md5(password);
    		$.ajax( {    
    		    url : loginAndRegister.URL.login(),   
    		    data : JSON.stringify({    
    		         "studentPhone" : phone,
    		         "studentPassword" : password
    		    }),    
    		    traditional : false,
    		    type : 'post',    
    		    cache : false,    
    		    dataType : 'json',   
    		    contentType : 'application/json; charset=UTF-8',
    		    success : function(data) {    
    		        if (data.success == true) {
    		        	//登录成功，页面跳转
    		        	window.location.href = loginAndRegister.URL.loginSuccess(); 
    		        } else {
    		        	alert(data.message);
    		        }
    		    },    
    		    error : function(data) {      
    		         alert(data.message);    
    		    }    
    		});  
    	})
    },
    
    //注册
    register : function () {	
    	
    	//访问节点并保存
    	const regisPassEle = $('#regisPass');
    	const regisRePassEle = $('#repeatPassword');
    	const regisPhoneEle = $('#regisPhone');
    	const regisUserEle = $('#regisUser');
    	
    	//验证密码
    	$("#repeatPassword").blur(function() {
    		var regisPass = regisPassEle.val();
    		var repeatPass = regisRePassEle.val();
    		if (regisPass != repeatPass) {
    			alert("两次密码不一致");
    		}
    	})
    	
    	//验证手机号
    	$("#regisPhone").blur(function() {
    		var phone = regisPhoneEle.val();
    		if (!loginAndRegister.validatePhone(phone)) {
    			alert("您输入的手机号有误");
    		};
    	})
    	
    	//执行注册操作
    	$("#register").click(function() {
    		
    		var username = regisUserEle.val();
console.log("username"+username);
    		var regisPass = regisPassEle.val();
console.log("regisPass"+regisPass);
    		var repeatPass = regisRePassEle.val();
console.log("repeatPass"+repeatPass);
    		var phone = regisPhoneEle.val();
console.log("phone"+phone);
    		
    		$.ajax( {    
    		    url : loginAndRegister.URL.register(),   
    		    data : JSON.stringify({    
    		         "studentPhone" : phone,
    		         "studentPassword" : $.md5(regisPass),
    		         "studentName" : username
    		    }),    
    		    traditional : false,
    		    type : 'post',    
    		    cache : false,    
    		    dataType : 'json',   
    		    contentType : 'application/json; charset=UTF-8',
    		    success : function(data) {    
    		        if (data.success == true) {
    		        	//注册成功，页面跳转到登录界面
    		        	window.location.href = loginAndRegister.URL.loginAndRegister(); 
    		        } else {
    		        	alert(data.message);
    		        }
    		    },    
    		    error : function(data) {      
    		         alert(data.message);    
    		    }    
    		});  
    	})
    },
    	
    //初始化
    init : function() {
    	loginAndRegister.login();
    	loginAndRegister.register();
    }
		
		
}







