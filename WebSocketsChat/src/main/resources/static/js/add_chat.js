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

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}