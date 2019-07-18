package com.example.testdoang;

import java.util.ArrayList;

public class AvengersData {
    public static String[][] data = new String[][]{
            {"Steve Rogers ( Captain America )", "a World War II veteran, a founding member of the Avengers, and Earth's first known superhero. ", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/d/d7/CapAmerica-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423175339", "Captain America"},
            {"Tony Stark ( Iron Man )", "a billionaire industrialist, inventor, a founding member of the Avengers, and the former CEO of Stark Industries, a company originally started by his father, Howard Stark.", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/3/35/IronMan-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423175213", "Iron Man"},
            {"Bruce Banner ( Hulk ) ", "a renowned scientist and a founding member of the Avengers. As someone who was highly respected for his work regarding biochemistry, nuclear physics, and gamma radiation.", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/e/e8/BruceBanner-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423175054", "Hulk"},
            {"Thor Odinson ( Thor ) ", " the former King of New Asgard, a founding member of the Avengers, and the God of Thunder. When his irresponsible and impetuous behavior reignited a conflict between Asgard and Jotunheim", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/1/13/Thor-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423174911", "Thor"},
            {"Natasha Rumanoff ( Black Widdow )", "One of the most talented spies and assassins in the entire world and a founding member of the Avengers.", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/9/9a/BlackWidow-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423174842", "Black Widdow"},
            {"Clint Barton ( Hawkeye || Ronin ) ", "a skilled marksman, a former special agent of S.H.I.E.L.D. and one of the founding members of the Avengers.", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/0/08/HawkeyeRonin-EndgameProfile.jpg/revision/latest/scale-to-width-down/310?cb=20190423175147", "Hawkeye || Ronin"}
    };


    public static ArrayList<Avengers> getListData() {
        Avengers avengers = null;
        ArrayList<Avengers> list = new ArrayList<>();
        for (String[] aData : data) {
            avengers = new Avengers();
            avengers.setName(aData[0]);
            avengers.setDesc(aData[1]);
            avengers.setPhoto(aData[2]);
            avengers.setNick(aData[3]);

            list.add(avengers);
        }
        return list;
    }
}
