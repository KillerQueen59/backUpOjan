package com.example.submission2final;

import java.util.ArrayList;

public class MoviesData {
    public static String [][] data = new String[][]{
            {"Bohemian Rhapsody","October 24,2018","Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.","8.1/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"},
            {"A Star is Born","October 3,2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.","7.5/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"},
            {"Alita: Battle Angel","February 14,2019","When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.","6.7/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"},
            {"Cold Pursuit","February 8,2019","The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.","5.3/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"},
            {"Creed II","November 21,2018","Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.","6.7/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"},
            {"Fantastic Beast : the Crimes of Grindelwald","November 16,2018","Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.","6.7/10","https://image.tmdb.org/t/p/original/uyJgTzAsp3Za2TaPiZt2yaKYRIR.jpg"},
            {"Glass","January 18 ,2019","In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.","6.5/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"},
            {"Mary Queen of Scots","December 7 ,2018","In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.","6.6/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg"},
            {"Mortal Engines","December 14,2018","Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.","6.0/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/iteUvQKCW0EqNQrIVzZGJntYq9s.jpg"},
            {"Ralph Breaks the Internet","November 21,2018","Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube","7.2/10","https://image.tmdb.org/t/p/w600_and_h900_bestv2/qEnH5meR381iMpmCumAIMswcQw2.jpg"}
    };
    public static ArrayList<Movies> getListData(){
        ArrayList<Movies> list = new ArrayList<>();
        for (String[] aData:data){
            Movies movies = new Movies();
            movies.setDataTitle(aData[0]);
            movies.setDataDate(aData[1]);
            movies.setDataDesc(aData[2]);
            movies.setDataRate(aData[3]);
            movies.setDataPoster(aData[4]);

            list.add(movies);
        }
        return list;
    }
}
