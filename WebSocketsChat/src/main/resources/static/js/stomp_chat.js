let chatId;

window.onload = doConnect();

function doConnect() {
    chatId = getUrlVars()['id'];
    let socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({'Auth-Token': getCookie('Auth-Token')}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe(
            '/topic/chats/' + chatId,
            // что происходит, когда к нам приходит сообщение
            function (messageOutput) {
            writeMessage(JSON.parse(messageOutput.body).from, JSON.parse(messageOutput.body).message);
        });
    });
}





