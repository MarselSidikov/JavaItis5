const SERVER_API_URL = "http://localhost:8080";
const SERVER_WS_URL = "ws://localhost:8080";

function sendMessage( message) {
    let json = {};
    json["message"] = message.value;
    $.ajax({
        url: SERVER_API_URL + '/chats/' + chatId + '/messages',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        headers: {
            'Auth-Token': getCookie("Auth-Token")
        },
        data: JSON.stringify(json)
    })
}
/**
 * функция вывода сообщения в текстовом поле chatMessagesList
 * @param message - текст сообщения
 */
function writeMessage(from, message) {
    console.log(from + ' ' + message)
    let select = document.getElementById('chatMessagesList');
    let messageOption = document.createElement('option');
    messageOption.value = 0;
    messageOption.innerHTML = from + " : " + message;
    select.appendChild(messageOption);
}
/**
 * функция получения параметров  url'a
 * для того, что бы вытащить только один параметр нужно указать его в -[]
 * например: getUrlVars()['id'];
 * @returns массив всех параметров
 */
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

function sendFile(file) {
    let formData = new FormData();
    formData.append("file", file);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            alert(xhr.responseText);
        }
    };

    xhr.open("POST", "http://localhost:8080/files", true);
    xhr.setRequestHeader("Auth-Token", getCookie("Auth-Token"));
    xhr.send(formData, );
}