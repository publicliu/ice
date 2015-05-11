


(function($,document,window,undefined){
	$().ready(function(){

		String.prototype.trim=function(){
		    return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		//用户登录
		function doLoginFn(){
			$username = $('#loginUsername');
			$password = $('#loginPassword');
			var username = $username.val();
			var password = $password.val();
			if(username.trim().length == 0){
				$('#loginError').html("请输入登录用户名！").show();
				return;
			}
			if(password.trim().length == 0){
				$('#loginError').html("请输入密码！").show();
				return;
			}
			$.post(
				'api/login',
				 {
					username : username,
					password : password
				 },
				 function(result){
					if(result.success){
						if(result.userState == '0'){
							_updatePassword();
							return;
						}
						if(result.isMessage){
							$('#loginError').html(result.isMessage).show();
						}
						//window.location.href='index.do?id='+result.id;
						window.location.href='index.jsp';

					}
					else {
						if(result.isRegister==false){
							$.colorbox({
								href :"#inline_content",
								inline : true,
								title : '系统注册',
								opacity : 0.5,
								height : 340,
								width : 700,
								overlayClose : false
						  	});
						  	$.ajax({
						  	  url: 'api/system/register',
						  	  dataType: 'json',
						  	  success: function(response){
						  	  	  if(response.success){
							  	  	  $('input[name="key"]').val(response.key);
							  	  	  $('span[name="registerWait"]').hide();
						  	  	  }
						  	  }
			  	  			});
			  	  			return;
						}
						$('#loginError').html(result.message).show();
					}
				 }
			);
	  	}

	  	//回车事件
	  	function onKeydownFn(event){
	  		 if (event.which == 13) {
			     event.preventDefault();
			     doLoginFn();
			    $('#loginUsername').blur();
			    $('#loginPassword').blur();
			 }
	  	}


	  	//密码修改
	  	function _updatePassword(){
	  			$.colorbox({
	  				inline : true,
	  				title : '您的密码是初始化密码，请修改密码',
	  				opacity : 0.5,
		  			height : 400,
		  			width : 700,
		  			overlayClose : false,
		  			href : '#updatePassword'
	  			});
	  			$('input[name="currentUser"]').val($('#loginUsername').val());

	  			$('input[name="password1"]').val('');
	  			$('input[name="password2"]').val('');
	  	}


	  	//重置
	  	function resetFn(){
	  		$('#loginUsername').val('');
			$('#loginPassword').val('');
			$('#loginError').css('display','none');
	  	}

	  	//系统注册提交
		function registerSubmitFn(){
	  		var key = $('input[name="key"]').val();
	  		var serial1 = $('input[name="serial1"]').val();
			var serial2 = $('input[name="serial2"]').val();
			var serial3 = $('input[name="serial3"]').val();
			var serial4 = $('input[name="serial4"]').val();
			var serial5 = $('input[name="serial5"]').val();
			if(key.length==0){
				$('#registerError').html('请等待系统序列号的自动获取!').show();
				return;
			}
			if(serial1.trim().length==0
				||serial2.trim().length==0
				||serial3.trim().length==0
				||serial4.trim().length==0
				||serial5.trim().length==0){
					$('#registerError').html('请输入正确的注册码!').show();
					return;
			}

			var serialValue = serial1.trim()+'-'+serial2.trim()+'-'+serial3.trim()+'-'+serial4.trim()+'-'+serial5.trim();
			$.ajax({
			  type: 'POST',
			  url: 'api/system/register',
			  data: {
				  key : key,
				  serial : serialValue
			  },
			  success: function(object){
				  if(object.success){
	  				  var text = '';
	  				  if(object.type=='1'){
	      				  text = '系统使用权限：没有时间限制';
	  				  }
	  				  else {
	      				  text = '系统到期日期：'+ object.endDate
	  				  }
	  				  $('#registerError').hide();
	  				  $('#registerSuccess').html('注册成功\n'+text).show();
	  				  setTimeout("$.colorbox.close();",2000);
				  }
				  else {
	  				  $('#registerError').html('注册失败!').show();
				  }
			  }
			});

		}

		//密码修改提交
		function updatePasswordSubmitFn(){
			var currentUser = $('input[name="currentUser"]').val();
			var password1 = $('input[name="password1"]').val();
			var password2 = $('input[name="password2"]').val();
			if(password1.trim().length==0
				||password2.trim().length==0
				){
				$('#updatePwdError').html('请输入密码!').show();
				return;
			}

			var pattern = /[^\w-'=\\[\];,.?"`~!@#$%^&*()_+|{}:"<>/]/;
			if(password1.length < 8 || password1.length>20){
				$('#updatePwdError').html('密码长度不符规则!').show();
				return;
			}
			if(pattern.test(password1)){
				$('#updatePwdError').html('密码不符规则!').show();
				return;
			}


			if(password1.trim()!= password2.trim()){
				$('#updatePwdError').html('两次密码不一样!').show();
				return;
			}
			if(password1.trim()=='yihuasoftware'){
				$('#updatePwdError').html('输入的新密码与旧密码相同，不可修改!').show();
				return;
			}
			$.ajax({
			  type: 'POST',
			  url: 'api/login/updatePassword',
			  data: {
				  username : currentUser,
				  password : $('#loginPassword').val(),
				  newPassword : password1
			  },
			  success : function(result){
			  	if(result.success){
			  		$('#updatePwdSuccess').html(result.message).show();
			  		window.location.href='index.jsp';
			  		$.colorbox.close();
			  	}
			  	else {
			  		$('#updatePwdError').html(result.errors).show();
			  	}
			  }
			});

		}

		$('#loginUsername').keydown(onKeydownFn);
		$('#loginPassword').keydown(onKeydownFn);
		$('#loginBtn').click(doLoginFn);
		$('#cancelBtn').click(resetFn);

	  	$('.registerCloseBtn').click(function(){
	  		$.colorbox.close();
	    });
	    $('.udpatePasswordCloseBtn').click(function(){
	    	$('input[name="currentUser"]').val('');
	  		$('input[name="password1"]').val('');
	  		$('input[name="password2"]').val('');
	  		$.colorbox.close();
	    });
	    $('.registerSubmitBtn').click(registerSubmitFn);
	    $('.updatePasswordSubmitBtn').click(updatePasswordSubmitFn);
	});
})(jQuery,document,this);