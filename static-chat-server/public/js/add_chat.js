function addChat(chatName) {
    var json = {};
    // засунули данные в JSON
    json["name"] = chatName;
    $.ajax({
        url: SERVER_API_URL + 'chats',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(json),
        headers: {
            "Auth-Token": getCookie("Auth-Token")
        }
    })
}