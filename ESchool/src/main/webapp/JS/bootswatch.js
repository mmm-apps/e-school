$('[data-toggle="tooltip"]').tooltip();

function loadError()
{
  var myElem = document.getElementsByClassName('errorMessage');
  if (myElem.length > 0) {
    document.getElementById("loginForm").setAttribute("aria-hidden", "false");
    document.getElementById("loginForm").setAttribute("class", "modal fade in");
    document.getElementById("loginForm").setAttribute("style", "display:block;");
    document.body.className = "modal-open";
  }

}