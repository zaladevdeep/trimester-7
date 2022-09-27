var num, rev, str, cont;

// do {
    num = prompt("Enter a number");
    rev = 0;
    str = num.toString();
    for (var i = str.length - 1; i >= 0; i--) {
        rev *= 10;
        rev += parseInt(str[i]);
    }
    document.write("The reversed number is " + rev);
    // cont = prompt("Do you want to continue (y/n)");
// } while (cont == 'y' || cont == 'Y');