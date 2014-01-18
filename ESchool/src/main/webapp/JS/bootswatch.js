$('[data-toggle="tooltip"]').tooltip();

function loadError()
{
  var myElem = document.getElementsByClassName('errorMessage');
  if (myElem.length > 0) {
    document.getElementById("myModal").setAttribute("aria-hidden", "false");
    document.getElementById("myModal").setAttribute("class", "modal fade in");
    document.getElementById("myModal").setAttribute("style", "display:block;");
    document.body.className = "modal-open";
  }

}