/**
 * Created by Diman on 02.05.2015.
 */
function create(element){
    return document.createElement(element);
}

function getById(id){
    return document.getElementById(id);
}

function millisToGoodLookingString(timeInMillis){
    var date = new Date(+timeInMillis);
    var day = date.getDate();
    var month = date.getMonth()+1;
    var year = date.getFullYear();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    date = day + "." + month + "." + year + "&#x9;"
    + hours + ":" + minutes + ":" + seconds

    return date;
}

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

var sendButton = getById("send");
var msgText="null";
//var messages = getById("messages");
var userName = getCookie("userNick");
var inputField = getById("message");
var feedLine = '&#xa;';
var hTab = '&#x9;';

