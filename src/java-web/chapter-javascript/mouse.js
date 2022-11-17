// 页面加载完成时，绑定各种事件
window.onload = function () {
    // 根据id获取表格
    var tb_fruit = document.getElementById("tb_fruit");

    // 获取表格中的所有行
    var rows = tb_fruit.rows;
    for (let i = 0; i < rows.length; i++) {
        var tr = rows[i];
        tr.onmouseover = showBGColor;
        tr.onmouseout = clearBGColor;

        // 获取某一行的单元格
        var cells = tr.cells;
        var priceID = cells[1];
        priceID.onclick = editPrice;
    }
};

// 鼠标悬浮时，显示背景颜色
function showBGColor() {
    // alert(event.srcElement);
    // alert(event.srcElement.tagName);

    if (event && event.srcElement && event.srcElement.tagName == "TD") {
        var td = event.srcElement;
        var tr = td.parentElement;
        tr.style.backgroundColor = "#76da91";

        var tds = tr.cells;
        for (let i = 0; i < tds.length; i++) {
            tds[i].style.color = "white";
        }
    }
}

function clearBGColor() {
    if (event && event.srcElement && event.srcElement.tagName == "TD") {
        var td = event.srcElement;
        var tr = td.parentElement;
        tr.style.backgroundColor = "transparent";

        var tds = tr.cells;
        for (let i = 0; i < tds.length; i++) {
            tds[i].style.color = "threeddarkshadow";
        }
    }
}

function showHand() {
    if (event && event.srcElement && event.srcElement.tagName == "TD") {
        var td = event.srcElement;
        td.style.cursor = "hand";
    }
}

function editPrice() {
    if (event && event.srcElement && event.srcElement.tagName == "TD") {
        var priceID = event.srcElement;
        var oldPrice = priceID.innerText;
        priceID.innerHTML = "<input type='text' size='4'/>";
        var input = priceID.firstChild;
        if (input.tagName == "INPUT") {
            input.value = oldPrice;
            input.select();
        }
    }
}
