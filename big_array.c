#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "xalloc.c"
#define SIZE 4294967296

//big_array is a structure that holds the number of bytes per cell, and how
//many elements are in the array, and a pointer to an array of all the 
//mini arrays. The arrays will be upto 2^32 bytes

typedef struct{
    int cell_size;
    int num_elems;
    void** index;
} big_array, *BA;
// the first is the type of the struct itself, the second is pointer to a
//struct of that type

BA big_alloc(int cs, long long ne)
{
    BA result = malloc(sizeof(big_array));
    
    int mini_size = SIZE/cs;
    long num_arrays = ne/mini_size + 1;
    void** index = xcalloc(num_arrays, sizeof(void*));

    for(int i = 0; i < num_arrays ; i++)
    {
        index[i] = xcalloc(cs, mini_size);
    }
    
    result->index = index;
    result->num_elems = ne;
    result->cell_size = cs;
    printf("done");
    return result;
}

int main(int argc, char **argv)
{
    BA a = big_alloc(4, 10);
    int test = (int**) a->index[0][3];
    printf("%d", test);
    big_alloc(4, 4294967296);
    big_alloc(atoi(argv[1]), atoi(argv[2]));
}
