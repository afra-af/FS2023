/*Rakesh is playing a word game to read a string from the user and expand the string in the following given example.
help him to expand the string into expanded form.
example:
input =5[x]3[yz]
output =xxxxxyzyzyz
input =4[x3[y]]
output =xyyyxyyyxyyyxyyy
input =2[uvw]3[xy]z
output =uvwuvwxyxyxyz*/


#include<bits/stdc++.h>
#include<iostream>
#include<string.h>
using namespace std;
string samplefunc(const string& s, int& i) {
        string res;

        while (i < s.length() && s[i] != ']') {
            if (!isdigit(s[i]))
                res += s[i++];
            else {
                int n = 0;
                while (i < s.length() && isdigit(s[i]))
                    n = s[i++] - '0';//gets the ascii value if it is number
                    //cout<<n;

                i++; // '['     5[x]3[yz]
                string t = samplefunc(s, i);
                i++; // ']'

                while (n-- > 0)
                    res += t;
            }
        }

        return res;
    }

    string samplefunc(string s) {
        int i = 0;
        return samplefunc(s, i);
    }
int main(){
    string s;
    cin>>s;

    cout<<samplefunc(s);
    return 0;
}
