let express = require('express');
let cookieParser = require('cookie-parser');

let app = express();

app.use(cookieParser());

app.get('/chat_list.html', function(req, res, next) {
    let token = req.cookies['Auth-Token'];
    if (!req.cookies['Auth-Token']) {
        res.redirect("/signin.html")
    }
    next();
});

app.use(express.static('public'));
app.listen(8081);
console.log("StaticServer started...")
