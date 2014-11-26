/** 
 * Author:LIZHITAO
 * 公用验证js
 */
$.extend($.fn.validatebox.defaults.rules, {  
    idCard: {// 身份证验证  
        validator: function(value, param){  
            return checkCard(value);  
        },  
        message: '请输入正确的18位身份证号码'  
    },
    telephone: {// 手机号码验证  
        validator: function(value, param){
            return /^1[3|4|5|8][0-9]\d{8}$/.test(value);  
        },  
        message: '请输入正确的11位手机号码'  
    },
    ZW: {// 中文验证 
        validator: function (value) { 
            return /^[\u0391-\uFFE5]+$/.test(value);
		}, 
        message: "只能输入汉字"     
	},
	phone: {// 验证电话号码 带区号的如：023-68698888，不带区号的如：68698888
		validator: function(value, param){
			var phoneRegWithArea = new RegExp(/^[0][1-9]{2,3}-[0-9]{5,10}$/);
			var phoneRegNoArea = new RegExp(/^[1-9]{1}[0-9]{5,8}$/);
			if (value.length > 9) {
				if (phoneRegWithArea.test(value)) {
					return true;
				} else {
					return false;
				}
			} else {
				if (phoneRegNoArea.test(value)) {
					return true;
				} else {
					return false;
				}
			}
		}, 
        message: "请输入正确的电话号码"
	},
	ip: {// 验证是否为ip地址
		validator:function(value, param) {
			var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g // 匹配IP地址的正则表达式
			if (re.test(value)) {
				if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256
						&& RegExp.$4 < 256)
					return true;
			}
			return false;
		}, 
        message: "请输入正确的ip地址"
	},
	money:{// 验证是否为金额
		validator:function(value, param) {
			var regu = /^[0-9]+[\.][0-9]{0,3}$/;
			var re = new RegExp(regu);
			if (re.test(value)) {
				return true;
			} else {
				return false;
			}
		}, 
        message: "请输入正确的金额"
	},
    uniqueUsername:{// 用户名唯一性验证
    	validator:function(value, param){
    		var flag2 = false;
    		if($("#olderUsername").val()){
    			if($("#olderUsername").val() == value){
    				return true;
    			}
    		}
    		$.ajax({// 数据库比对身份证号码是否重复  
                async : false,  
                type : 'get',
                url : 'manage/manageUser/usernameUnique.action?num=' + Math.random(),  
                data : { username:value},  
                success : function(flag) {
                	flag2 = flag;
                }  
            });
    		return flag2;
    	},
    	message: '用户名不能重复'
    }
});

var vcity = {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
             21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",  
             33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",  
             41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",  
             46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",  
             54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",  
             65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"  
            };  
  
checkCard = function(card) {  
    //是否为空  
    if(card === '') {  
        return false;  
    }  
    //校验长度，类型  
    if(isCardNo(card) === false) {  
        return false;  
    }  
    //检查省份  
    if(checkProvince(card) === false) {  
        return false;  
    }  
    //校验生日  
    if(checkBirthday(card) === false) {  
        return false;  
    }  
    //检验位的检测  
    if(checkParity(card) === false)  
    {  
        return false;  
    }  
    return true;  
};  
  
//检查号码是否符合规范，包括长度，类型  
isCardNo = function(card) {  
    //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
    var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;  
    if(reg.test(card) === false) {  
        return false;  
    }  
    return true;  
};  
  
//取身份证前两位,校验省份  
checkProvince = function(card) {  
    var province = card.substr(0,2);  
    if(vcity[province] == undefined) {  
        return false;  
    }  
    return true;  
};  
  
//检查生日是否正确  
checkBirthday = function(card) {  
    var len = card.length;  
    //身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字  
    if(len == '15') {  
        var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;   
        var arr_data = card.match(re_fifteen);  
        var year = arr_data[2];  
        var month = arr_data[3];  
        var day = arr_data[4];  
        var birthday = new Date('19'+year+'/'+month+'/'+day);  
        return verifyBirthday('19'+year,month,day,birthday);  
    }  
    //身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X  
    if(len == '18') {  
        var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;  
        var arr_data = card.match(re_eighteen);  
        var year = arr_data[2];  
        var month = arr_data[3];  
        var day = arr_data[4];  
        var birthday = new Date(year+'/'+month+'/'+day);  
        return verifyBirthday(year,month,day,birthday);  
    }  
    return false;  
};  
  
//校验日期  
verifyBirthday = function(year,month,day,birthday) {  
    var now = new Date();  
    var now_year = now.getFullYear();  
    //年月日是否合理  
    if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day) {  
        //判断年份的范围（3岁到100岁之间)  
        var time = now_year - year;  
        if(time >= 3 && time <= 100) {  
            return true;  
        }  
        return false;  
    }  
    return false;  
};  
  
//校验位的检测  
checkParity = function(card) {  
    //15位转18位  
    card = changeFivteenToEighteen(card);  
    var len = card.length;  
    if(len == '18') {  
        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   
        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');   
        var cardTemp = 0, i, valnum;   
        for(i = 0; i < 17; i ++) {   
            cardTemp += card.substr(i, 1) * arrInt[i];   
        }   
        valnum = arrCh[cardTemp % 11];   
        if (valnum == card.substr(17, 1)) {  
            return true;  
        }  
        return false;  
    }  
    return false;  
};  
  
//15位转18位身份证号  
changeFivteenToEighteen = function(card) {  
    if(card.length == '15') {  
        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   
        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');   
        var cardTemp = 0, i;     
        card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);  
        for(i = 0; i < 17; i ++) {   
            cardTemp += card.substr(i, 1) * arrInt[i];   
        }   
        card += arrCh[cardTemp % 11];   
        return card;  
    }  
    return card;  
};  