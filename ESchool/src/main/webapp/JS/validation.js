function validateLogin(theForm) {

  var reason = "";
  reason += validateUsername(theForm.userNameInput);
  reason += validatePassword(theForm.passwordInput);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = reason;


    return false;
  }
  return true;
}

function validateAddSubjectToTeacher(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.addSubjectToTeacher_teacherName);
  reason += validateEmpty(theForm.addSubjectToTeacher_className);
  reason += validateEmpty(theForm.addSubjectToTeacher_subjectName);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}

function validateAddHomeworkToClass(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.addHomeworkToClass_subjectName);
  reason += validateEmpty(theForm.homeworkNote);
  reason += validateEmpty(theForm.date);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}


function validateAddClass(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.subjectNameInput);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}


function validateAddSubject(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.subjectName);
  reason += validateEmpty(theForm.addSubject_subjectType);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}


function validateCreateUser(theForm) {

  var reason = "";
  reason += validateUsername(theForm.userNameInput);
  reason += validatePassword(theForm.passwordInput);
  reason += validateEmpty(theForm.userNameInput);
  reason += validateEmpty(theForm.createUser_roleList);
  reason += validateEmpty(theForm.firstNameInput);
  reason += validateEmpty(theForm.lastNameInput);
  reason += validateEmpty(theForm.phone);
  reason += validateEmpty(theForm.address);
  reason += validateEmail(theForm.email);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";

    if (validateUsername(theForm.userNameInput) !== "")
      document.getElementById('loginError').innerHTML += validateUsername(theForm.userNameInput);
    if (validatePassword(theForm.passwordInput) !== "")
      document.getElementById('loginError').innerHTML += validatePassword(theForm.passwordInput);
    if (validateEmail(theForm.email) !== "")
      document.getElementById('loginError').innerHTML += validateEmail(theForm.email);
    return false;
  }
  return true;
}





function validateAddStudentInClassForm(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.changeStudentClass_student);
  reason += validateEmpty(theForm.changeStudentClass_classNo);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('addError').style.visibility = 'visible';
    document.getElementById('addError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}


function validateAddRemark(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.remarkNameInput);
  reason += validateEmpty(theForm.addRemark_subjectName);
  reason += validateEmpty(theForm.date);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}

function validateAddAbsence(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.addAbsence_absenceType);
  reason += validateEmpty(theForm.addAbsence_absenceValue);
  reason += validateEmpty(theForm.addAbsence_subject)
  reason += validateEmpty(theForm.date);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}

function validateDelMark(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.delMark_selectedMarkToDel);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}

function validateAddMark(theForm) {

  var reason = "";
  reason += validateEmpty(theForm.addMark_markVal);
  reason += validateEmpty(theForm.date);
  console.log(reason);
  if (reason !== "") {
    document.getElementById('loginError').style.visibility = 'visible';
    document.getElementById('loginError').innerHTML = "Моля попълнете всички полета!\n";


    return false;
  }
  return true;
}


function validateEmpty(fld) {
  var error = "";
  console.log(fld.value.length);
  if (fld.value.length === 0 || fld.value === '-1') {
    fld.style.background = '#D9D7D7';
    error = "Моля попълнете всички полета!\n";

  } else {
    fld.style.background = 'White';
  }
  console.log(error);
  return error;
}

function validateUsername(fld) {
  var error = "";
  var illegalChars = /\W/; // allow letters, numbers, and underscores

  if (fld.value == "") {
    fld.style.background = '#D9D7D7';
    error = "<br/>Не сте въвели потребителско име!<br/>";
  } else if ((fld.value.length < 5) || (fld.value.length > 15)) {
    fld.style.background = '#D9D7D7';
    error = "Потребителското име е с неправилна дължина!<br/>";
  } else if (illegalChars.test(fld.value)) {
    fld.style.background = '#D9D7D7';
    error = "Потребителското име съдържа неправилни символи!<br/>";
  } else {
    fld.style.background = 'White';
  }
  return error;
}
function validatePassword(fld) {
  var error = "";
  var illegalChars = /[\W_]/; // allow only letters and numbers 

  if (fld.value === "") {
    fld.style.background = '#D9D7D7';
    error = "Не сте въвели парола!<br/>";
  } else if (illegalChars.test(fld.value)) {
    error = "Паролата съдържа напозволени символи!<br/>";
    fld.style.background = '#D9D7D7';
  } else {
    fld.style.background = 'White';
  }
  return error;
}
function trim(s)
{
  return s.replace(/^\s+|\s+$/, '');
}
function validateEmail(fld) {
  var error = "";
  var tfld = trim(fld.value);                        // value of field with whitespace trimmed off
  var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
  var illegalChars = /[\(\)\<\>\,\;\:\\\"\[\]]/;

  if (fld.value == "") {
    fld.style.background = '#D9D7D7';
    error = "Не сте въвели правилен интернет адрес!<br/>";
  } else if (!emailFilter.test(tfld)) {              //test email for illegal characters
    fld.style.background = '#D9D7D7';
    error = "Не сте въвели правилен интернет адрес!<br/>";
  } else if (fld.value.match(illegalChars)) {
    fld.style.background = '#D9D7D7';
    error = "Е-пейл адреса съдърна непозволени символи.<br/>";
  } else {
    fld.style.background = 'White';
  }
  return error;
}
function validatePhone(fld) {
  var error = "";
  var stripped = fld.value.replace(/[\(\)\.\-\ ]/g, '');
  if (fld.value == "") {
    error = "You didn't enter a phone number.\n";
    fld.style.background = 'Yellow';
  } else if (isNaN(parseInt(stripped))) {
    error = "The phone number contains illegal characters.\n";
    fld.style.background = 'Yellow';
  } else if (!(stripped.length == 10)) {
    error = "The phone number is the wrong length. Make sure you included an area code.\n";
    fld.style.background = 'Yellow';
  }
  return error;
}