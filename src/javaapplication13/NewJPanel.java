package javaapplication13;

import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NewJPanel extends javax.swing.JPanel {

    public NewJPanel() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        b = new javax.swing.JButton();
        tf = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setLayout(null);

        b.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b.setText("Generate");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m(evt);
            }
        });
        add(b);
        b.setBounds(50, 150, 90, 23);
        add(tf);
        tf.setBounds(47, 99, 207, 35);

        b1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b1.setText("Clear");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1m(evt);
            }
        });
        add(b1);
        b1.setBounds(160, 150, 90, 23);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Website Rot Link Tester");
        add(jLabel1);
        jLabel1.setBounds(47, 23, 207, 28);

        jLabel2.setText("Enter Website Link Here -");
        add(jLabel2);
        jLabel2.setBounds(47, 69, 207, 28);
    }// </editor-fold>//GEN-END:initComponents

     public ArrayList<String> generate(String url) throws Exception
    {
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://www.google.com").get();
        Elements element = doc.select("a");
        HashSet <String> hs = new  HashSet<String> () ;
        ArrayList <String> al = new  ArrayList<String> () ;
        ArrayList <String> fw = new  ArrayList<String> () ;
        for(Element ele : element)
        {
            String s1 = ele.absUrl("href");
            if(!hs.contains(s1)&&(!s1.equals("")))
            {
                hs.add(s1);
                al.add(s1);
            }
        }

        for(int i = 0 ; i < al.size() ; i++)
        {
            String temp = al.get(i);
            try
            {
                URL url1 = new URL(al.get(i));
                HttpURLConnection http = (HttpURLConnection)url1.openConnection();
                int statusCode = http.getResponseCode();
            }
            catch(Exception e)
            {
                if(!fw.contains(temp))
                {
                    fw.add(temp);
                    System.out.println(temp);
                }
            }
            if(temp.startsWith(url))
            {
                try
                {
                    Document doc1 = Jsoup.connect(temp).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://www.google.com").get();
                    Elements element1 = doc1.select("a");
                    for(Element ele : element1)
                    {
                        String s1 = ele.absUrl("href");
                        if(!hs.contains(s1))
                        {
                            hs.add(s1);
                            al.add(s1);
                        }
                    }
                }
                catch(Exception e)
                {
                if(!fw.contains(temp))
                {
                    fw.add(temp);
                    System.out.println(temp);
                }
                }
            }
        }
        return fw;

    }

    
    private void m(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m
        try
        {
            FileWriter fw = new FileWriter("Links.txt");
            NewJPanel t = new NewJPanel();
            String url = tf.getText();
            ArrayList<String> al = t.generate(url);
            for(int i = 0 ; i < al.size(); i++)
            {
                fw.append("" + al.get(i) + "\n");
                System.out.println(al.get(i));
            }
            fw.close();
        }
        catch(Exception e)
        {
            
        }   
    }//GEN-LAST:event_m

    private void b1m(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1m
        tf.setText("");
    }//GEN-LAST:event_b1m


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b;
    private javax.swing.JButton b1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
