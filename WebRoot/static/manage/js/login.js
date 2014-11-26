$(function(){
	if($.trim($.cookie("_uname")) != ""){
		$("#username").val($.trim($.cookie("_uname")));
	}
	
	$("#but_login").click(function(){
		if($.trim($("#username").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("用户名不能为空或空格，请您重新输入！");
			return;
		}
		if($.trim($("#password").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("密码不能为空或空格，请您重新输入！");
			return;
		}
		if($.trim($("#code").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("验证码不能为空或空格，请您输入！");
			return;
		} else{
			$.get("captchaValidate.action", {code : $("#code").val()}, function(flag){
				if(flag){
					$("#errorImage").hide();
					$("#errorMsg").text("");
				} else{
					$("#errorImage").show();
					$("#errorMsg").text("您输入的验证码有误，请您重新输入！");
					return;
				}
				$("#preload").show();
				setTimeout(function(){
					if($("#rememberAccount:checked").size() > 0){
						$.cookie('_uname',$("#username").val(),{expires : 7});
					}
					$('#formLogin').submit();
				}, 500);
			})
		}
	});
	$("body, #username, #password, #code").keypress(function(event){
		if (event.keyCode == 13){
			$("#but_login").trigger("click");
		}
	});
	$("#username").blur(function(){
		if($.trim($("#username").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("用户名不能为空或空格，请您重新输入！");
			return;
		} else{
			$("#errorImage").hide();
			$("#errorMsg").text("");
		}
	});
	$("#password").blur(function(){
		if($.trim($("#password").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("密码不能为空或空格，请您重新输入！");
			return;
		} else{
			$("#errorImage").hide();
			$("#errorMsg").text("");
		}
	});
	$("#code").blur(function(){
		if($.trim($("#code").val()) == ""){
			$("#errorImage").show();
			$("#errorMsg").text("验证码不能为空或空格，请您输入！");
			return;
		} else{
			$.get("captchaValidate.action", {code : $("#code").val()}, function(flag){
				if(flag){
					$("#errorImage").hide();
					$("#errorMsg").text("");
				} else{
					$("#errorImage").show();
					$("#errorMsg").text("您输入的验证码有误，请您重新输入！");
					return;
				}
			})
		}
	});
	$("#resetForm").click(function(){
		$("#username").val("").focus();
		$("#password").val("");
		$("#code").val("");
	});
	// 更换验证码
	$("#codeImg, #changeCode").click(function(){
		$("#codeImg").attr("src", "/kaptcha.jpg?num=" + Math.random());
	});
	
	$("#ligin").center();
	$("#preload").center();
});