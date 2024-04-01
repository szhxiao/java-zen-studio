function $(id) {
    return document.getElementById(id);
}

function preRegist() {
    // 用户名不能为空，由4-16位数字和字母组成
    var unameTxt = $("unameTxt");
    var unameReg = /[0-9a-zA-Z]{4,16}/gim;
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    if (!unameReg.test(uname)) {
        unameSpan.style.visibility = "visible";
        return false;
    } else {
        unameSpan.style.visibility = "hidden";
    }

    // 密码
    var pwdTxt = $("pwdTxt");
    var pwd = pwdTxt.value;
    var pwdReg = /^[a-zA-Z]\w{5,17}$/;
    var pwdSpan = $("pwdSpan");
    if (!pwdReg.test(pwd)) {
        pwdSpan.style.visibility = "visible";
        return false;
    } else {
        pwdSpan.style.visibility = "hidden";
    }

    // 确认密码与密码一致
    var pwdCfmTxt = $("pwdCfmTxt");
    var pwdCfm = pwdCfmTxt.value;
    var pwdCfmSpan = $("pwdCfmSpan");
    if (pwdCfm != pwd) {
        pwdCfmSpan.style.visibility = "visible";
        //        return false;
    } else {
        pwdCfmSpan.style.visibility = "hidden";
    }

    // 邮箱
    var emailTxt = $("emailTxt");
    var email = emailTxt.value;
    var emailReg = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    var emailSpan = $("emailSpan");
    if (!emailReg.test(email)) {
        emailSpan.style.visibility = "visible";
        return false;
    } else {
        emailSpan.style.visibility = "hidden";
    }

    return true;
}

var xmlHttpRequest;

function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        // 符合DOM2标准的浏览器
        xmlHttpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
}
function checkUname(uname) {
    createXMLHttpRequest();
    var url = "user.do?operate=checkUname&uname=" + uname;
    xmlHttpRequest.open("GET", url, true);
    // 设置回调函数
    xmlHttpRequest.onreadystatechange = checkUnameCB;
    xmlHttpRequest.send();
}

function checkUnameCB() {
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText;
        // {'uname':'1'}
        //alert(responseText);
        if (responseText == "{'uname':'1'}") {
            // alert(responseText);
            alert("用户名已经被注册！");
        } else {
            // alert(responseText);
            alert("用户名可以注册！");
        }
    }
}
