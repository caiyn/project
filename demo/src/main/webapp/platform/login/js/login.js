$(function(){
	/**
	 * 用户注册
	 */
	$("#registerbtn").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
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
	})
	/**
	 * 用户登录
	 */
	$("#loginBtn").click(function(){
		/**
		 * 以下是登陆，跳转欢迎页面事件；敬请期待~~~~~~~
		 */
	})
})