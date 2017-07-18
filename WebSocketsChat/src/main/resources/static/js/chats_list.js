function getChats() {
    $.ajax({
        url: 'http://localhost:8080/chats',
        type: 'get',
        headers: {
            "Auth-Token": getCookie("Auth-Token")
        },
        success: function (data, textStatus, request) {
            const table = document.getElementById("chats_table");
            for (let i = 0; i < data.length; i++) {
                let row = table.insertRow(i + 1);
                let chatId = data[i]["id"];

                row.onclick = function () {
                    $.ajax({
                        url: 'http://localhost:8080/chats/' + chatId + '/users',
                        type: 'post',
                        headers: {
                            "Auth-Token": getCookie("Auth-Token")
                        }});
                    window.location = "/stomp_chat.html?id=" + chatId;
                };
                const cellName = row.insertCell(0);
                const cellAuthor = row.insertCell(1);
                cellName.innerHTML = data[i]["name"];
                cellAuthor.innerHTML = data[i]["authorName"];
            }
        }
    })
}

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}