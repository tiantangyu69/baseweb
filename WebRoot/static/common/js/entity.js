function entity(module){
	var self = this;
	/*移除空值*/
	function removeEmptyFile(){
		$('.fileS').each(function(){
			if($(this).val()==""){
				$(this).parent().parent().remove();
			}
		});
	};
	/*ajax成功后打印的消息*/
	function ajaxSuccessCallback(obj) {
		return false;
	};
	/*ajax失败后打印的消息*/
	function ajaxErrorCallback(XmlHttpRequest, textStatus, errorThrown){
		alert("ajax错误：\nstatus:"+XmlHttpRequest.status+"\nreadyState:"+XmlHttpRequest.readyState+"\ntextStatus:"+textStatus+"\nerrorThrown:"+errorThrown);
	};
	/*批量处理*/
	function doAllEntities() {
		
	};
	this.settings = {
		/*模块名*/
		module : module
	};
	/**
	 * 给属性设置值
	 * <p>
	 * @param name 属性名
	 * @param value 属性值
	 * </p>
	 */
	this.set = function (name,value){
		this.settings[name] = value;
	};
	/*给模块增加方法*/
	this.addDefaultFunction = function (method){
		if(!this.settings[method+"Div"])
			this.settings[method+"Div"] = "#query_"+module+"_div";
//		if(!this.settings[method+"Form"])
//			this.settings[method+"Form"] = "#"+method+"_"+module+"_div";
		if(!this.settings[method+"Action"])
			this.settings[method+"Action"] = "/manager/"+module+"/"+method+".action";
		if(!this.settings[method+"PreSubmit"])
			this.settings[method+"PreSubmit"] = undefined;
		if(!this.settings[method+"Success"])
			this.settings[method+"Success"] = ajaxSuccessCallback;
		if(!this.settings[method+"Error"])
			this.settings[method+"Error"] = ajaxErrorCallback;
	};
	/*执行模块的函数*/
	/*删除的js方法，包括提示*/
	this.run = function (method,params,callback) {
		if(self.settings[method + "PreSubmit"])
			if(self.settings[method + "PreSubmit"]() == false)
				return false;
		if(self.settings[method + "Form"]) {
			$(self.settings[method + "Form"]).ajaxSubmit({  
	            type: 'post',  
	            url: self.settings[method + "Action"] ,  
	            success: function(data){
	                if(self.settings[method + "Success"]) self.settings[method + "Success"](data);
	                if(callback) callback(data);
	            },
	            error: function(XmlHttpRequest, textStatus, errorThrown){  
	            	if(self.settings[method + "Error"]) self.settings[method + "Error"](XmlHttpRequest, textStatus, errorThrown);
	            }
	        }); 
		}else{
			$.ajax({
	            type: "post",  
	            data: params,
	            url: self.settings[method + "Action"],  
	            success: function(data){
	                if(self.settings[method + "Success"]) self.settings[method + "Success"](data);
	                if(callback) callback(data);
	            },
	            error: function(XmlHttpRequest, textStatus, errorThrown){  
	            	if(self.settings[method + "Error"]) self.settings[method + "Error"](XmlHttpRequest, textStatus, errorThrown);
	            }
			});
		}
	};
};
function entityForm(module){
	var self = this;
	entity.call(this, module);
	/*增加管理的方法*/
	this.addDefaultFunction("manager");
	this.set("managerDiv",".main_right");
	this.set("managerSuccess", function (html){
		$(self.settings["managerDiv"]).html(html);
	});
	this.manager = function (params, callback){
		this.run("manager",params, callback);
	};
	
	/*增加默认的弹出添加窗口*/
	this.addDefaultFunction("toAdd");
	this.set("toAddSuccess", function (html){
		$(self.settings["toAddDiv"]).html(html);
		$(".popup_window").draggable({containment: 'body', cancel: '.popup_window_con'});
	});
	this.toAdd = function (params, callback){
		this.run("toAdd",params, callback);
	};
	
	/*添加默认的弹出修改窗口*/
	this.addDefaultFunction("toEdit");
	this.set("toEditSuccess", function (html){
		$(self.settings["toEditDiv"]).html(html);
		$(".popup_window").draggable({containment: 'body', cancel: '.popup_window_con'});
	});
	this.toEdit = function (params, callback){
		this.run("toEdit",params, callback);
	};
	
	/*添加默认的增加方法*/
	this.addDefaultFunction("add");
	this.set("addForm", "#add_"+module+"_form");
	this.set("addSuccess", function (obj){
		if(obj && typeof(obj) == "object") msgbox(null, obj.msg);
	});
	this.add = function (params, callback){
		if(callback == undefined){
			callback = function (data){
				self.query();
			};
		}
		this.run("add",params, callback);
	};
	
	/*添加默认的修改方法*/
	this.addDefaultFunction("edit");
	this.set("editForm", "#edit_"+module+"_form");
	this.set("editSuccess", function (obj){
		if(obj && typeof(obj) == "object") msgbox(null, obj.msg);
	});
	this.edit = function (params, callback){
		if(callback == undefined){
			callback = function (data){
				self.query();
			};
		}
		this.run("edit",params, callback);
	};
	
	/*增加删除的js*/
	this.set("ajaxDeleteByIdAction", "/manager/"+module+"/delete.action");
	
	/*增加删除的js*/
	this.set("ajaxAddAction", "/manager/"+module+"/add.action");
	this.ajaxAdd = function (params, callback){
		this.run("ajaxAdd", params, callback);
	};
	
	/*增加删除的js*/
	this.set("ajaxEditAction", "/manager/"+module+"/edit.action");
	this.ajaxEdit = function (params, callback) {
		this.run("ajaxEdit", params, callback);
	};
	
	/*添加默认的查询方法*/
	this.addDefaultFunction("query");
	this.set("queryDiv", "#query_"+module+"_list");
	this.set("queryForm", "#query_"+module+"_form");
	this.set("querySuccess", function (html){
		$(self.settings["queryDiv"]).html(html);
	});
	this.query = function (params, callback){
		this.run("query",params, callback);
	};
	
	/*添加默认的批量保存的方法*/
	this.addDefaultFunction("saveOrUpdateAll");
	this.set("saveOrUpdateAllForm", "#saveOrUpdateAll_" +module+"_form");
	this.set("saveOrUpdateAllSuccess", function (obj){
		if(obj && typeof(obj) == "object") msgbox(null, obj.msg);
	});
	this.saveOrUpdateAll = function (params, callback){
		this.run("saveOrUpdateAll",params, callback);
	};

	/*添加默认的批量保存的方法*/
	this.addDefaultFunction("processAll");
	this.set("processAllForm", "#processAll_" +module+"_form");
	this.set("processAllSuccess", function (obj){
		if(obj && typeof(obj) == "object") msgbox(null, obj.msg);
	});
	this.processAll = function (params, callback){
		this.run("processAll",params, callback);
	};
	
	/**
	 * @param $bindTarget 必须是jQuery对象
	 */
	this.remove = function($bindTarget) {
		$bindTarget.toggleClass("deleted");
		if($bindTarget.hasClass("deleted")){
			$bindTarget.append("<input type='hidden' name='"+module+".operaterStatus' value='1'/>");
		}else{
			jQuery("input:[name='"+module+".operaterStatus']",$bindTarget).remove();
		}
	};

	/*用于界面的删除，会出现提示信息和刷新列表*/
	this.deleteById = function (params, callback){
		msgbox(null, '确定要删除吗?', function() {
			self.run("ajaxDeleteById", params, function (data){
				self.query();
				if(callback) callback(data);
			});
		});
	};
	
	this.doThis = function ($this,callback){
		$this = jQuery($this);
		var params = getParams($this);
		self.ajaxEdit(params, function (data){
			if(callback) callback(data);
		});
	};
};
entityForm.prototype = new entity();