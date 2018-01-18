var demo = (function(){
	/**
	 * 校验用户名和密码合不合法的判断
	 */
	function checkUser(param1,param2){
//		alert(param1)
		var pattern = /^[a-zA-Z0-9_-]{6}$/;
//		alert(pattern.test(param1))
		if(param1==""||param2==""){
			alert("用户名或密码不能为空！");
			return false;
		}else if(!pattern.test(param1)){
			alert("用户名只能包括数字字母下划线或减号，且长度为6！");
			return false;
		}else{
			return true;
		}
	}
	return {
		checkUser : checkUser
	}
})();
$(function(){
	/**
	 * 用户注册
	 */
	$("#registerbtn").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(demo.checkUser(username,password)){
			$.ajax({
				url:"platform/registerAC!registerUser.action",
				data:
					{
						"user.username" : username,
						"user.password" : password
					},
				dataType:"json",
				type:"post",
				success:function(rs){
						if(rs.user.uid==null){
							alert("用户名已存在！");
						}else{
							alert("注册成功！")
						}
				},error:function(){
					alert("error");
				}
			})
		}
	})
	/**
	 * 用户登录
	 */
	$("#loginBtn").click(function(){
		/**
		 * 以下是登陆，跳转欢迎页面事件；敬请期待~~~~~~~
		 */
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url:"platform/registerAC!loginUser.action",
			data:
				{
					"user.username" : username,
					"user.password" : password
				},
			dataType:"json",
			type:"post",
			success:function(rs){
					if(rs.message){
						//跳转页面
						window.location.href="/demo/index.jsp";
					}else{
						//重新刷新当前页面
						alert("用户名和密码不符，请重新输入！")
						document.location.reload();
					}
					
			},error:function(){
				alert("登录失败！");
			}
		})
	})
})