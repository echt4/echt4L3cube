
 /*
  * Group-ECHT 4 !
 * Problem Statement-Log analyzer (weblog.txt)
  */


package filehnadling;
import java.io.*;
import java.util.*;

public class javaLogAnalyser extends javax.swing.JFrame {
        String name;
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
        ArrayList<String> browser=new ArrayList<String>();
        Set<String> uniquebrowser;
        Set<String> uniqueip;
        Set<String> virtual_domains;
        Set<String> uniquepages;
        Set<String> uniqueimg;
        Set<String> uniqueref;
        int three=0,four=0,five=0;
        HashMap hm=new HashMap();
        HashMap ip_dates=new HashMap();
        HashMap top_refere=new HashMap();
        HashMap spider_count=new HashMap();
        HashMap browser_count=new HashMap();
        int lineno=0;
    public javaLogAnalyser() {
        initComponents();
    }
     public javaLogAnalyser(String file_name)throws IOException {
         name=file_name;
          initComponents();
          BufferedReader br=new BufferedReader(new FileReader(name));
        
       
        while((lineX=br.readLine())!=null)
        {
         
           ip=lineX.split("-",2);//separating ip's and rest of the string
            //System.out.println(ip[0]);
           ar.add(ip[0]);
            
           ip[1].trim();
           
           date=ip[1].split(" ",7);//consist date and rest part of the line
           
         
           da=date[2].split(":",2);
           dates.add(da[1].substring(3,5));
             System.out.println(da[1].substring(3, 5));
           website.add(date[5]);
           
           page=date[5].split("/",2);//separating websites and pages of it
           pages.add(page[1]);
           domain.add(page[0]);
           //System.out.println(page[1]);
           err=date[6].split(" ",5);
           //System.out.println(err[3]);
           error.add(err[1]);
           user_agent.add(err[4]);
           refere.add(err[3]);
           brow=err[4].split("/",2);
           browser.add(brow[0].substring(1));
            lineno++;
        }
        int win=0;
        for(String s:user_agent)
        {
            if(s.matches("(.*)Windows NT 5.1(.*)"))
                win++;
        }
        for(String s :pages)
        {
            if(s.matches("(.*)png"))
                images.add(s);
            if(s.matches("(.*)jpg"))
                images.add(s);
            if(s.matches("(.*).gif"))
                images.add(s);
                
        }
        int count;
        
        //for(String s :images)
           // System.out.println(s);
        uniqueimg=new HashSet<String>(images);
        for(String s: uniqueimg)
        {
                count=1;
                
                  count=Collections.frequency(images,s);
                    hm.put(s,count);
                
        }
         Set set = hm.entrySet();
      // Get an iterator
     Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
          }
     uniqueref=new HashSet<String>(refere);
     uniquepages=new HashSet<String>(pages);
     virtual_domains=new HashSet<String>(domain);
     uniquebrowser=new HashSet<String>(browser);
     for(String s: uniquebrowser)
        {
                count=1;
                
                  count=Collections.frequency(browser,s);
                    browser_count.put(s,count);          
        }
     for(String s: virtual_domains)
        {
                count=1;
                
                  count=Collections.frequency(domain,s);
                    top_refere.put(s,count);
                
        }
        System.out.println("Windows NT users="+win);
        System.out.println("ALL IP="+ar.size());
         uniqueip=new HashSet<String>(ar);//Unique IP's
        System.out.println("Unique IP="+uniqueip.size());
        //Unique Pages
        System.out.println("ALL Pages="+pages.size());
        
        System.out.println("Unique Pages="+uniquepages.size());
        //Printing the stuff
        //Unique Pages
    // for(String s :uniquepages)
    // {
     //       System.out.println(s);
     //}
     //Finding the virtual domains
    
     System.out.println("Virtual domain");
     for(String s: virtual_domains)
     {
            System.out.println(s);
     }
        System.out.println("total number of lines="+lineno);
        System.out.println("Unique IP count: " + uniqueip.size());
    
        //counting the errors 4*,5*,3*
        
        for(String s :error)
        {
            if(s.matches("(4).*"))
                four++;
            if(s.matches("(3).*"))
                three++;
            if(s.matches("(5).*"))
                five++;
        }
        //fining the unique referre
        
        
        System.out.println("Page Not found Error="+four);
        System.out.println("Internal Server Error="+five);
        System.out.println("Redirect="+three);
       //cal_visitors();
        jLabel1.setText(name);
        jLabel8.setText(String.valueOf(uniqueip.size()));
        jLabel9.setText(String.valueOf(four+five));
        jLabel10.setText(String.valueOf(lineno));
        jLabel11.setText(String.valueOf(virtual_domains.size()));
        jLabel12.setText(String.valueOf(uniquepages.size()));
        jLabel15.setText(String.valueOf(uniqueref.size()));
        
