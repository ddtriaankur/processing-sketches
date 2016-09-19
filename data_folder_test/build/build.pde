/*
Loads the data strings from my github account 
*/


String[] lines = loadStrings ("https://raw.githubusercontent.com/ddtriaankur/processing-sketches/master/notes.txt");
for (int i = 0; i < lines.length; ++i) {
println(lines [i]);
}

// https://raw.githubusercontent.com/ddtriaankur/processing-sketches/master/notes.txt