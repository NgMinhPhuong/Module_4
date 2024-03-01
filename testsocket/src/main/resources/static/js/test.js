import { io } from "socket.io-client";

console.log("vao")
const socket = io('http://localhost:8080');

// Gửi tin nhắn tới server socket
socket.emit('message', 'Hello from client!');

// Nhận phản hồi từ server socket
socket.on('response', (data) => {
    console.log('Received response from server:', data);
});