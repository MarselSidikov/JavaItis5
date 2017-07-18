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
            writeMessage(JSON.parse(messageOutput.body).message);
        });
    });
}

function sendMessage( message) {
    var json = {};
    json["message"] = message.value;
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
    jQuery('#message').val('');
}

function writeMessage(message) {
    let select = document.getElementById('chatMessagesList');
    let messageOption = document.createElement('option');
    messageOption.value = 0;
    messageOption.innerHTML = message;
    select.appendChild(messageOption);
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}