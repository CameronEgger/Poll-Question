//Cameron Egger
//Date- ??? sometime in march/april?
//Survey

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Simple 
{

    public static void main(String[]args)throws IOException
    {
    	ArrayList<Question> list=new ArrayList<Question>();
    	ArrayList<Poll> list2=new ArrayList<Poll>();
    	Poll p= new Poll("What is your favorite color?");
    	list2.add(p);
    	p= new Poll("Who is your favorite Teacher?");
    	list2.add(p);
    	p= new Poll("How many siblings do you have?");
    	list2.add(p);
    	p= new Poll("What is your favorite class?");
    	list2.add(p);
    	p= new Poll("What do you like to do in your free time?");
    	list2.add(p);
    	p= new Poll("Who is the best guy over here?");
    	list2.add(p);
    	p= new Poll("Did you like our demo?");
    	list2.add(p);
    	p= new Poll("Do you want to learn more about Computer Science?");
    	list2.add(p);
    	p= new Poll("Are you good at Math?");
    	list2.add(p);
    	p= new Poll("Had you considered Computer Science before today?");
    	list2.add(p);
    	p= new Poll("On a scale of 1-10, how likely are you to join Computer Science?");
    	list2.add(p);
    	p= new Poll("Did you know the Average Starting Salary for a Computer Scientist is around $80,000?");
    	list2.add(p);
    	p= new Poll("Would you like to build a robot one day?");
    	list2.add(p);
    	p= new Poll("If you didn't have any electronics, because no one decided to enter the field of Computer Science, what would you do with your free time?");
    	list2.add(p);
    	p= new Poll("Did you know that there are currently more jobs for Computer Science than people to fill them?");
    	list2.add(p);
    	p= new Poll("Knowing what you do, do you think you are suited for Computer Science?");
    	list2.add(p);
    	list.add(new Question("What is 2+2","4"));
    	list.add(new Question("Who won the Super Bowl this year?(Team and Mascot)","Denver Broncos"));
    	list.add(new Question("Which 4A school has 4 State Championships in Computer Science?","Needville"));
    	list.add(new Question("What is 3*6","18"));
    	list.add(new Question("Who has more State Championships, Computer Science or Volleyball?","Neither, they are tied at 4 each"));
    	list.add(new Question("What is the fastest growing industry on the market?","Computer Science"));
    	list.add(new Question("What is the name of the person doing most of the talking here?","Cameron"));
    	list.add(new Question("How many years in a row has Needville Won State Computer Science","3"));
    	list.add(new Question("What is the Schools Mascot","Bluejay"));
    	list.add(new Question("What is 12/6","2"));
    	list.add(new Question("Will you join Computer Science in High School","Yes"));
    	list.add(new Question("What is 3-6","-3"));
    	while(true)
    	{
    		Scanner key=new Scanner(in);
    		int random=(int)(Math.random()*2);
    		if(random==0)
    		{
    			random=(int)(Math.random()*list.size());
    			out.println(list.get(random).Q());
    			String ans=key.nextLine();
    			if(ans.equalsIgnoreCase(list.get(random).ans()))
    				out.println("That is correct!");
    			else
    				out.println("That is incorrect, the correct answer is "+list.get(random).ans());
    		}
    		else
    		{
    			out.println("This is a poll.");
    			random=(int)(Math.random()*list2.size());
    			out.println(list2.get(random));
    			p=list2.get(random);
    			String ans=key.nextLine();
    			if(p.map.containsKey(ans)&&p.map.get(ans)!=0)
    			{
    				p.map.put(ans,p.map.get(ans)+1);
    				out.println("You and "+(p.map.get(ans)-1)+" other people answered the same!");
    			}
    			else
    			{
    				p.map.put(ans,1);
    				out.println("You were the first person with that answer!");
    			}
    		}
    		out.println();
    	}
    }
    
}

class Question
{
	String quest, answer;

	public Question(String q, String ans)
	{
		quest=q;
		answer=ans;
	}
	
	public String ans()
	{
		return answer;
	}
	
	public String Q()
	{
		return quest;
	}
	
	public String toString()
	{
		return "["+quest+":"+answer+"]";
	}
}

class Poll implements Comparable<Poll>
{
	TreeMap<String, Integer>map;
	String question;
	public Poll(String q)
	{
		map=new TreeMap<String,Integer>();
		question=q;
	}
	public int compareTo(Poll p)
	{
		return question.compareTo(p.question);
	}
	public String toString()
	{
		return question;
	}
}