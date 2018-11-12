class Driver
{
        // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );

        /*if( NUMS < 40 )
            t.printTree( );*/
        /*if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );*/

        for( int i = 2; i < NUMS; i+=2 )
             if( !t.contains( i ) )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }

        //t.printInOrder();




        BinarySearchTree<Word> t2 = new BinarySearchTree<Word>( );


        Word w1 = new Word("p", 6);
        Word w2 = new Word("x", 5);

        t2.insert(w1);
        t2.insert(w2);

        t2.printInOrder();
        System.out.println(args[0]);
        System.out.println(args[1]);


        //System.out.println(w1.compareTo(w2));
        //System.out.println(w1.equals(w2));
    }
}