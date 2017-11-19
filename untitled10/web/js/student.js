var account = "";
var name = "";
$(function () {
    $.ajax({
        url: "/usr?method=auto",
        method: 'post',
        success: function (data) {
            if (data.status) {
                if (data.type == 1) {
                    window.location.pathname = "/admin"
                } else {
                    account = data.account;
                    name = data.name;
                }
            }
        }
    })
})