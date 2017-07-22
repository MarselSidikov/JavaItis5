// подключаем библиотеку express
let express = require('express');
// подключаем библиотеку cookie-parser
let cookieParser = require('cookie-parser');

// создаем наш статик-сервер
let app = express();
// сказали, что наш сервер будет использовать парсер куков
app.use(cookieParser());
// если при запросе страницы .chat_list.html
// не было куков, выполнить редирект
app.get('/chat_list.html', function(req, res, next) {
    let token = req.cookies['Auth-Token'];
    if (!req.cookies['Auth-Token']) {
        res.redirect("/signin.html")
    }
    // ИДТИ ДАЛЬШЕ
    next();
});
// говорим, что мы раздаем статику из папки public
app.use(express.static('public'));
// запускаем сервер на порту 8081
app.listen(8081);
console.log("StaticServer started...")
