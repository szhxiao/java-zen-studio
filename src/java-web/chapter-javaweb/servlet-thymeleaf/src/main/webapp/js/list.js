function deleteCustomer(id) {
    if (confirm("确认删除？")) {
        window.location.href = "delete.do?id=" + id;
    }
}

function page(pageNo) {
    window.location.href = "list.do?pageNo=" + pageNo;
}
