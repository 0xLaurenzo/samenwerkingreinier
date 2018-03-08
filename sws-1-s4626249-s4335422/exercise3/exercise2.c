#include <stdio.h>
#include <stdlib.h>

int main()
{
	int p = 1;
	while(malloc(p)) {
		p++;
	}
	p--;
	printf("One malloc can allocate at most" p "bytes.");
}
