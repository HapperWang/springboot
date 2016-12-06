var stompClient = null;
$(function(){
    //enter绑定
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#sendName").click();
        }
    });
})

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
}

//连接
function connect() {
    var socket = new SockJS('/endpointXing');
    stompClient = Stomp.over(socket); // 使用STOMP子协议的WebSocket客户端
    stompClient.connect({}, function (frame) { //连接WebSocket服务端
            setConnected(true);
            stompClient.subscribe('/topic/getResponse',
            function (response) {
                showResponse(JSON.parse(response.body).responseMessage);
            })
    })
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("disconnected");
}

function sendName() {
    var name = $('#name').val();
    //通过stompClient.send向wilcome目标发送消息
    stompClient.send("/welcome", {}, JSON.stringify({ 'name' : name}));

    $('#name').val('');
}

function showResponse(message) {
    var html = '<p class="response">';
    html += message;
    html += '</p>'
    $("#conversationDiv").append(html);

    if($('.response').length > 10) {
        $('.response').each(function(i) {
            if(i > 9) {
                return;
            } else {
                //删除
                // $(this).remove();
                //隐藏
                $(this).css('display','none');
            }
        })
    }

    //为消息重新排序
    order('response');
}

function order(id) {
    $('.' + id).each(function (i) {
        $(this).attr("class","response response_" + i);
    })
}