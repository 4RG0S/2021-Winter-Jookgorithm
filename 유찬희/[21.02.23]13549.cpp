#include<iostream>
#include<queue>

using namespace std;
#define endl "\n"

int map[100001] = {0, };

int main(){
	int N,K;
	cin >> N >> K;
	queue<int> q;
	q.push(N);
	int a;
	fill_n(map,100001,100001);
	map[N] = 0;
	while (!q.empty()){
		a = q.front();
		q.pop();
		if (a == K){
			cout << map[a] << endl;
			break;
		}
		if(a * 2 <= 100000){
			if (map[2*a] > map[a]){
				map[2*a] = map[a];
				q.push(2*a);
			}
		}
		if (a - 1 >= 0){
			if (map[a-1] > map[a] + 1){
				map[a-1] = map[a] + 1;
				q.push(a-1);
			}
		}
		if (a + 1 <= 100000){
			if (map[a+1] > map[a] + 1){
				q.push(a+1);
				map[a+1] = map[a] + 1;
			}
		}


	}
}