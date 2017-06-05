/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validNumber() {
    return (event.ctrlKey || event.altKey
            || (47 < event.keyCode && event.keyCode < 58 && event.shiftKey === false)
            || (95 < event.keyCode && event.keyCode < 106)
            || (event.keyCode === 8) || (event.keyCode === 9)
            || (event.keyCode > 34 && event.keyCode < 40)
            || (event.keyCode === 46));
}

function theValidator() {
    var textBox = document.getElementsByClassName('validator');
    //alert(textBox[1].value.length);
    for (var i = textBox.length - 1; i >= 0; i--) {
        if (textBox[i].value.trim().length === 0)
        {
            alert('Faltan campos por llenar');
            return false;
        }
    }
}
