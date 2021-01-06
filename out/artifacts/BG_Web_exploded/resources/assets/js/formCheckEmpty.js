function basicEmptyCheck(form){
    var requiredArr = document.getElementsByClassName('required');

    for (var i = 0; i < requiredArr.length; i++){
        if (requiredArr[i].value == ""){
            alert("양식을 작성해주세요.");
            requiredArr[i].focus();
            return false;
        }
    }
    return true;
}