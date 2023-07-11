const url = "localhost:8081";
function getNmqsAPI() {
    //判断浏览器是http还是https
    if (window.location.protocol === 'https:') {
        return `https://${url}`;
    }
    return `http://${url}`;
}
 
function getNmqsWebsocket() {
    //判断浏览器是http还是https
    if (window.location.protocol === 'https:') {
        return `wss://${url}`;
    }
    return `ws://${url}`;
}