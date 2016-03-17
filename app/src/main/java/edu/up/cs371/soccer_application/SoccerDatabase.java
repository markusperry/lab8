package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {


    protected Hashtable<String,SoccerPlayer> table = new Hashtable<String,SoccerPlayer>();
    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {

        String playernName = firstName+"##"+lastName;
        if (table.containsKey(playernName))
        {
            return false;
        }
        SoccerPlayer s = new SoccerPlayer(firstName,lastName,uniformNumber,teamName);
        table.put(playernName,s);
        return true;
	}

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            table.remove(temp);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {

        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
           return pl;
        }
        else {
            return null;
        }
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
       String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpGoals();
            return true;
        }
        return false;
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpAssists();
            return true;
        }
        return false;
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpShots();
            return true;
        }
        return false;
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpSaves();
            return true;
        }
        return false;
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpFouls();
            return true;
        }
        return false;
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpYellowCards();
            return true;
        }
        return false;
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String temp = firstName+"##"+lastName;
        if (table.containsKey(temp))
        {
            SoccerPlayer pl = table.get(temp);
            pl.bumpRedCards();
            return true;
        }
        return false;
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {
        if (teamName==null)
        {
            return table.size();
        }
        else
        {
            int sum=0;
            for (SoccerPlayer s: table.values())
            {
                if (s.getTeamName().equals(teamName))
                {
                    sum++;
                }
            }
            return sum;
        }
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        ArrayList<SoccerPlayer> list = new ArrayList<SoccerPlayer>();

        if (teamName==null)
        {
            for (SoccerPlayer s: table.values())
            {
                list.add(s);
            }
            if (idx>=list.size())
            {
                return null;
            }
            return list.get(idx);
        }
        else {
            for (SoccerPlayer s : table.values()) {
                if (s.getTeamName().equals(teamName)) {
                    list.add(s);
                }
            }
            if (idx >= list.size()) {
                return null;
            }
            return list.get(idx);
        }
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        try {
            Scanner reader = new Scanner(file);
            String fName;
            String lName;
            String teamN;
            int uniNum;
            int gooooooaaall;
            int asst;
            int shts;
            int svs;
            int fls;
            int y;
            int r;

            do  {
                fName = reader.nextLine();
                if (fName==null)
                {
                    break;
                }
                lName = reader.nextLine();
                teamN = reader.nextLine();
                uniNum = Integer.parseInt(reader.nextLine());
                gooooooaaall = Integer.parseInt(reader.nextLine());
                asst = Integer.parseInt(reader.nextLine());
                shts = Integer.parseInt(reader.nextLine());
                svs = Integer.parseInt(reader.nextLine());
                fls = Integer.parseInt(reader.nextLine());
                y = Integer.parseInt(reader.nextLine());
                r = Integer.parseInt(reader.nextLine());

                SoccerPlayer temp = new SoccerPlayer(fName, lName, uniNum, teamN);
                for (int i=0;i<gooooooaaall; i++)
                {
                    temp.bumpGoals();
                }
                for (int i=0; i<asst; i++)
                {
                    temp.bumpAssists();
                }
                for (int i=0; i<shts; i++)
                {
                    temp.bumpShots();
                }
                for (int i=0; i<svs; i++)
                {
                    temp.bumpSaves();
                }
                for (int i=0; i<fls; i++)
                {
                    temp.bumpFouls();
                }
                for (int i=0; i<y; i++)
                {
                    temp.bumpYellowCards();
                }
                for (int i=0; i<r; i++)
                {
                    temp.bumpRedCards();
                }
                table.put(fName + "##" + lName, temp);
            }while(reader.hasNextLine());
            reader.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {
        try {
            PrintWriter pw = new PrintWriter(file);

            for (SoccerPlayer s: table.values())
            {
                pw.println(s.getFirstName());
                pw.println(s.getLastName());
                pw.println(s.getTeamName());
                pw.println(s.getUniform());
                pw.println(s.getGoals());
                pw.println(s.getAssists());
                pw.println(s.getShots());
                pw.println(s.getSaves());
                pw.println(s.getFouls());
                pw.println(s.getYellowCards());
                pw.println(s.getRedCards());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        HashSet<String> thing = new HashSet<String>();

        for (SoccerPlayer s: table.values())
        {
            if (!thing.contains(s.getTeamName()))
            {
                thing.add(s.getTeamName());
            }
        }

        return thing;
	}


}
