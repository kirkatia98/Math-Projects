#include <stdlib.h>
#include <stdio.h>
#include <assert.h> 
#include <math.h>

double sqrtAprox (double lo, int n, double hi, double error)
{
    assert(n > error);
    assert(error >= 0.00001)
    double mid = lo + (hi - lo)/2;
    double ans = mid * mid;
    if (n == ans) return mid;
    if (fabs( n - ans) > error)
    { 
       if (n > ans) return sqrtAprox(mid, n, hi, error);
       if (n < ans) return sqrtAprox(lo, n, mid, error);
    }
    else return mid;
}
int main () {        
printf("%lf\n", sqrtAprox(0, 9, 9, 0));
printf("%lf\n", sqrtAprox(0, 16, 40, 0));
printf("%lf\n", sqrtAprox(0, 12730191, 19908000, 0.00000001));
printf("%lf\n", sqrt(12730193));
}

