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


            /*BinarySearchTree<Word> t2 = new BinarySearchTree<Word>( );


            Word w1 = new Word("x", 6);
            Word w2 = new Word("p", 5);

            t2.insert(w1);
            t2.insert(w2);

            t2.printInOrder();*/
            System.out.println(args[0]);
            System.out.println(args[1]);

            Indexer i1 = new Indexer(args[0],args[1]);

            //i1.printIndexedTree();

            String test = "'It gives guidance to the Ri-ght, and we -have believed therein: we shall not jo'in (in worship) any \"(gods) with our Lord.";
            test = test.toLowerCase();
            test = test.replaceAll("[^a-zA-Z'-]", " ");
            test = test.replaceAll("(?<=\\s|^)'+(?=\\w)|(?<=\\w)'(?=\\s|$)|(?<=\\s|^)-(?=\\w)|(?<=\\w)-(?=\\s|$)", "");
            String[] testArr = test.split("\\s+");

            for (String a : testArr) {
                System.out.println(a);
            }


            //test = test.replaceAll("[a-zA-Z]", "");
            //test = test.replaceAll("\"[a-zA-z]*", "");
            //test = test.replaceAll(":,.", "");
            //String[]

            //System.out.println(test);


            //System.out.println("printing TREE!");
            //i1.printFilteredTree();




        }catch ( Exception e ) {
            e.printStackTrace();
        }




        //System.out.println(w1.compareTo(w2));
        //System.out.println(w1.equals(w2));
    }
}
