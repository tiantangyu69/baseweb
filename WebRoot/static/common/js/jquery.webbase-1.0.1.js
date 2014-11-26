/*
 * @name webbase v1.0.1
 * @author 李智涛
 * @date: 2012-11-05
 * @action web常用操作的插件集合
 */
;
(function($) {
	/* 
	 * @name limitSize
	 * @action 使用limitSize可以很方便的控制文本域或者文本框输入字数的限制,使用方法$("#demo").limitSize({size:100});
	 * @param size 最大输入文字数量,默认为20
	 */
	$.fn.limitSize = function(options) {
		var obj = $(this);
		var defaults = {
			size : 20
		}
		var options = $.extend(defaults, options);
		obj.bind("keyup", function() {
			var StrText = obj.val();
			var _Text = "";
			var _Count = 0;
			for (i = 0; i < StrText.length; i++) {
				_Count = _Count + 1;
				_Text = _Text + StrText.charAt(i);
				if (_Count >= options.size) {
					txt = obj;
					txt.val(_Text);
					break;
				}
			}
		});
	};
	/* 
	 * @name textFocus
	 * @action 使用textFocu将默认文字聚焦时清空，没有写入文字时还原为默认文字,使用方法$("#demo").textFocus({defaultText:"输入文字...."});
	 * @param defaultText 默认文字,默认为:"输入文字...."
	 * @param defaultColor 默认文字颜色,默认为:"#666666"
	 * @param normalColor 正常的文字颜色,默认为:"#000000"
	 */
	$.fn.textFocus = function(options) {
		var obj = $(this);
		var defaults = {
			defaultText : "输入文字....",
			defaultColor : "#666666",
			normalColor : "#000000"
		}
		var options = $.extend(defaults, options);
		obj.each(function(){
			if($.trim($(this).val()) == ""){
				$(this).val(options.defaultText);
			}
			if ($(this).val() == options.defaultText
					|| $.trim($(this).val()) == options.defaultText) {
				$(this).css("color", options.defaultColor);
			} else {
				$(this).css("color", options.normalColor);
			}
			$(this).bind("focus", function() {
				var StrText = $(this).val();
				if (StrText == options.defaultText
						|| $.trim(StrText) == options.defaultText) {
					$(this).val("");
					$(this).css("color", options.normalColor);
				}
			});
			$(this).bind("blur", function() {
				var StrText = $(this).val();
				if (StrText == "" || $.trim(StrText) == "") {
					$(this).val(options.defaultText);
					$(this).css("color", options.defaultColor);
				} else if (StrText == options.defaultText
						|| $.trim(StrText) == options.defaultText) {
					$(this).css("color", options.defaultColor);
					$(this).val($.trim(StrText));
				} else {
					$(this).css("color", options.normalColor);
					$(this).val($.trim(StrText));
				}
			});
		});
	};
	/* 
	 * @name pageNumber
	 * @action 使用pageNumber限制跳转页数的输入字符只能输入大于1的数字,使用方法$("#demo").pageNumber();
	 */
	$.fn.pageNumber = function(options) {
		var obj = $(this);
		var defaults = {}
		var options = $.extend(defaults, options);
		obj.bind("keyup", function() {
			var str = obj.val();
			reg = /^[0-9]d*$/;
			if (event.keyCode != 8) {
				if (!str.substring(str.length - 1).match(reg)) {
					str = "1";
				}
				if (str == "0" || str < 0) {
					str = "1";
				}
			}
			obj.val(str);
		});
		obj.bind("blur", function() {
			var str = obj.val();
			if (str == "" || $.trim(str) == "") {
				str = "1";
			} else {
				if($.isNumeric(str)){
					str = $.trim(str);
				}else{
					str = "1";
				}
			}
			obj.val(str);
		});
	};
	/* 
	 * @name tableColor
	 * @action 使用tableColor更改表格奇偶行和鼠标移入移除的颜色的颜色,使用方法$("#demo").tableColor();
	 */
	$.fn.tableColor = function(options) {
		var defaults = {
			th : "#74B6E6",
			even : "#FFFFFF",
			odd : "#F2F2F2",
			active : "#DFEFFF"
		}
		var options = $.extend(defaults, options);
		$(this).find("thead th").attr("bgcolor", options.th);
		this.each(function() {
			var thisTable = $(this);
			//添加奇偶行颜色
				$(thisTable).find("tbody tr:even")
						.attr("bgcolor", options.even);
				$(thisTable).find("tbody tr:odd").attr("bgcolor", options.odd);
				//添加活动行颜色
				$(thisTable).find("tbody tr").live("mouseover", function() {
					$(this).attr("bgcolor", options.active);
					return false;
				});
				$(thisTable).find("tbody tr").live("mouseout", function() {
					var orgColor;
					if ($(this).index() % 2 == 0) {
						orgColor = options.even;
					} else {
						orgColor = options.odd;
					}
					$(this).attr("bgcolor", orgColor);
					return false;
				});
			});
	};
	/* 
	 * @name checkedAll
	 * @action 使用checkedAll实现复选框的全选和反选操作,使用方法$("#demo").checkedAll();
	 */
	$.fn.checkedAll = function(options) {
		var obj = $(this);
		var defaults = {
			name : "items"
		}
		var options = $.extend(defaults, options);
		obj.bind("click", function() {
			//所有checkbox跟着全选的checkbox走。
				$('[name=' + options.name + ']:checkbox').attr("checked",
						this.checked);
			});
		$('[name=' + options.name + ']:checkbox').live("click", function() {
			//定义一个临时变量，避免重复使用同一个选择器选择页面中的元素，提升程序效率。
				var $tmp = $('[name=' + options.name + ']:checkbox');
				//用filter方法筛选出选中的复选框。并直接给CheckedAll赋值。
				obj.attr('checked',
						$tmp.length == $tmp.filter(':checked').length);
			});
	};

	/* 
	 * @name dateCompare
	 * @action 使用dateCompare比较两个日期的大小,使用方法$.dateCompare(date1,date2);
	 * @param date1 第一个日期的值
	 * @param date2 第二个日期的值
	 * @param separator 分隔符
	 * @return boolean true表示第一个日期小于或等于第二个日期 false第一个日期大于第二个日期
	 */
	$.extend( {
		dateCompare : function(date1, date2, separator) {
			separator = separator || "-";// 日期分隔符
			var flag = true;
			var regex = /((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/ig;// 判断日期是否合法的正则表达式
			var date1s = date1.split(separator);// 分隔第一个日期
			var date2s = date2.split(separator);// 分隔第二个日期
			if (date1.match(regex) && date2.match(regex) && date1s.length == 3
					&& date1s.length == date2s.length) {// 判断日期是否合法
				var year1 = parseInt(date1s[0]);
				var year2 = parseInt(date2s[0]);
				var month1 = parseInt(date1s[1]);
				var month2 = parseInt(date2s[1]);
				var day1 = parseInt(date1s[2]);
				var day2 = parseInt(date2s[2]);
				if (year1 > year2) {
					flag = false;
					return flag;
				} else {
					if (month1 > month2) {
						flag = false;
						return flag;
					} else {
						if (day1 > day2) {
							flag = false;
							return flag;
						} else {
							return flag;
						}
					}
				}
			} else {
				flag = false;
				alert("日期格式不对，请检查日期！");
				return flag;
			}
		}
	});

	/* 
	 * @name maxSize
	 * @action 使用maxSiz限制文本域输入文字的大小,使用方法$("#textarea").maxSize(10);
	 * @param max 最大字符数
	 */
	jQuery.fn.maxSize = function(max) {
		this.each(function() {
			var type = this.tagName.toLowerCase();
			var inputType = this.type ? this.type.toLowerCase() : null;
			if (type == "input" && inputType == "text"
					|| inputType == "password") {
				//Apply the standard maxLength  
				this.maxLength = max;
			} else if (type == "textarea") {
				this.onkeypress = function(e) {
					var ob = e || event;
					var keyCode = ob.keyCode;
					var hasSelection = document.selection ? document.selection
							.createRange().text.length > 0
							: this.selectionStart != this.selectionEnd;
					return !(this.value.length >= max
							&& (keyCode > 50 || keyCode == 32 || keyCode == 0 || keyCode == 13)
							&& !ob.ctrlKey && !ob.altKey && !hasSelection);
				};
				this.onkeyup = function() {
					if (this.value.length > max) {
						this.value = this.value.substring(0, max);
					}
				};
			}
		});
	};
	
	/* 
	 * @name center
	 * @action 使用cente将元素具有浏览器的居中位置,使用方法$("#demo").center();
	 */
	jQuery.fn.center = function() {
		this.css('position', 'absolute');
		this.css('top', ($(window).height() - this.height())
				/ +$(window).scrollTop() + 'px');
		this.css('left', ($(window).width() - this.width()) / 2
				+ $(window).scrollLeft() + 'px');
		return this;
	};
	
	/* 
	 * @name replaceUrl
	 * @action 使用replaceUrl将可点击的链接来替换页面中任何的URL,使用方法$("#demo").replaceUrl();
	 */
	$.fn.replaceUrl = function() {
		var regexp = /((ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?)/gi;
		this
				.each(function() {
					$(this).html(
							$(this).html().replace(regexp,
									'<a href="$1">$1</a>'));
				});
		return $(this);
	};
	
	/**
	 * @action 常用的验证方法
	 */
	$.extend( {
		// 验证上传的附件是否合法
		checkFile : function(name, options) {
			var name = name || "";
			var defaults = {
				size : 10,
				illegalFile : []
			}
			var options = $.extend(defaults, options);
			var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
			$(":file[name='" + name + "']").live("change", function() {
				checkFile($(this)[0])
			});
			function checkFile(target) {
				var fileName = $(target).val();
				var suffix = fileName.substring(fileName.lastIndexOf('.') + 1,
						fileName.length).toLowerCase();// 取得文件的后缀名
				var fileSize = 0;
				for ( var suf in defaults.illegalFile) {
					if (suffix == defaults.illegalFile[suf].toLowerCase()) {
						// 加入弹出信息
						msgbox(null, "不允许上传 "+suffix+" 类型的文件！");
						$(target).val("");
						return;
					}
				}
				if (isIE && !target.files) {
					if(window.ActiveXObject){
						var filePath = target.value;
						var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
						var file = fileSystem.GetFile(filePath);
						fileSize = file.Size;
					}
				} else {
					fileSize = target.files[0].size;
				}
				var actualSize = fileSize / 1024 / 1024;
				if (actualSize > options.size) {
					// 加入弹出信息
					msgbox(null, "文件大小超过" + options.size + "Mb！");
					$(target).val("");
					return false;
				}
			}
		},
		// 验证email是否合法
		isEmail : function(address){
			var address = address || "";
			var eamilReg = /^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/i;
			if(eamilReg.test($.trim(address))){
				return true;
			} else{
				return false;
			}
		},
		// 验证是否为url地址
		isUrl : function(url){
			var url = url || "";
			var urlReg = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/i;
			if(urlReg.test($.trim(url))){
				return true;
			} else{
				return false;
			}
		},
		// 验证是否为手机号码
		isPhone : function(tel){
			var tel = tel || "";
			var telReg = /^1[0-9]{10}$/i;
			if(telReg.test($.trim(tel))){
				return true;
			} else{
				return false;
			}
		},
		// ajax验证是否通过
		ajaxValidate : function(url, data, type){
			var type = type || "post";
			var flag = false;
			$.ajax({
			   type: type,
			   url: url,
			   data: data,
			   dataType:"json",
			   async:false,
			   success: function(result){
				   flag = result;
			   }
			});
			return flag;
		},
		// 验证是否为空
		isBlank : function(str){
			var str = str || "";
			if(str == "" || $.trim(str) == ""){
				return true;
			} else{
				return false;
			}
		},
		// ajax返回json数据
		ajaxJson : function(url, data, type){
			var type = type || "post";
			var flag;
			$.ajax({
			   type: type,
			   url: url,
			   data: data,
			   dataType:"json",
			   async:false,
			   success: function(result){
				   flag = result;
			   }
			});
			return flag;
		},
		// 验证是否是运行上传的附件类型
		allowUpload : function(name, options) {
			var name = name || "";
			var defaults = {
				type : []
			}
			var options = $.extend(defaults, options);
			$(":file[name='" + name + "']").live("change", function() {
				checkFile($(this)[0])
			});
			function checkFile(target) {
				var flag = false;
				var fileName = $(target).val();
				var suffix = fileName.substring(fileName.lastIndexOf('.') + 1,
						fileName.length).toLowerCase();// 取得文件的后缀名
				for ( var suf in options.type) {
					if (suffix == options.type[suf].toLowerCase()) {
						flag = true;
						return true;
					}
				}
				if(!flag){
					if("" != $(target).val()){
						msgbox(null, "不允许上传 "+suffix+" 类型的文件！");
						$(target).val("");
					}
					return false;
				}
				return true;
			}
		}
	});
	
	/* 
	 * @name href
	 * @action 使用href是非超链接元素进行超链接操作,使用方法$("#demo").href("demo.action");
	 * @param url 链接的地址
	 */
	jQuery.fn.href = function(url) {
		var obj = $(this);
		obj.bind("click", function(){
			window.location.href = url;
		});
	};
	
	/* 
	 * @name calSize
	 * @action 使用calSize计算元素的高度和宽度,使用方法$("#demo").calSize();
	 */
	$.fn.calSize = function() {
		var obj = $(this);
		return {width : obj.width(), height : obj.height()};
	};
	
})(jQuery);

// 实现局部打印
;(function($) {
	var printAreaCount = 0;
	$.fn.printArea = function() {
		var ele = $(this);
		var idPrefix = "printArea_";
		removePrintArea(idPrefix + printAreaCount);
		printAreaCount++;
		var iframeId = idPrefix + printAreaCount;
		var iframeStyle = 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;';
		iframe = document.createElement('IFRAME');
		$(iframe).attr( {
			style : iframeStyle,
			id : iframeId
		});
		document.body.appendChild(iframe);
		var doc = iframe.contentWindow.document;
		$(document)
				.find("link")
				.filter(function() {
					return $(this).attr("rel").toLowerCase() == "stylesheet";
				})
				.each(
						function() {
							doc
									.write('<link type="text/css" rel="stylesheet" href="' + $(
											this).attr("href") + '" >');
						});
		doc.write('<div class="' + $(ele).attr("class") + '">' + $(ele).html()
				+ '</div>');
		doc.close();
		var frameWindow = iframe.contentWindow;
		frameWindow.close();
		frameWindow.focus();
		frameWindow.print();
	}
	var removePrintArea = function(id) {
		$("iframe#" + id).remove();
	};
})(jQuery);