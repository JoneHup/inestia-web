// layui.config({
//     dir: '../layui/' //layui.js 所在路径（注意，如果是script单独引入layui.js，无需设定该参数。），一般情况下可以无视
//     , version: false //一般用于更新模块缓存，默认不开启。设为true即让浏览器不缓存。也可以设为一个固定的值，如：201610
//     , debug: false //用于开启调试模式，默认false，如果设为true，则JS模块的节点会保留在页面
//     , base: '' //设定扩展的Layui模块的所在目录，一般用于外部模块扩展
//     , anim: 1 //默认动画风格
// });
//
//
// //转换HTML
// function escape2Html(str) {
//     var arrEntities = { 'lt': '<', 'gt': '>', 'nbsp': ' ', 'amp': '&', 'quot': '"' };
//     return str.replace(/&(lt|gt|nbsp|amp|quot);/ig, function (all, t) { return arrEntities[t]; });
// }
// //转换为JSON格式
// var DataDeal = {
//     //将从form中通过$('#form').serialize()获取的值转成json
//     formToJson: function (data) {
//         data = data.replace(/&/g, "\",\"");
//         data = data.replace(/=/g, "\":\"");
//         data = "{\"" + data + "\"}";
//         return data;
//     },
// };
// //删除数组中指定的值
// Array.prototype.removeByValue = function (val) {
//     for (var i = 0; i < this.length; i++) {
//         if (this[i] == val) {
//             this.splice(i, 1);
//             break;
//         }
//     }
// }
// ///只针对有ID,url
// Array.prototype.removeByJsonValue = function (val) {
//     for (var i = 0; i < this.length; i++) {
//         if (this[i].id == val) {
//             this.splice(i, 1);
//             break;
//         }
//     }
// }
// Array.prototype.removeByJsonUrl = function (val) {
//     for (var i = 0; i < this.length; i++) {
//         if (this[i].url == val) {
//             this.splice(i, 1);
//             break;
//         }
//     }
// }
// Array.prototype.remove = function (obj) {
//     for (var i = 0; i < this.length; i++) {
//         var temp = this[i];
//         if (!isNaN(obj)) {
//             temp = i;
//         }
//         if (temp == obj) {
//             for (var j = i; j < this.length; j++) {
//                 this[j] = this[j + 1];
//             }
//             this.length = this.length - 1;
//         }
//     }
// }
// Array.prototype.boolValue = function (val) {
//     if (typeof (this) === "string") {
//         if (this == val) {
//             return true;
//         }
//     }
//     else {
//         for (var i = 0; i < this.length; i++) {
//             if (this[i] == val) {
//                 return true;
//             }
//         }
//     }
//     return false;
// }
// String.prototype.boolValue = function (val) {
//     if (this == val) {
//         return true;
//     }
//     return false;
// }
//
//
// function newGuid() {
//     var guid = "";
//     for (var i = 1; i <= 32; i++) {
//         var n = Math.floor(Math.random() * 16.0).toString(16);
//         guid += n;
//         if ((i == 8) || (i == 12) || (i == 16) || (i == 20))
//             guid += "-";
//     }
//     return guid;
// }