let token;
let chatId;

window.onload = doConnect();

function doConnect() {
    chatId = getUrlVars()['id'];
    // создается объект websocket
    let websocket = new WebSocket(SERVER_WS_URL + '/authHandler');

    websocket.onopen = function (evt) {
        token = getCookie("Auth-Token");
        if (typeof websocket !== 'undefined') {
            websocket.send(token + " " + chatId + " " + $('#message').val());
        } else {
            alert("Not connected.");
        }
    };

    websocket.onmessage = function (evt) {
        writeMessage(JSON.parse(evt.data).from, JSON.parse(evt.data).message);
    };

}

function disconnect() {
                if (typeof websocket !== 'undefined') {
                    websocket.close();
                    websocket = undefined;
                } else {
                    alert("Not connected.");
                }
}
