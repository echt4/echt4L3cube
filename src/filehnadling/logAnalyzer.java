/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filehnadling;
import java.util.*;
import java.io.*;
//import filehnadling.log2;
/**
 *
 * @author mylaptop
 */
public class logAnalyzer {
   
    String lineX;
        String[] ip;
        String[] date;
        String[] page;//for storing the pages
        String[] err;
        String[] da;
        String[] brow;
        int google=0,msn1=0,cul=0,exa=0,msn=0,jeev=0,yahoo=0;
        ArrayList<String> ar=new ArrayList<String>();//ip's
        ArrayList<String> website=new ArrayList<String>();//pages and website
        ArrayList<String> pages =new ArrayList<String>();//pages
        ArrayList<String> domain =new ArrayList<String>();//domain
        ArrayList<String> error=new ArrayList<String>();//errors
        ArrayList<String> refere=new ArrayList<String>();//referer
        ArrayList<String> user_agent=new ArrayList<String>();//user_agents 
        ArrayList<String> images=new ArrayList<String>();
        ArrayList<String> dates=new ArrayList<String>();
        ArrayList<String> spider=new ArrayList<String>();
        ArrayList<String> browser=new ArrayList<String>();
        Set<String> uniquebrowser;
        Set<String> uniquespider;
        HashMap hm=new HashMap();
        HashMap ip_dates=new HashMap();
        HashMap browser_count=new HashMap();
        int lineno=0;
    public static void main(String args[])throws IOException
    {
       logAnalyzer obj =new logAnalyzer();
       obj.basic();
    }
    //Setting the stage !
    public void basic()throws IOException
    {
     BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\mylaptop\\Downloads\\weblog(1).txt"));
        
       
        while((lineX=br.readLine())!=null)
        {
         
           ip=lineX.split("-",2);//separating ip's and rest of the string
            //System.out.println(ip[0]);
           ar.add(ip[0]);
            
           ip[1].trim();
           
           date=ip[1].split(" ",7);//consist date and rest part of the line
           
         
           da=date[2].split(":",2);
           dates.add(da[1].substring(3,5));
             //System.out.println(da[1].substring(3, 5));
           website.add(date[5]);
           
           page=date[5].split("/",2);//separating websites and pages of it
           pages.add(page[1]);
           domain.add(page[0]);
           //System.out.println(page[0]);
           err=date[6].split(" ",5);
           //System.out.println(err[3]);
           error.add(err[1]);
           user_agent.add(err[4]);
           refere.add(err[3]);
           //System.out.println(err[4]);
           brow=err[4].split("/",2);
           browser.add(brow[0].substring(1));
                System.out.println(brow[0].substring(1));   
            lineno++;
        }
        int win=0;
        for(String s:user_agent)
        {
            if(s.matches("(.*)Windows NT 5.1(.*)"))
                win++;
        }
        
        for(String s:user_agent)
        {
            if(s.matches("(.*)(Googlebot)(.*)"))
                google++;
            if(s.matches("(.*)(Yahoo! Slurp)(.*)"))
                yahoo++;
          if(s.matches("(.*)(http://search.msn.com/msnbot.htm)(.*)"))
                msn++;
         if(s.matches("(.*)(exabot)(.*)"))
             exa++;
         if(s.matches("(.*)(jeeves)(.*)"))
              jeev++;
        }
        for(String s :pages)
        {
            if(s.matches("(.*)png"))
                images.add(s);
            if(s.matches("(.*)jpg"))
                images.add(s);
            if(s.matches("(.*).png"))
                images.add(s);
                
        }
        int count;
        
        //for(String s :images)
           // System.out.println(s);
        Set<String> uniqueimg=new HashSet<String>(images);
        for(String s: uniqueimg)
        {
                count=0;
                
                  count=Collections.frequency(images,s);
                    hm.put(s,count);
                
        }
        /* Set set = hm.entrySet();
      // Get an iterator
     Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
          }*/
     
        System.out.println("Windows NT users="+win);
        System.out.println("ALL IP="+ar.size());
        Set<String> uniqueip=new HashSet<String>(ar);//Unique IP's
        System.out.println("Unique IP="+uniqueip.size());
        //Unique Pages
        System.out.println("ALL Pages="+pages.size());
        Set<String> uniquepages=new HashSet<String>(pages);
        System.out.println("Unique Pages="+uniquepages.size());
        //Printing the stuff
        //Unique Pages
    // for(String s :uniquepages)
    // {
     //       System.out.println(s);
     //}
     //Finding the virtual domains
     Set<String> virtual_domains=new HashSet<String>(domain);
    /* System.out.println("Virtual domain");
     for(String s: virtual_domains)
     {
            System.out.println(s);
     }*/
        System.out.println("total number of lines="+lineno);
        System.out.println("Unique IP count: " + uniqueip.size());
    
        //counting the errors 4*,5*,3*
        int three=0,four=0,five=0;
        for(String s :error)
        {
            if(s.matches("(4).*"))
                four++;
            if(s.matches("(3).*"))
                three++;
            if(s.matches("(5).*"))
                five++;
        }
        System.out.println("Page Not found Error="+four);
        System.out.println("Internal Server Error="+five);
        System.out.println("Redirect="+three);
       //cal_visitors();
        }
    
    public void cal_visitors()
    {
        Set<String> unique_dates=new HashSet<String>(dates);
        for(String s : ar)
        {
         for(String s1 :dates)
         {
             ip_dates.put(s1,s );
             
         }
        }
        
        
    }
    }
    
    
   
    

