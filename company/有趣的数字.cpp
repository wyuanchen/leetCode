#include<iostream>
#include<climits>
using namespace std;

const int N_MAX = 100000;
int a[N_MAX];

void swap(int *array, int i, int j){
        int temp = array[i];
            array[i] = array[j];
                array[j] = temp;
}

void quickSort(int *array, int begin, int end){
        if (begin >= end){
                    return;
                        }
            int pivotIndex = begin + ((end - begin) >> 1);
                swap(array, pivotIndex, end);
                    pivotIndex = begin;
                        for (int i = begin; i < end; i++){
                                    if (a[i] < a[end]){
                                                    swap(a, i, pivotIndex);
                                                                pivotIndex++;
                                                                        }
                                        }
                            swap(a, end, pivotIndex);
                                quickSort(array, begin, pivotIndex - 1);
                                    quickSort(array, pivotIndex + 1, end);
}

void quickSort(int *array, int N){
        quickSort(array, 0, N-1);
}

void count(int *a, int len){
        int min = INT_MAX, cur;
            int maxCount = 0, minCount = 0;
                int left, right;
                    for (left = 1; left < len && a[left] == a[left - 1]; left++){}
                        if (left == len){
                                    maxCount = minCount = len * (len - 1) / 2;
                                        }else{
                                                    for (right = len - 2; right >= 0 && a[right] == a[right + 1]; right--){}
                                                            maxCount = left * (len - 1 - right);
                                                                    for (left = 0; left < len - 1;){
                                                                                    cur = a[left + 1] - a[left];
                                                                                                if (cur > min){
                                                                                                                    left++;
                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                            if (cur < min){
                                                                                                                                min = cur;
                                                                                                                                                minCount = 0;
                                                                                                                                                            }
                                                                                                                        if (cur > 0){
                                                                                                                                            minCount++;
                                                                                                                                                            left++;
                                                                                                                                                                        }else{
                                                                                                                                                                                            for (right = left + 2; right < len && a[right] == a[left]; right++){}
                                                                                                                                                                                                            minCount += (right - left) * (right - left -1) / 2;
                                                                                                                                                                                                                            left = right;
                                                                                                                                                                                                                                        }
                                                                                                                                }
                                                                        }
                            cout << minCount << " " << maxCount << endl;
}

int main(){
        int N;
            while (cin >> N){
                        for (int i = 0; i < N; i++){
                                        cin >> a[i];
                                                }
                                quickSort(a, N);
                                        count(a, N);
                                            }
                
}
