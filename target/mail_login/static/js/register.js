//校验用户名:单词的长度3~8
function check_username() {
    //获取用户名
    let value = $("#usernameID").val();
    //定义正则表达式
    let reg_username = /^[\w\u4e00-\u9fa5]{3,8}$/;
    let flag = reg_username.test(value);
    //判断,给出提示
    if (!flag){
        $("#usernameID").css("border","2px solid red");//改变边框颜色
    }else {
        $("#usernameID").css("border","");//改变边框颜色
    }
    return flag;
}
//校验密码:单词的长度6~20
function check_password() {
    let value = $("#passwordID").val();
    let reg_password = /^\w{6,11}$/;
    let flag = reg_password.test(value);
    if (!flag){
        $("#passwordID").css("border","2px solid red");//改变边框颜色
    }else {
        $("#passwordID").css("border","");//改变边框颜色
    }
    return flag;
}


//校验邮箱
function check_email(){
    let val = $("#emailID").val();
    let reg_email = /^\w+@\w+\.\w+$/;
    let flag = reg_email.test(val);
    if(flag){
        $("#emailID").css("border","");
    }else{
        $("#emailID").css("border","2px solid red");
    }
    return flag;
}
//校验手机号码
function check_phone(){
    let val = $("#phoneID").val();
    let reg_phone = /^1[3|4|5|8][0-9]\d{4,8}$/;
    let flag = reg_phone.test(val);
    if(flag){
        $("#phoneID").css("border","");
    }else{
        $("#phoneID").css("border","2px solid red");
    }
    return flag;
}

//校验验证码是否为空
function check_code(){
    let flag = $("#checkCodeID").val();
    if( flag == null){
        $("#checkCodeID").css("border","2px solid red");
    }else{
        $("#checkCodeID").css("border","");
    }
    return flag;
}

$(function (encodedURIComponent) {
    //当表单提交的时候,校验所有
    $("#registerForm").submit(function (encodedURIComponent) {
        //校验全部
        if(check_username() && check_password() && check_email() && check_phone() && check_code()){
            //设置按钮不可用
            $("#btn_sub").attr("disabled", true);
            $("#btn_sub").css("background-color","#8c8c8c");
            $("#btn_sub").val("请稍后...");
            //获取表单信息,转化为json字符串
            let data = JSON.stringify($("#registerForm").serializeJSON());
            //校验通过,发送ajax请求,提交表单
            $.ajax({
                url : "http://localhost:8080/user/register",
                type : "POST",
                dataType:"json",
                contentType : "application/json;charset=UTF-8",
                <!-- 向后端传输的数据 -->
                data : data,
                success:function(data) {
                    <!-- 处理后端返回的数据 -->
                    if(data.flag){
                        //注册成功,跳转到成功页面
                        window.location.href = "register_ok.html";
                    }else{
                        //设置按钮可用
                        $("#btn_sub").attr("disabled",false);
                        $("#btn_sub").css({"background-color":"#ff9900","color":"black"});
                        $("#btn_sub").val("登录");
                        //注册失败,显示异常信息
                        $("#img_check").attr("src","http://localhost:8080/user/checkCode?time=" + new Date().getTime());
                        $("#errorMsg").text(data.errorMsg);
                    }
                },
                error:function(data){
                    //跳转到错误页面
                }
            });
        }
        return false;
    });

    //当某一组件失去焦点时调用校验
    $("#usernameID").blur(check_username);
    $("#passwordID").blur(check_password);
    $("#emailID").blur(check_email);
    $("#phoneID").blur(check_phone);
    $("#checkCodeID").blur(check_code());
});

//切换验证码图片
function refreshCode() {
    //获取验证码对象
    let code = document.getElementById("img_check");
    //设置其src属性，加上上时间戳
    code.src = "http://localhost:8080/user/checkCode?time=" + new Date().getTime();
}

