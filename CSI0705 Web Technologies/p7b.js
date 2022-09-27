var num, anum, str, cont;

// do {
    cont = prompt("How many numbers do you want to enter?");
    anum = 0
    for (var i = 0; i < cont ; i++) {
        num = prompt("Enter a number");
        num = parseInt(num);
        anum = anum * 10 + num;
    }
    document.write("The number is " + anum);
    // cont = prompt("Do you want to continue (y/n)");
// } while (cont == 'y' || cont == 'Y');