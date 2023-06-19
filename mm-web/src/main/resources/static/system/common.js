const url = "localhost:8081";
function getNmqsAPI() {
    return `http://${url}`;
}

function getNmqsWebsocket() {
    return `ws://${url}`;
}
