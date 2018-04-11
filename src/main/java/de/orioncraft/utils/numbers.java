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
    },'0'),
    one(new char[][]{
            {'o','o','x'},
            {'o','x','x'},
            {'x','o','x'},
            {'o','o','x'},
            {'o','o','x'},
            {'o','o','x'},
            {'o','o','x'}
    },'1'), two(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'o','o','o','x'},
            {'o','o','x','o'},
            {'o','x','o','o'},
            {'x','o','o','o'},
            {'x','x','x','x'}
    },'2'), three(new char[][]{
            {'x','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'o','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'x','x','x','o'}
    },'3'), four(new char[][]{
            {'o','o','x','x','o'},
            {'o','x','o','x','o'},
            {'o','x','o','x','o'},
            {'x','o','o','x','o'},
            {'x','x','x','x','x'},
            {'o','o','o','x','o'},
            {'o','o','o','x','o'}
    },'4'), five(new char[][]{
            {'x','x','x','x'},
            {'x','o','o','o'},
            {'x','o','o','o'},
            {'x','x','x','o'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'x','x','x','o'}
    },'5'), six(new char[][]{
            {'o','x','x','x'},
            {'x','o','o','o'},
            {'x','o','o','o'},
            {'x','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    },'6'), seven(new char[][]{
            {'x','x','x','x'},
            {'o','o','o','x'},
            {'o','o','o','x'},
            {'o','o','x','o'},
            {'o','o','x','o'},
            {'o','x','o','o'},
            {'o','x','o','o'}
    },'7'), eight(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    },'8') , nine(new char[][]{
            {'o','x','x','o'},
            {'x','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','x'},
            {'o','o','o','x'},
            {'x','o','o','x'},
            {'o','x','x','o'}
    },'9') , QUESTION(new char[][]{
            {'o','x','x','x','o'},
            {'x','o','o','o','x'},
            {'o','o','o','o','x'},
            {'o','o','o','x','o'},
            {'o','o','x','o','o'},
            {'o','o','o','o','o'},
            {'o','o','x','o','o'}
    },'?');



    char[][] c;
    int length;
    char ch;

    public int getLength() {
        return length;
    }

    numbers(char[][] c, char ch){
        this.c = c;
        this.length = c[0].length;
        this.ch = ch;
    }
    public char[][] getValue(){
        return c;
    }

    

    static public numbers getByChar(char i){
       
       
       
       
       return QUESTION;
    }
}

