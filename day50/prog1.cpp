#include "iostream"
#include "vector"
#define int unsigned long long
using namespace std;

int getCnt(int n) {
	if(n <= 1 && n > 0) return 1;
	vector<int> v(n + 1);
	v[0] = 1, v[1] = 1;
	for(int i = 2; i <= n; i++) {
		v[i] = v[i - 1] + (i - 1) * v[i - 2];
	}
	return v[n];
}

int32_t main() {
	int n;
	cin >> n;
	cout << getCnt(n);
}
