/**
 * 生成随机字符串
 * @param len 长度
 * @returns {string} 随机字符串
 */
function randomString(len) {
    len = len || 32;
    const $chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    const maxPos = $chars.length;
    let result = '';
    for (let i = 0; i < len; i++) {
        result += $chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return result;
}

/**
 * 判断是否为空
 * @param obj 对象
 * @returns {boolean} 是否为空
 */
function isBlank(obj) {
    return obj === undefined || obj === null || obj === '';
}