        jLabel19.setText(String.valueOf(uniquebrowser.size()));
    }
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("Unique IP's");

        jLabel3.setText("Errors");

        jLabel4.setText("Virtual Domain");

        jLabel5.setText("Total Hits");

        jLabel6.setText("Images");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Unique Pages");

        jButton1.setText("More Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel8");

        jButton2.setText("More Info");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("\"\"");

        jLabel11.setText("\"\"");

        jButton3.setText("More Info");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("More Info");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("\"\"");

        jLabel13.setText("Referring SITES");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel14.setText("COUNT !");

        jButton5.setText("More Info");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setText("jLabel15");

        jButton6.setText("More Info");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel16.setText("Spider");

        jButton7.setText("More Info");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel18.setText("Browser");

        jLabel19.setText("jLabel19");

        jButton8.setText("More Info");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel20.setText("Detailed Analysis !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel18)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1))
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, 0, 0, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jButton7)
                            .addComponent(jLabel17)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
for(String s :uniqueip){
                  jTextArea1.append(s+"\n");
              }
jTextArea2.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextArea2.setText("");
        int[] info=new int[3];
        jTextArea1.setText("");
        jTextArea1.append("Page Not found Error="+four+"\n");
        jTextArea1.append("Internal Server Error="+five+"\n");
         jTextArea1.append("Redirect="+three+"\n");
         info[0]=four;info[1]=five;info[2]=three;
          //Bar ab=new Bar();
          //ab.setVisible(true);
          jTextArea2.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
jTextArea2.setVisible(false);
        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextArea2.setText("");
        for(String s: virtual_domains)
        {
            jTextArea1.append(s+"\n");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
jTextArea2.setVisible(false);        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextArea2.setText("");
        for(String s :uniquepages)
        {
            jTextArea1.append(s+"\n");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
       // Images_form img=new Images_form(uniqueimg,hm);
        //img.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
jTextArea2.setVisible(true);        // TODO add your handling code here:
        jLabel15.setText(String.valueOf(virtual_domains.size()));
        jTextArea1.setText("");
        jTextArea2.setText("");
        for(String s :virtual_domains)
        {
            jTextArea1.append(s+"\n");
            
        }
         Set set = top_refere.entrySet();
      // Get an iterator
     Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
         jTextArea2.append(me.getKey()+" "+"=");
         jTextArea2.append(me.getValue()+"\n");
         
          }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jTextArea2.setVisible(true);        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextArea2.setText("");
        for(String s :uniqueimg)
        {
            jTextArea1.append(s+"\n");
        }
        
        jTextArea2.setText("");           
        Set set = hm.entrySet();
      // Get an iterator
     Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
         jTextArea2.append(me.getKey()+" ");
         jTextArea2.append(me.getValue()+"\n");
         
          }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
jTextArea2.setVisible(true);        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextArea2.setText("");
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
         if(s.matches("(.*)(Ask	Jeeves)(.*)"))
              jeev++;
        }
        spider_count.put("Googlebot",google);
        spider_count.put("Yahoo! Slurp",yahoo);
        spider_count.put("MSN bot", msn);
        spider_count.put("Exabot",exa);
        spider_count.put("AskJeevesRobot",jeev);
        int total=google+jeev+msn+yahoo+exa;
            Set set = spider_count.entrySet();
      // Get an iterator
     Iterator i1 = set.iterator();
      // Display elements
      while(i1.hasNext()) {
         Map.Entry me = (Map.Entry)i1.next();
       jTextArea1.append(me.getKey()+"\n");
         jTextArea2.append(me.getKey()+" ");
         jTextArea2.append(me.getValue()+"\n");            
        }
      
        jLabel17.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
jTextArea2.setVisible(true);
        // TODO add your handling code here:
       jTextArea1.setText("");
        jTextArea2.setText("");
        Set set = browser_count.entrySet();
      // Get an iterator
     Iterator i1 = set.iterator();
      // Display elements
      while(i1.hasNext()) {
         Map.Entry me = (Map.Entry)i1.next();
       jTextArea1.append(me.getKey()+"\n");
         jTextArea2.append(me.getKey()+" ");
         jTextArea2.append(me.getValue()+"\n");            
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new javaLogAnalyser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
