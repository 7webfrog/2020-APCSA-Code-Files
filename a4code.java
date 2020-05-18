String v = "", w = "";
int k = 0;
for (int i = 0; i < in.length(); i++) {
    if (i < in.length()-1 && (in.charAt(i) == 'a' || in.charAt(i) == 'e' || in.charAt(i) == 'i' || in.charAt(i) == 'o' || in.charAt(i) == 'u') && (in.substring(i, i+2) != " a" || in.substring(i, i+2) != " e" || in.substring(i, i+2) != " i" || in.substring(i, i+2) != " o" || in.substring(i, i+2) != " u")) {
        vowct++;
        v += in.substring(k, i);
        k = i + 1;
    } else if (in.charAt(i) == 'a' || in.charAt(i) == 'e' || in.charAt(i) == 'i' || in.charAt(i) == 'o' || in.charAt(i) == 'u') {
        vowct++;
        v += in.substring(k, i);
        k = i + 1;
    }
}
v += in.substring(k, in.length()-1);
k=0;
for (int j = 0; j < v.length(); j++) {
    if (i < v.length()-1 && v.charAt(i) == v.charAt(i+1)) {
        repltr++;
        w += v.substring(k, i);
        k = i + 1;
    }
}
w += v.substring(k, v.length()-1);