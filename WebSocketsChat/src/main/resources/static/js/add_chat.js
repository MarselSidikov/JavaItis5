function addChat(chatName) {
    var json = {};
    // засунули данные в JSON
    json["name"] = chatName;
    $.ajax({
        url: 'http://localhost:8080/chats',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(json),
        headers: {
            "Auth-Token": getCookie("Auth-Token")
        }
    })
}