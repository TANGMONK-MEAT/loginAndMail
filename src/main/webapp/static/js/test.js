//当表单提交的时候,校验所有
$("#sub_form").submit(function (encodedURIComponent) {
    //校验全部
    if ($("#email").val() !=='' && $("#password").val() !==''  && $("#check") !=='') {
        //获取表单信息,转化为json字符串
        let data = JSON.stringify($("#sub_form").serializeJSON());
        //校验通过,发送ajax请求,提交表单
        $.ajax({
            url: "http://localhost:8080/user/login",
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            data: data,
            success: function (data) {
                if (data.flag) {
                    //注册成功,跳转到成功页面
                    window.location.href = "http:/localhost:8080/index";
                } else {
                    //刷新验证码
                    refreshCode();
                    $("#error_msg").text(data.errorMsg);
                }
            },
            error: function (data) {
                //跳转到错误页面
            }
        });
    }else{
        alert("请将登陆信息填写完整");
        return false;
    }
});