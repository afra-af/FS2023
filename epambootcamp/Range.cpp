/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

input format:
input =
5
0 1 3 50 75
0
99
output =
2
4->49
51->74
76->99

first line reads the size of array elements
second line reads the elements
third and fourth lines read lower value and upper values from the user.
*/
#include "iostream"
#include "vector"
using namespace std;

vector<string> getRanges(vector<int>& v, int lower, int upper) {
    vector<string> res;
    if(v[0] != lower) {
        if(v[0] - lower == 1) {
            res.push_back(to_string(lower));
        }else {
            res.push_back(to_string(lower) + "->" + to_string(v[0] - 1));
        }
    }
    
    for(int i = 1; i < (int)v.size(); i++) {
        if(v[i] - v[i - 1] != 1) {
            if(v[i] - v[i - 1] == 2) {
                res.push_back(to_string(v[i - 1] + 1));
            }else {
                if(v[i] < upper) {
                    res.push_back(to_string(v[i - 1] + 1) + "->" + to_string(v[i] - 1));
                }
                else {
                    res.push_back(to_string(v[i - 1] + 1) + "->" + to_string(upper));
                    break;
                }
            }
        }
    }
    
    if(v[v.size() - 1] != upper && v[v.size() - 1] < upper) res.push_back(to_string(v[v.size() - 1] + 1) + "->" + to_string(upper));
    
    return res;
}

int main() {
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto& x : v) cin >> x;
    int lower, higher;
    cin >> lower >> higher;
    
    vector<string> res = getRanges(v, lower, higher);
    
    for(auto& x : res) cout << x << "\n";
}


