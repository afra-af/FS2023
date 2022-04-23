/*1) Given single linked list of digits, and given k value.

add k value to linked list 

note: 0<k<9 (k value is single digit number only)

ex:
input =1 2 3
1
output =1 2 4

input =1 0 0
5
output =1 0 5

input = 9 9 9 9 
1
output =1 0 0 0 0

input =1 2 9 9
1
output =1 3 0 0
*/
#include "iostream"
using namespace std;

int main() {
    int n;
    cin >> n;
    string s = "";
    string str = "";
    int temp;
    for(int i = 0; i < n; i++) {
        cin >> temp;
        s += to_string(temp);
    }
    int k;
    cin >> k;
    int con = stoi(s) + k;
    str.append(to_string(con));
    for(int i = 0; i < str.size(); i++) {
        cout << str[i] << " ";
    }
}
