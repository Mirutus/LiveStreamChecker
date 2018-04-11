package de.orioncraft.utils;

public enum numbers {
    zero(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    }),
    one(new char[][]{
            {'o','o','x'},
            {'o','x','x'},
            {'x','o','x'},
            {'o','o','x'},
            {'o','o','x'},
            {'o','o','x'},
            {'o','o','x'}
    }), two(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'o','o','o','x'},
            {'o','o','x','o'},
            {'o','x','o','o'},
            {'x','o','o','o'},
            {'x','x','x','x'}
    }), three(new char[][]{
            {'x','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'o','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'x','x','x','o'}
    }), four(new char[][]{
            {'o','o','x','x','o'},
            {'o','x','o','x','o'},
            {'o','x','o','x','o'},
            {'x','o','o','x','o'},
            {'x','x','x','x','x'},
            {'o','o','o','x','o'},
            {'o','o','o','x','o'}
    }), five(new char[][]{
            {'x','x','x','x'},
            {'x','o','o','o'},
            {'x','o','o','o'},
            {'x','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'x','x','x','o'}
    }), six(new char[][]{
            {'o','x','x','x'},
            {'x','o','o','o'},
            {'x','o','o','o'},
            {'x','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    }), seven(new char[][]{
            {'x','x','x','x'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'o','o','x','o'},
            {'o','o','x','o'},
            {'o','x','o','o'},
            {'o','x','o','o'}
    }), eight(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    }), nine(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','x'},
            {'o','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    });



    char[][] c;
    int length;

    public int getLength() {
        return length;
    }

    numbers(char[][] c){
        this.c = c;
        this.length = c[0].length;
    }
    public char[][] getValue(){
        return c;
    }

    static public numbers getByInt(int i){
        switch (i){
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            case 6:
                return six;
            case 7:
                return seven;
            case 8:
                return eight;
            case 9:
                return nine;
            case 0:
                return zero;
            default:
                return zero;

        }

    }
}

