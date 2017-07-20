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
                    if(jQuery('#checkbox').prop("checked")){
                        window.location = "/stomp_chat.html?id=" + chatId;
                    }else{
                        window.location = "/chat.html?id=" + chatId;
                    }

                };
                const cellName = row.insertCell(0);
                const cellAuthor = row.insertCell(1);
                cellName.innerHTML = data[i]["name"];
                cellAuthor.innerHTML = data[i]["authorName"];
            }
        }
    })
}
