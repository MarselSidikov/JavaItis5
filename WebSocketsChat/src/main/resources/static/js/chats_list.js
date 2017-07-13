function getChats() {
    $.ajax({
        url: 'http://localhost:8080/chats',
        type: 'get',
        headers: {
            "Auth-Token": getCookie("Auth-Token")
        },
        success: function (data, textStatus, request) {
            var table = document.getElementById("chats_table");
            for (var i = 0; i < data.length; i++) {
                let row = table.insertRow(i + 1);
                let chatId = data[i]["id"];
                row.onclick = function () {
                    window.location = "/chat.html?id= " + chatId;
                };
                var cellName = row.insertCell(0);
                var cellAuthor = row.insertCell(1);
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