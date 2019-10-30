<html>
<body>
<h2>Hello World!</h2>
<button id="loadexcel">loadexcel</button>
</body>
<script>
    var loadex = document.getElementById("loadexcel");
    loadex.onclick = function () {
        window.location.href = "report/export";
    }
</script>
</html>
