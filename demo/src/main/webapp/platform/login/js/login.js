$(function(){
	$("#registerbtn").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url:"platform/registerAC!registerUser.action",
			data:{
			user:{
			username:username,
			password:password
			}
			},
			dateType:"json",
			type:"post",
			success:function(){
				alert("ok");
			},error:function(){
				alert("error");
			}
		})
	})
})