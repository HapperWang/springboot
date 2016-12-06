
//form表单提交
$('#form1').submit(function (e) {
    e.preventDefault();
    var text = $('#form1').find('textarea[name = "text"]').val();
    sendSpittle(text);
})

var sock = new SockJS("/endpointChat");
var stomp = Stomp.over(sock);
stomp.connect('guest', 'guest', function(frame) {
    stomp.subscribe("/user/queue/notifications", handleNotification);//给指定用户发送消息
})

function handleNotification(message) {
    $('#output').append("<b>Received: " + message.body + "</b><br/>");
}

function sendSpittle(text) {
    stomp.send("/chat", {}, text);
}

$('#stop').click(function() {
    sock.close();
})