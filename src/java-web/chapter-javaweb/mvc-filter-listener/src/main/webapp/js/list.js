function deleteCustomer(id) {
    if (confirm("确认删除？")) {
        window.location.href = "customer.do?id=" + id + "&operate=delete";
    }
}

function page(pageNo) {
    window.location.href = "customer.do?pageNo=" + pageNo;
}
