function validateCode(){
    var TCode = document.getElementById('xd').value;
    if( /[^a-zA-Z0-9]/.test( TCode ) ) {
       alert('Input is not alphanumeric');
       return false;
    }
    return true;     
 }