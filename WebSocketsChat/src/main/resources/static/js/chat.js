function sendMessage(chatId, message) {
    var json = {};
    json["message"] = message;
    $.ajax({
        url: 'http://localhost:8080/chats/' + chatId + '/messages',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        headers: {
            'Auth-Token': getCookie("Auth-Token")
        },
        data: JSON.stringify(json)
    })
}

function doConnect() {
    // создается объект websocket
    websocket = new WebSocket("ws://localhost:8080/authHandler");
    // при подключении написать CONNECTED
    websocket.onopen = function (evt) {
        var token = getCookie("Auth-Token");
        if (typeof websocket !== 'undefined') {
            websocket.send(token + " " + "1" + " " + $('#message').val());
        } else {
            alert("Not connected.");
        }
        writeStatus("CONNECTED");
    };

    websocket.onclose = function (evt) {
        writeStatus("DISCONNECTED");
    };

    websocket.onmessage = function (evt) {
        writeMessage(evt.data);
    };

    websocket.onerror = function (evt) {
        onError(writeStatus('ERROR:' + evt.data))
    }
}
