$.ajax({
    url: "/error/getAjaxError",
    type: "POST",
    asyne: false,
    success: function (data) {
        debugger;
        if (data.status == 200 && data.msg == "OK") {
            alert("success");
        } else {
            alert("发生异常" + data.msg);
        }
    },
    error: function (response, ajaxOptions, thrownError) {
        alert("error");
    }
});