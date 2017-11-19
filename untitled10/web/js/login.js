$(function () {
    $.ajax({
        url: "/usr?method=auto",
        method: 'post',
        success: function (data) {
            if (data.status) {
                if (data.type == 1) {
                    window.location.pathname = "/admin"
                }else
                    window.location.pathname = "/student"
            }
        }
    })
    $('#oBtn').click(function () {
        $.ajax({
            url: "/usr?method=login",
            method: "post",
            data: {
                account: $('#oAccount').val(),
                password: $('#oPassword').val()
            },
            success: function (data) {
                if (data.status) {
                    if (data.msg == "student")
                        window.location.pathname = "/student"
                    else if (data.msg == "admin")
                        window.location.pathname = "/admin"
                } else {
                    $('#oTip').removeAttr('hidden')
                    $('#oTip').html('登录失败');
                }
            }
        })
    })
})