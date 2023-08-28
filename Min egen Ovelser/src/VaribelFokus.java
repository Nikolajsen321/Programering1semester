public class VaribelFokus {
    public static void main(String[] args){




    }
}


// Variable declare, er man fortæller compiler dens navn og hvad data den kan lager
//variable declartion fortæller compiler til allocate memory space for variablen baseret på data type
// syntax for declaring variable: datatype variableName
// ex på af samme datatype:  datatype variable1, variable2, variable3 osv
// intalize variable fx 1 trin: int count = 1;   eller flere int count; hvor count = 1;
/* kan også  int i = 1, j = 2;

Assigments statement:  variable = expression
expression er en computation invovling values, variables , and operators that take them together, evaluates to a value
Assigment statement: expression på højre side af assigment operator evalueret, og derefter
assigned til variablen til venstre for:
int y = 1;    assign 1 til variablen y
int x = 5 * (3 / 2); assign value of expression til variablen x
x = y + 1; assign addition af y med 1 til x
double area =  radius * radius * 3.14159;   udregning (compute) af areal
 assign flere variabler til hinanden:  i = j = k = 1;
 samme
 k = 1;
 j = k;
 i = j;

 Named constant: identifier der repræsenter permanent værdi
 Kendt som final variable  fx PI er konstant og kan declares

 Syntax: final datatype CONSTANTNAME = value;

 Navne konvention:
1. Brug små bogstaver for variable og methods
 variable radius og area, og metoden print
concate flere ord i hvor først ord er med småt og de andre er med stor
"bilenHusHund" cammelCase
2. først bogstav i en class af et ord skal være med stort "ComputeArea"
3. først bogstav i en konstant skal være med stort og så bruger man underscore mellem ord
"PI" og "Max_Value"


Condition:
hvad programmet skal udføre for en betingelse
selections statements:
ex
if(radius > 0) { .
.
.
}
else {
...
selection statement bruger betingelser der er Boolean expression evaluates til true eller false



String:

en predefined class som System og Scanner
følgende declare message er en string med værdien "Welcome to Java"
ex: String message = " Welcome to Java "
ikke primitive type men reference type
og variabler declared af en reference type er reference variabler der reference til et obejkt

Simple metoder for et String Objects:
Da Strings er objects i Java


length()  - returns the number of characters in the string
ex String message = "Welcome to Java"
System.out.println( message.length() )     length = 15

characterAt(index)  - returns character at a specified index from string
ex  String str = "BeginnerBook"
char ch = str.charAt(0)   vil give B



concat(s1) - returns new string that concatenates the string with s1
s2 = message;
s1 = HTML;

String s3 = s2 + s1;
bliver: messageHTML
eller
String myString = message + " and " + "HTML";




toUpperCase() - returns a new string with all leters in upper case
toLowerCase() - returns a new string with all leters in lowercase
ex:
String ord2 = " Hej med dig";
String uppord2 = ord2.toUpperCase();


trim() - returns a new string with whitespace character trimed on both sides

alle eksempler oversåtende kan kun ivokes fra specific string instance, derfor er det kaldet instance methods
non instance methods kaldes for static method og kan invokes uden at bruge et objekt
fx alle methods defined i Math class er static methods ikke tied til et specfikt object instance

Syntax til at invoke en instance method er: referenceVariable

methodName(arguments)

method kan have arguments eller ingen arguments

ex charAt (index) method har et argument
hvor: length () method har ingen arguments

Syntax static method:  ClassName.methodName(arguments)
ex pow method i Math class can invokes

Math.pow(2, 2.5)

ex String length
String message = "Welcome to Java";
System.out.println("the length of" + message + " is " + message.length())      length = 15

ex charAt(index)
s.charAt(index) method kan få en specfik character i en string  s, hvor index er mellem 0 og s.length()-1
Welcome to Java   = 16 - 1 =15
da 0 = W
i message.charAt(0)         hvor String message = "Welcome to Java";
character i String object kan blive tilgået ved at bruge index



Concate string:
kan bruge concate method til concatenate to strings

ex concatenate s1 og s2 til s3
String s3 = s1.concat(s2);   =  String s3 = s1 + s2;

 += kan også bruges til string concatenation

String message = "Welcome to Java";

message += " and java is fun ";


Convert strings:
toLowerCase() method returner en ny string med alle bogstaver med småt
toUpperCase() -||- med stort
String message = "Welcome to Java";

String lower = Welcome.toLowerCase();
String upper = Welcome.toUpperCase();

trim() method returnere en ny string ved at fjerne whitespace character fra begge ender af stringen
white space character: '',\t, \f, \r og \n er kendt som white space char
hvor
" \t Good Night \n.trim(); returns en ny string Good Night

String fra keyboard:
Scanner input = new Scanner(System.in);
String s1 = input.next();
String s2 = input.next();
String s3 = input.next();

System.out.println("s1 is" + s1);    = Welcome
System.out.println("s2 is" + s2);    =  to
System.out.println("s3 is" + s3);     = Java


next() method læser en string der ender med en whitespace character
nextLine kan bruges til at læse en hel linje af text
ex
Scanner input = new Scanner(System.in);
String s = input.nextLine();    = welcome to Java
System.out.println("the line entered is " + s); = the line entered is Welcome to Java

input der bruger methods next(), nextByte(), nextShort(), nextInt()  nextDouble() osv
kaldes the token - based input, da de læser indviuelle elementer seperated by whitespace character rather than entire line

nextLine() method kaldes for line - based input

Aflæsning en character fra keyboard:

Scanner input = new Scanner(System.in);
System.out.print("Enter a character: ");
String s = input.nextLine();
char ch = s.charAt(0);
System.out.println("The character entered is " + ch);

Comparing Strings


 */
