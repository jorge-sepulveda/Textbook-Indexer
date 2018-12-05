import java.lang.*;
import java.util.*;
class Driver
{
        // Test program
    public static void main( String [ ] args )
    {
        try{
            BinarySearchTree<Integer> t = new BinarySearchTree<>( );
            final int NUMS = 4000;
            final int GAP  =   37;

            System.out.println( "Checking... (no more output means success)" );

            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                t.insert( i );

            for( int i = 1; i < NUMS; i+= 2 )
                t.remove( i );

            if( NUMS < 40 )
                t.printInOrder();
            if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
                System.out.println( "FindMin or FindMax error!" );

            for( int i = 2; i < NUMS; i+=2 )
                 if( !t.contains( i ) )
                     System.out.println( "Find error1!" );

            for( int i = 1; i < NUMS; i+=2 )
            {
                if( t.contains( i ) )
                    System.out.println( "Find error2!" );
            }


            System.out.println("Stop word file: " +  args[0]);
            System.out.println("input file: "+args[1]);

            Indexer i1 = new Indexer(args[0],args[1]);



        }catch ( Exception e ) {
            e.printStackTrace();
        }




        //System.out.println(w1.compareTo(w2));
        //System.out.println(w1.equals(w2));
    }
}
