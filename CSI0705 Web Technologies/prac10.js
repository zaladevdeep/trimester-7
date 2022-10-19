function validate()
{
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var phoneno = /^\+?([0-9]{2})\)?[-. ]?([0-9]{10})$/;
  var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
  var dateform = /(0\d{1}|1[0-2])\/([0-2]\d{1}|3[0-1])\/(19|20)\d{2}/;
  var alphaform = /^[0-9a-zA-Z]+$/;
  var ipform = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;

  var email = document.getElementById("email");
  var pass = document.getElementById("pass");
  var cpass = document.getElementById("cpass");
  var ph = document.getElementById("phone");
  var stext = document.getElementById("sptext");
  var date = document.getElementById("date");
  var alpha = document.getElementById("an");
  var ip = document.getElementById("ip4");


  if(!email.value.match(mailformat))
  {
    alert("You have entered an invalid email address!");
    return false;
  }
  if(pass.value != cpass.value)
  {
    alert("Password is not same");
    return false;
  }
  if(!ph.value.match(phoneno))
  {
    alert("Enter 10 digit phone number with Country Code");
    return false;
  }
  if(format.test(stext.value))
  {
    alert("No Special Characters allowed")
    return false;
  }
  if(!date.value.match(dateform))
  {
    alert("Invalid Date Format")
    return false;
  }
  if(!alpha.value.match(alphaform))
  {
    alert("Only Alphanumeric Allowed")
    return false;
  }
  if(!ip.value.match(ipform))
  {
    alert("Enter Proper IP Address")
    return false;
  }
  else
  {
    alert("Welcome");
    true;
  }

}
