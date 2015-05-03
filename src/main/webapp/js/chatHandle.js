/**
 * Created by Diman on 27.04.2015.
 */
document.body.onload = function () {
    infiniteGet();
}

function infiniteGet(){
    timer = setTimeout(function f(){
        getMessages(userName,new Date().getTime());
        timer = setTimeout(f, 1000);
    }, 1000);
}

sendButton.onclick = function(){
    msgText = inputField.value;
    var time = new Date().getTime();
    var message = Message(userName, msgText, time);
    sendMessage(message);
    var date = millisToGoodLookingString(time);
    $('#messages').append(date + hTab + userName  + hTab + msgText + feedLine);
}

function Message(userName, messageText, timeStamp){
    var message={};
    message.userName = userName;
    message.text = messageText;
    message.timeStamp = timeStamp;

    return message;
}

function sendMessage(message){
      $.ajax({
        type: "POST",
        url: "http://localhost:8080/sendMessage",
        data: message,
        success: function(returnedData){
        }
    });
}

function getMessages(userName, afterTime){
    $.getJSON(
        "http://localhost:8080/sendMessage",
        {
            timestamp: afterTime,
            username: userName

        },
        function(data, textStatus, jqXHR){
            $.each(data, function(key, val){
               if (key=="messages"){
                   showMessages(val);
               }
            });
        }
    );
}

function showMessages(msgJSONArray){
    $("#messages").empty();
    $.each(msgJSONArray, function(index, item){
        var userName = item['userName'];
        var date = millisToGoodLookingString(item['timeStamp']);
        msgText = item['text'];
        $("#messages").append(date + hTab  + userName + hTab + msgText + feedLine);
    });
}

