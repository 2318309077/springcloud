package com.ceway.common.util;

public enum ResultStatusCode {
	OK(200, "OK"),  
	NO_DATA(402,"无数据"),
	INVALID_PARAM(400, "参数不合法"),
	INVALID_AUTH(401, "用户权限不够"),
	SYSTEM_ERR(500, "系统错误"), 
	INVALID_PASSWORD(10001, "用户名或密码错误"),  
	INVALID_TOKEN(10002, "无效的TOKEN"),
	INVALID_HEADER_PARAM(10003, "参数头标识不合法"),
	EXPIRED_TOKEN(10004, "TOKEN过期"),
	FORGED_TOKEN(10005, "伪造的TOKEN"),
	PROHIBIT_LOGIN(10006, "禁止登陆"),
	UNAUTHORIZED_APP(20001, "未授权的应用"),
	UNAUTHORIZED_SERVICE(20001, "未授权的服务"),
	NOPERMISSION_USER(20003, "未授权的用户"),
	
	
	//////ump//////////
	NOT_REGISTER(801, "您的号码未在工厂中注册"),
	NOT_FOUND_FACTORY(802, "未找到该工厂"),
	NOT_FILL_SMS_CODE(803, "未填写验证码"),
	SMS_HYSTRIX_COMMAND(804, "短信发送服务异常，启动断路由！！！"),
	INVALID_SMS_CODE(805, "无效的验证码"),
	NOT_FILL_SMS_PHONE(806, "未填写手机号码"),
	NOT_AUTH_FACTORY(807, "未认证的工厂企业"),
	
	APP_USR_LIMIT(808, "APP用户限制达到最大值"),
	REPAET_PHONE(809, "重复的手机号码"),
	
	FACTORY_NAME_REPAET(810, "工厂名称已经存在"),
	FACTORY_NUMBER_REPAET(810, "企业号已经存在"),
	FACTORY_IS_NULL(811, "没有找到该工厂信息"),
	MODULE_IS_NULL(812, "没有找到模块信息"),
	MODULE_NAME_REPAET(813, "模块名称已存在"),
	FUNCTION_NAME_REPAET(814, "功能已经存在"),
	FUNCTION_IS_NULL(815, "没有找到功能信息"),
	SYNC_FUNCTION_ERROR(816, "同步功能点失败"),
	FACTORY_SAVE_ERROR(817, "工厂信息更新异常"),
	USER_FACTORY_EXIST(818, "该工厂已经对应一个用户"),

	FACTORY_CONNECTION_ERROR(819, "接入EP异常"),
	FACTORY_CONNECTION_FAIL(820, "接入EP失败，远程EP连接不上"),
	/**
	 * 服务名称存在提示信息
	 */
	SERVICE_NAME_ERROR(821,"服务名称已存在"),
	/**
	 * 服务编码已存在提示信息
	 */
	SERVICE_CODE_ERROR(822,"服务编码已存在"),
	/**
	 * 外部端口已存在提示
	 */
	SERVICE_NODE_PORT_ERROR(823,"该外部端口已被其他服务占用"),

	USER_ALREADY_EXIST(900, "该用户已经存在"),
	USER_NOT_EXIST(901, "该用户不存在"),
	PASSWORD_NOT_NULL(902, "密码不能为空"),
	ADMIN_NOT_FOUND(903, "找不到管理员"),
	MENU_NOT_FOUND(904, "找不到该菜单"),
	FUNCTION_NOT_FOUND(905, "找不到该功能"),
	
	AUTH_VALIDATE_ERROR(906, "权限校验异常"),
	AUTH_NOT_ENOUGH(907, "权限不足"),
	POINT_FIELD_NOT_FOUNT(908, "指定字段未找到值"),
	SEARCH_VALUE_NOT_FOUND(909, "无法找到搜索值"),
	SAVE_MENU_ERROR(910, "保存菜单异常"),
	
	USER_SAVE_ERROR(911, "保存用户失败"),
	DELETE_MENU_ERROR(912, "删除菜单异常"),
	SAVE_FUNCTION_ERROR(913, "保存功能异常"),
	DELETE_FUNCTION_ERROR(914, "保存功能异常"),
	UPDATE_FUNCTION_ERROR(915, "更新功能异常"),
	UPDATE_PASSWORD_ERROR(916, "更新密码异常"),
	PAST_PASSWORD_ERROR(917, "当前密码错误"),
	
	UPLOAD_APP_NOT_NULL(930, "上传文件不能为空"),
	UPLOAD_OVER_LIMIT(931, "上传文件大小超出限制"),
	UPLOAD_APP_INFO_ERROR(932, "上传文件信息出错"),
	
	FILE_NOT_FOUND(933, "文件找不到"),
	FILE_DATA_NOT_FOUND(934, "文件信息找不到"),
	FILE_TYPE_INCORRECT(935, "文件类型出错"),
	
	APP_NOT_EXIST(936, "该应用找不到"),
	APP_STATUS_ERROR(937, "App状态异常"),
	
	USER_NOT_DEVELOPER(950, "该用户不是开发者"),
	DEVELOPER_NOT_COMPLETE(951, "开发者信息不全"),
	DEVELOPER_INSERT_ERROR(952, "开发者注册异常"),

	VALIDATE_CODE_FAIL(953, "请输入正确的验证码"),
	PASSWORD_NOT_EQUALLY(954, "两次输入密码不一致"),

	NO_FACTORY(956,"企业号不能为空"),
	NO_APPID(957,"appId不能为空"),
	NO_DEPLOYSTATUS(958,"部署状态不能为空"),
	
	QUALIFICATION_FAIL(960,"认证失败"),
	QUALIFICATION_NOT_FOUND(961, "认证信息找不到"),
	QUALIFICATION_EXIST(962, "用户已认证"),
	
	/**购物车	*/
	APP_IN_SHOPPINGCART(963, "该应用已在购物车中")
	;

	private int code;  
	private String msg;  

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private ResultStatusCode(int code, String msg){  
		this.code = code;  
		this.msg = msg;  
	}  
}