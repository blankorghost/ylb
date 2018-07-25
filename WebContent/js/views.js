function checkEmail() {
    var emailifo = $("#email").val();
    $.ajax({
        type: "post",
        url: "/checkUserEmail",
        data: {"email": emailifo},
        dataType: "json",
        success: function (data) {
            var flag = data.emailFlag;
            if (flag == 1) {
                $("#emailisnull").show();
                $("#emailused").hide();
            } else if (flag == 2) {
                $("#emailused").hide();
                $("#emailisnull").hide();
                $("#emailunused").show();
            } else if (flag == 3) {
                $("#emailisnull").hide();
                $("#emailused").show();
            }
        }
    });
}

function checkUserName() {
    var nameInfo = $("#username").val();
    $.ajax({
        type: "post",
        url: "/checkUserName",
        data: {"username": nameInfo},
        dataType: "json",
        success: function (data) {
            var flag = data.checkUserName;
            if (flag == 1) {
                $("#usernameisnull").show();
                $("#usernameused").hide();
            } else if (flag == 2) {
                $("#usernameisnull").hide();
                $("#usernameused").hide();
            } else if (flag == 3) {
                $("#usernameisnull").hide();
                $("#usernameused").show();
            }

        }
    });
}


