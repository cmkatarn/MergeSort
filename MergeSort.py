from array import array
import random


def generate_array(a):
    my_array = [0] * a
    for x in range (0, a):
        my_array[x] = random.randint(0, a)
    return my_array


def merge(first, second):
    a = b = c = 0
    sorted = [0] * (len(first) + len(second))
    while ( a < len(first) ) or ( b < len(second) ):
        if a < len(first):
            if b < len(second):
                if first[a] <= second[b]:
                    sorted[c] = first[a]
                    a += 1
                else:
                    sorted[c] = second[b]
                    b += 1
            else:
                sorted[c] = first[a]
                a += 1
        else:
            sorted[c] = second[b]
            b += 1
        c += 1
    return sorted


def split(c):
    d = c[0 : len(c)/2 ]
    if len(d) != 1:
        d = split(d)
    e = c[ len(c)/2 : len(c) ]
    if len(e) != 1:
        e = split(e)
    return merge(d, e)


def begin_merge_sort(b):
    if len(b) == 1:
        return b
    else:
        return split(b)


def pretty_print(some_array):
    x = 0
    beginning = 0
    while x < len(some_array):
        x += 20
        print (some_array[beginning: x])
        beginning = x


def merge_sort():
    pretty_print(begin_merge_sort(generate_array(100)))


def main():
    merge_sort()


if __name__== "__main__":
    main()