(function () {
    window.onload = function () {
        for (var i = 1; i < 50; i++) {
            for (var j = 1; j < 50; j++) {
                var oImg = document.createElement("img");
                oImg.setAttribute('src', '/' + i + '/' + j + '.jpg');
                document.body.appendChild(oImg);
            }
        }
    }
})();
