function login(login, password) {
    $.ajax({
        url: SERVER_API_URL + '/login',
        type: 'post',
        headers: {
            login: login,
            password: password
        },
        success: function (data, textStatus, request) {
            token = request.getResponseHeader('Auth-Token');
            document.cookie = "Auth-Token=" + token;
            if (token !== null) {
                window.location = '/chat_list.html';
            }
        }
    })
}